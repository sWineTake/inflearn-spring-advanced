package com.advanced.start.trace.threadlocal;

import com.advanced.start.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

	private FieldService fieldService = new FieldService();

	@Test
	void field() {
		log.info("main start");
		Runnable userA = () -> {
			fieldService.logic("userA");
		};
		Runnable userB = () -> {
			fieldService.logic("userB");
		};

		Thread threadA = new Thread(userA);
		threadA.setName("threadA");
		Thread threadB = new Thread(userB);
		threadB.setName("threadB");

		threadA.start();
		// 동시성 문제가 발생 하지않음
		// sleep(2000);
		sleep(100);
		threadB.start();

		sleep(2000);
		log.info("main exit");
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		}
		catch (Exception e) {
			log.info(e.toString());
		}
	}

}
