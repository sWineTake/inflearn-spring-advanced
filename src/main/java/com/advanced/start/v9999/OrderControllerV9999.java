package com.advanced.start.v9999;

import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import com.advanced.start.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV9999 {
	private final OrderServiceV9999 service;

	@GetMapping("/v9999/request")
	public String request(String itemId) {
		service.orderItem(itemId);
		return "ok";
	}


}
