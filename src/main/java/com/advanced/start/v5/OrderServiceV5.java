package com.advanced.start.v5;

import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import com.advanced.start.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {
	private final OrderRepositoryV5 repository;
	private final ThreadLocalLogTrace trace;

	public void orderItem(String itemId) {
		AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
			@Override
			public Void call() {
				repository.save(itemId);
				return null;
			}
		};
		template.execute("OrderServiceV4.orderItem()");
	}

}
