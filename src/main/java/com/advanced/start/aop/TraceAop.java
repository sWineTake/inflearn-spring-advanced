package com.advanced.start.aop;

import com.advanced.start.trace.TraceStatus;
import com.advanced.start.trace.logtrace.ThreadLocalLogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TraceAop {

	@Autowired
	ThreadLocalLogTrace trace;

	@Around("execution(* com.advanced.start.v9999..*(..))")
	public Object queryExecute(ProceedingJoinPoint joinPoint) throws Throwable {
		TraceStatus status = trace.begin(joinPoint.toString());
		Object result = joinPoint.proceed();
		trace.end(status);
		return result;
	}

}
