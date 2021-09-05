package pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


/**
 * The Class captures the FlightBookingPage.
 * @author Devi
 */
public class FlightListPage extends BasePage {
	
	//Flight lists
	@FindBys({
		@FindBy(css = "div.container > table > tbody > tr input[type=\"submit\"]")})
	public List<WebElement> flightLists;

	// Instantiates a new flight list page.
	public FlightListPage(WebDriver driver) {
		super(driver);
	}

	//select flight.
	 public FlightListPage selectFlght() {
		 Random rand = new Random();
	     int upperbound = flightLists.size();
	     int int_random = rand.nextInt(upperbound);
	     flightLists.get(int_random).click();
	     return this;
	}
	
	
}
