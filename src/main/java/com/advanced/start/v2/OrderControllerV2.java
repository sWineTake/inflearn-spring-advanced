package com.advanced.start.v2;

import com.advanced.start.trace.TraceStatus;
import com.advanced.start.trace.hellotrace.HelloTraceV1;
import com.advanced.start.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

	private final OrderServiceV2 service;
	private final HelloTraceV2 trace;

	@GetMapping("/v2/request")
	public String request(String itemId) {

		TraceStatus status = null;
		try {
			status = trace.begin("OrderControllerV2.request");
			service.orderItem(status.getTrace(), itemId);
			trace.end(status);
			return "ok";
		}
		catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}


}
