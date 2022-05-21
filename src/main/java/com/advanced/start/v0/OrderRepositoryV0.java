package com.advanced.start.v0;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

	/**
	 * 아이템 이름을 받아 저장
	 * @param itemId
	 */
	public void save(String itemId) {
		if ("ex".equals(itemId)) { // 아이템 이름이 ex일 경우 에러를 발생시킴
			throw new IllegalStateException("예외 발생!!");
		}
		sleep(1000);
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
