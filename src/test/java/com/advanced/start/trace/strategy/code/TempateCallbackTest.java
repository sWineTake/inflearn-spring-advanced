package com.advanced.start.trace.strategy.code;

import com.advanced.start.trace.strategy.code.tempate.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TempateCallbackTest {

	/**
	 * 템플릿 콜백 패턴 - 익명 내부 클래스
	 */
	@Test
	void callbackV1() {
		TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
		timeLogTemplate.execute(() -> System.out.println("비즈니스 로직 1 실행"));
		timeLogTemplate.execute(() -> System.out.println("비즈니스 로직 2 실행"));
	}

}
