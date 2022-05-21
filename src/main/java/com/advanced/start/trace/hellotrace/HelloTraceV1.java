package com.advanced.start.trace.hellotrace;

import com.advanced.start.trace.Trace;
import com.advanced.start.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV1 {
	private static final String START_PREFIX = "-->";
	private static final String COMPLETE_PREFIX = "<--";
	private static final String EX_PREFIX = "<X-";

	public TraceStatus begin(String message){
		Trace trace = new Trace();
		Long startTimeMs = System.currentTimeMillis();
		log.info("[{}] {}{}", trace.getId(), addSpace(START_PREFIX, trace.getLevel()), message);
		return new TraceStatus(trace, startTimeMs, message);
	}

	public void end(TraceStatus status) {
		complete(status, null);
	}

	public void exception(TraceStatus status, Exception e) {
		complete(status, e);
	}

	private void complete(TraceStatus status, Exception e) {
		Long stopTimeMs = System.currentTimeMillis();
		long resultTimeMs = stopTimeMs - status.getStartTimeMs();
		Trace traceId = status.getTrace();

		if (e == null) {
			log.info("[{}] {}{} time={}ms", traceId.getId(),
					addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
					resultTimeMs);
		} else {
			log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
					addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
					e.toString());
		}
	}
	private static String addSpace(String prefix, int level) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < level; i++) {
			sb.append( (i == level - 1) ? "|" + prefix : "| ");
		}
		return sb.toString();
	}


}
