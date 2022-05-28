package com.advanced.start.v3;

import com.advanced.start.trace.TraceStatus;
import com.advanced.start.trace.logtrace.LogTrace;
import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
	private final OrderRepositoryV3 repository;
	private final ThreadLocalLogTrace trace;

	public void orderItem(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderServiceV2.orderItem");
			repository.save(itemId);
			trace.end(status);
		}
		catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

}
