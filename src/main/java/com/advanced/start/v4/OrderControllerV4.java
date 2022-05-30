package com.advanced.start.v4;

import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import com.advanced.start.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {
	private final OrderServiceV4 service;
	private final ThreadLocalLogTrace trace;

	@GetMapping("/v4/request")
	public String request(String itemId) {
		AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
			@Override
			public String call() {
				service.orderItem(itemId);
				return "ok";
			}
		};
		return template.execute("OrderControllerV4.request()");
	}


}
