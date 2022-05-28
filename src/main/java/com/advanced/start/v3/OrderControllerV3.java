package com.advanced.start.v3;

import com.advanced.start.trace.TraceStatus;
import com.advanced.start.trace.logtrace.LogTrace;
import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {
	private final OrderServiceV3 service;
	private final ThreadLocalLogTrace trace;

	@GetMapping("/v3/request")
	public String request(String itemId) {

		TraceStatus status = null;
		try {
			status = trace.begin("OrderControllerV2.request");
			service.orderItem(itemId);
			trace.end(status);
			return "ok";
		}
		catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}


}
