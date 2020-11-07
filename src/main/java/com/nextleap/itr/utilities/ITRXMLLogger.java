package com.nextleap.itr.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ITRXMLLogger {


	private Logger logger;

	ITRXMLLogger(@SuppressWarnings("rawtypes") Class clazz){
		this.logger = LogManager.getLogger(clazz);
	}

	
	@SuppressWarnings("rawtypes")
	public static ITRXMLLogger getLogger(Class clazz) {
		return new ITRXMLLogger(clazz);
	}
	
	public void info(Object message) {
		logger.info(message);
	}

	public void error(Object message) {
		logger.error(message);
	}

	public void error(String message, Throwable t)
	{
		logger.error(message, t);
	}

	
	public void debug(Object message)
	{
		if(logger.isDebugEnabled()) {
			logger.debug(message);
		}
	}


}
