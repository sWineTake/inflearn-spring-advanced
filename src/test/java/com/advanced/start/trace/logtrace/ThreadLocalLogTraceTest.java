package com.advanced.start.trace.logtrace;

import com.advanced.start.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

	ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

	@Test
	void begin_end_level2() {
		TraceStatus trace1 = trace.begin("hello1");
		TraceStatus trace2 = trace.begin("hello2");
		trace.end(trace2);
		trace.end(trace1);
	}

	@Test
	void begin_exception_level2() {
		TraceStatus trace1 = trace.begin("hello1");
		TraceStatus trace2 = trace.begin("hello2");
		trace.exception(trace2, new Exception());
		trace.exception(trace1, new Exception());

	}
}
