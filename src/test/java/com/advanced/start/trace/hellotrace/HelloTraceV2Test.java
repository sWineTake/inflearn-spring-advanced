package com.advanced.start.trace.hellotrace;

import com.advanced.start.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV2Test {

	@Test
	void begin_end() {
		HelloTraceV2 trace = new HelloTraceV2();
		TraceStatus status1 = trace.begin("hello");
		TraceStatus status2 = trace.beginSync(status1.getTrace(), "hello2");
		trace.end(status2);
		trace.end(status1);
	}

	@Test
	void beginException() {
		HelloTraceV2 trace = new HelloTraceV2();
		TraceStatus status1 = trace.begin("hello1");
		TraceStatus status2 = trace.beginSync(status1.getTrace(), "hello2");
		trace.exception(status2, new IllegalStateException());
		trace.exception(status1, new IllegalStateException());
	}

}
