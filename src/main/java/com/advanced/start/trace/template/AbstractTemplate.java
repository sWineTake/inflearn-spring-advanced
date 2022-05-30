package com.advanced.start.trace.template;

import com.advanced.start.trace.TraceStatus;
import com.advanced.start.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate<T> {

	private final LogTrace trace;
	public AbstractTemplate(LogTrace logTrace) {
		this.trace = logTrace;
	}

	public T execute(String message) {
		TraceStatus status = null;
		try {
			status = trace.begin(message);

			// 로직 호출
			T result = call();

			trace.end(status);
			return result;
		}
		catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

	public abstract T call();

}
