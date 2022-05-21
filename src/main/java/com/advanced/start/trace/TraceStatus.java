package com.advanced.start.trace;

import lombok.Getter;

@Getter
public class TraceStatus {
	private Trace trace;
	private Long startTimeMs;
	private String message;

	public TraceStatus(Trace trace, Long startTimeMs, String message) {
		this.trace = trace;
		this.startTimeMs = startTimeMs;
		this.message = message;
	}
}
