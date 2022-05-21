package com.advanced.start.trace.hellotrace;

import com.advanced.start.trace.TraceStatus;
import org.junit.jupiter.api.Test;


class HelloTraceV1Test {

	@Test
	void begin_end() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.end(status);
	}

	@Test
	void beginException() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.exception(status, new IllegalStateException());
	}

}
