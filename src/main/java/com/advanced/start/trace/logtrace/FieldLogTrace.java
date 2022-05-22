package com.advanced.start.trace.logtrace;

import com.advanced.start.trace.Trace;
import com.advanced.start.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FieldLogTrace implements LogTrace{
	private static final String START_PREFIX = "-->";
	private static final String COMPLETE_PREFIX = "<--";
	private static final String EX_PREFIX = "<X-";

	// Trace동기화, 동시성 이슈 발생
	private Trace traceHolder;

	@Override
	public TraceStatus begin(String message) {
		syncTrace();
		Trace trace = traceHolder;
		Long startTimeMs = System.currentTimeMillis();
		log.info("[{}] {}{}", trace.getId(), addSpace(START_PREFIX, trace.getLevel()), message);
		return new TraceStatus(trace, startTimeMs, message);
	}

	private void syncTrace() {
		if (traceHolder == null) {
			traceHolder = new Trace();
		}
		else {
			traceHolder = traceHolder.createNextId();
		}
	}

	@Override
	public void end(TraceStatus status) {
		complete(status, null);
	}

	@Override
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
		releaseTrace();
	}

	private void releaseTrace() {
		if (traceHolder.isFirstLevel()) {
			traceHolder = null;
		}
		else {
			traceHolder = traceHolder.createPreviousId();
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
