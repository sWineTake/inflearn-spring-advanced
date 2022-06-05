package com.advanced.start.trace.callback;


import com.advanced.start.trace.TraceStatus;
import com.advanced.start.trace.logtrace.LogTrace;
import org.springframework.stereotype.Component;

@Component
public class TraceTemplate {

	public <T> T execute(String message, TraceCallBack<T> callBack, LogTrace trace) {
		TraceStatus status = null;
		try {
			status = trace.begin(message);

			// 로직 호출
			T result = callBack.call();

			trace.end(status);
			return result;
		}
		catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

}
