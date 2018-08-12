package com.myself.logger;

import org.apache.log4j.Priority;
import org.apache.log4j.RollingFileAppender;

/**
 * @author zhanghong
 *
 */
public class LoggerAppender extends RollingFileAppender {

	@Override
	public boolean isAsSevereAsThreshold(Priority priority) {
		return getThreshold().equals(priority);
	}
	
}
