package com.advanced.start.trace.strategy;

import com.advanced.start.trace.strategy.code.strategy.ContextV1;
import com.advanced.start.trace.strategy.code.strategy.StrategyLogic1;
import com.advanced.start.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

	@Test
	void strategyV1() {
		StrategyLogic1 logic1 = new StrategyLogic1();
		ContextV1 context1 = new ContextV1(logic1);
		context1.execute();

		StrategyLogic2 logic2 = new StrategyLogic2();
		ContextV1 context2 = new ContextV1(logic2);
		context2.execute();
	}

}
