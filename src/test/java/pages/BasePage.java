package pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

/**
 * This Base Class should be extended by the other Class 
 * @author Devi
 */
public class BasePage {

	// The driver
	protected WebDriver driver;

	// The waiter
	protected FluentWait<WebDriver> waiter;

	//Instantiates a new base page.
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
	}

}
