package com.advanced.start;

import com.advanced.start.trace.logtrace.FieldLogTrace;
import com.advanced.start.trace.logtrace.LogTrace;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
public class LogTraceConfig {

	/*@Bean
	public LogTrace logTrace() {
		return new FieldLogTrace();
	}*/

}
