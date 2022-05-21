package com.advanced.start.v2;

import com.advanced.start.trace.Trace;
import com.advanced.start.trace.TraceStatus;
import com.advanced.start.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

	private final HelloTraceV2 traceV2;

	/**
	 * 아이템 이름을 받아 저장
	 *
	 * @param trace
	 * @param itemId
	 */
	public void save(Trace trace, String itemId) {
		TraceStatus status = null;
		try {
			status = traceV2.beginSync(trace,"OrderRepositoryV2.save");
			// 저장로직
			if ("ex".equals(itemId)) { // 아이템 이름이 ex일 경우 에러를 발생시킴
				throw new IllegalStateException("예외 발생!!");
			}
			sleep(1000);

			traceV2.end(status);
		}
		catch (Exception e) {
			traceV2.exception(status, e);
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
