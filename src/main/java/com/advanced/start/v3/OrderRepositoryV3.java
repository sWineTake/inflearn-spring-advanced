package com.advanced.start.v3;

import com.advanced.start.trace.TraceStatus;
import com.advanced.start.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

	private final LogTrace trace;

	/**
	 * 아이템 이름을 받아 저장
	 * @param itemId
	 */
	public void save(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderRepositoryV2.save");
			// 저장로직
			if ("ex".equals(itemId)) { // 아이템 이름이 ex일 경우 에러를 발생시킴
				throw new IllegalStateException("예외 발생!!");
			}
			sleep(1000);

			trace.end(status);
		}
		catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
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
