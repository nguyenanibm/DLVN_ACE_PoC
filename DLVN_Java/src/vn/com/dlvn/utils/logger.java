package vn.com.dlvn.utils;

import org.slf4j.LoggerFactory;

public class logger {
	public static void log(String loggerName, String logType, String content) {
		org.slf4j.Logger logger = LoggerFactory.getLogger(loggerName);

		switch (logType) {
		case "INFO":
			logger.info(content);
			break;
		case "DEBUG":
			logger.debug(content);
			break;
		case "ERROR":
			logger.error(content);
			break;
		default:
			logger.info(content);
		}
	}
}
