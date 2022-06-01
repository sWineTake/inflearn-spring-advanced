package com.advanced.start.trace.strategy;

import com.advanced.start.trace.strategy.code.strategy.ContextV2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

	@Test
	void StrategyV2() {
		ContextV2 context = new ContextV2();
		context.execute(() -> log.info("비즈니스 로직 1 실행"));
		context.execute(() -> log.info("비즈니스 로직 2 실행"));

	}

}
