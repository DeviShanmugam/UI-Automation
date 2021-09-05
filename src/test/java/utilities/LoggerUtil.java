package utilities;

import org.apache.log4j.Logger;

import reporting.LogListener;

/**
 * The Class has all Logging related utilities.
 * @author Devi
 */
public class LoggerUtil {

	 //The logger
	private static Logger logger = Logger.getLogger(LogListener.class);

	// Log.
	public static void log(String message) {
		logger.info(message);
	}

	// Gets the logger.
	public static Logger getLogger() {
		return logger;
	}
}
