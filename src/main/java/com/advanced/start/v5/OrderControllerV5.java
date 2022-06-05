package com.advanced.start.v5;

import com.advanced.start.trace.callback.TraceCallBack;
import com.advanced.start.trace.callback.TraceTemplate;
import com.advanced.start.trace.logtrace.LogTrace;
import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {
	private final OrderServiceV5 service;
	private final ThreadLocalLogTrace trace;
	private final TraceTemplate template;

	@GetMapping("/v5/request")
	public String request(String itemId) {
		return template.execute("OrderControllerV5.request();", () -> {
			service.orderItem(itemId);
			return "ok";
		}, trace);
	}


}
