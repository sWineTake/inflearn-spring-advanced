package com.advanced.start.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {
	private final OrderRepositoryV0 repository;

	public String orderItem(String itemId) {
		repository.save(itemId);
		return "ok";
	}

}
