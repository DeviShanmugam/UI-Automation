package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.FlightBookingPage;
import pages.FlightListPage;
import pages.FlightPurchasePage;
import utilities.PageinstancesFactory;
import utilities.ReportUtil;

/**
 * The Class FlightBookingTest.
 * @author Devi
 */

//Test steps

@Test(testName = "Book a flight", description = "Book a flight and verify the order id")
public class FlightBookingTest extends Driver {

	@Test
	public void ChooseFlight() {
		driver.get("https://blazedemo.com/");
		FlightBookingPage flightBookingPage = PageinstancesFactory.getInstance(FlightBookingPage.class);
		flightBookingPage.selectDepartureCity("Mexico City").selectDestinationCity("New York").clickFindFlights();
	
		FlightListPage flightListPage=PageinstancesFactory.getInstance(FlightListPage.class);
		Assert.assertTrue(flightListPage.flightLists.size()>0, "Flights search list failed : Test failed");
		ReportUtil.logMessage(LogStatus.PASS,"Departure and destination cities are selected","PASS");
		flightListPage.selectFlght();
		
		FlightPurchasePage flightPurchasePage=PageinstancesFactory.getInstance(FlightPurchasePage.class);
		Assert.assertTrue(flightPurchasePage.PurchaseFlight.isDisplayed(), "selection of flight : Test failed");
		ReportUtil.logMessage(LogStatus.PASS,"Flight is selected for destinated cities","PASS");
		Assert.assertTrue(flightPurchasePage.PassengerName.isDisplayed(), "Enter Passenger details: Test failed");
		
		flightPurchasePage.enterPassengerDetails();
		ReportUtil.logMessage(LogStatus.PASS,"Passenger details are entered","PASS");
		flightPurchasePage.validateOrderConfirmation();
		ReportUtil.logMessage(LogStatus.PASS,"Flight is purchased of ORDER_ID:"+flightPurchasePage.OrderId.getText(),"PASS");
		
	}
	
}
