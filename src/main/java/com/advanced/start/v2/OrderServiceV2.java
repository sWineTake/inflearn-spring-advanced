package com.advanced.start.v2;

import com.advanced.start.trace.Trace;
import com.advanced.start.trace.TraceStatus;
import com.advanced.start.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
	private final OrderRepositoryV2 repository;
	private final HelloTraceV2 traceV2;

	public void orderItem(Trace trace, String itemId) {
		TraceStatus status = null;
		try {
			status = traceV2.beginSync(trace, "OrderServiceV2.orderItem");
			repository.save(status.getTrace(), itemId);
			traceV2.end(status);
		}
		catch (Exception e) {
			traceV2.exception(status, e);
			throw e;
		}
	}

}
