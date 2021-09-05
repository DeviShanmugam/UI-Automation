package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

/**
 * The Class captures the FlightBookingPage.
 * @author Devi
 */
public class FlightBookingPage extends BasePage {

	// Choose your departure city: dropdown.
	@FindBy(css = "select[name=\"fromPort\"]")
	private WebElement chooseDepartureCity;

	// Choose your destination city: dropdown
	@FindBy(css = "select[name=\"toPort\"]")
	private WebElement chooseDestinationCity;
	
	//Find Flights: button.
	@FindBy(css = "input[type=\"submit\"]")
	private WebElement findFlights;

	//Instantiates a new flight book page.
	public FlightBookingPage(WebDriver driver) {
		super(driver);
	}
	
	// select departure.
	public FlightBookingPage selectDepartureCity(String departureCity) {
		Select departureCitydpdwn=new Select(chooseDepartureCity);
		departureCitydpdwn.selectByVisibleText(departureCity);
		return this;
	}
	
	//select destination.
	 public FlightBookingPage selectDestinationCity(String destinationCity) {
		Select destinationCitydpdwn=new Select(chooseDestinationCity);
		destinationCitydpdwn.selectByVisibleText(destinationCity);
		return this;
	}

	//Click sign in.
	public void clickFindFlights() {
		findFlights.submit();
	}
}
