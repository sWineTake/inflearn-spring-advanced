package com.advanced.start.trace;

import lombok.Getter;
import java.util.UUID;

@Getter
public class Trace {
	private String id;
	private int level;

	public Trace() {
		this.id = createId();
		this.level = 0;
	}

	private Trace(String id, int level) {
		this.id = id;
		this.level = level;
	}

	private String createId() {
		// UUID가 너무길어서 초반에 몇글자 짜름
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public Trace createNextId() {
		return new Trace(id, level + 1);
	}

	public Trace createPreviousId() {
		return new Trace(id, level - 1);
	}

	public boolean isFirstLevel() {
		return level == 0;
	}

}
