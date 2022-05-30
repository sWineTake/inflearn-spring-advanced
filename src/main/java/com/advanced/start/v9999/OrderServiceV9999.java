package com.advanced.start.v9999;

import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import com.advanced.start.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV9999 {
	private final OrderRepositoryV9999 repository;

	public void orderItem(String itemId) {
		repository.save(itemId);
	}

}
