package com.advanced.start.v5;

import com.advanced.start.trace.callback.TraceCallBack;
import com.advanced.start.trace.callback.TraceTemplate;
import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import com.advanced.start.trace.template.AbstractTemplate;
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

	@GetMapping("/v5/request")
	public String request(String itemId) {
		TraceTemplate traceTemplate = new TraceTemplate(trace);
		traceTemplate.execute("OrderControllerV5.request();",
			(TraceCallBack<Void>) () -> {
				service.orderItem(itemId);
				return null;
			}
		);
		return "ok";
	}


}
