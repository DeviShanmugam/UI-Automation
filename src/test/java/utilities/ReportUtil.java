package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;

import reporting.ExtentReportManager;

/**
 * The Class is responsible for Reporting
 * @author Devi
 */
public class ReportUtil {

	// Adds the screen shot.
	public static void addScreenShot(String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message,
				ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
	}

	// Adds the screen shot.
	public static void addScreenShot(LogStatus status, String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(status, message,
				ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
	}
	
	// Logs test step status.
	public static void logMessage(String message, String details) {
		ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message, details);
	}
	
	// Logs test step status.
	public static void logMessage(LogStatus status, String message, String details) {
		ExtentReportManager.getCurrentTest().log(status, message, details);
	}
}
