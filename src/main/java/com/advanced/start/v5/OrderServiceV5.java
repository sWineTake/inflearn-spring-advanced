package com.advanced.start.v5;

import com.advanced.start.trace.callback.TraceCallBack;
import com.advanced.start.trace.callback.TraceTemplate;
import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import com.advanced.start.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {
	private final OrderRepositoryV5 repository;
	private final ThreadLocalLogTrace trace;
	private final TraceTemplate template;

	public void orderItem(String itemId) {
		template.execute("OrderServiceV5.orderItem()", (TraceCallBack<Void>) () -> {
			repository.save(itemId);
			return null;
		}, trace);
	}

}
