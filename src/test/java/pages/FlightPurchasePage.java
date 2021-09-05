package pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


/**
 * The Class represents FlightPurchasePage.
 * @author Devi
 */
public class FlightPurchasePage extends BasePage {
	
	// Passenger details
	@FindBy(id = "inputName")
	public WebElement PassengerName;
	
	@FindBy(id = "address")
	public WebElement PassengerAddress;
	
	@FindBy(id = "city")
	public WebElement PassengerCity;
	
	@FindBy(id = "state")
	public WebElement PassengerState;
	
	@FindBy(id = "zipCode")
	public WebElement PassengerZipCode;
	
	@FindBy(id = "cardType")
	public WebElement PassengerCardType;
	
	@FindBy(id = "creditCardNumber")
	public WebElement PassengerCardNumber;
	
	@FindBy(id = "creditCardMonth")
	public WebElement PassengerCardMonth;
	
	@FindBy(id = "creditCardYear")
	public WebElement PassengerCardYear;	
	
	@FindBy(id = "nameOnCard")
	public WebElement PassengerNameOnCard;
	
	@FindBy(css="input[value=\"Purchase Flight\"]")
	public WebElement PurchaseFlight;
	
	@FindBy(css="p:nth-child(7) > em")
	public WebElement TotalCost;
	
	@FindBy(css="tbody > tr:nth-child(1) > td:nth-child(2)")
	public WebElement OrderId;
	
	@FindBy(css="tbody > tr:nth-child(2) > td:nth-child(2)")
	public WebElement OrderStatus;
	
	
	private String expectedCost;
	
	//Instantiates a new flight purchase page
	
	public FlightPurchasePage(WebDriver driver) {
		super(driver);
	}
	
	//enter passenger details
	
	public FlightPurchasePage enterPassengerDetails() {	
		expectedCost=TotalCost.getText();
		PassengerName.sendKeys("User1");
		PassengerAddress.sendKeys("3 xxy street");
		PassengerCity.sendKeys("TestCity");
		PassengerState.sendKeys("TestState");
		PassengerZipCode.sendKeys("123456");
		Select cardType=new Select(PassengerCardType);
		cardType.selectByVisibleText("Visa");
		PassengerCardNumber.sendKeys("9854486654");
		PassengerNameOnCard.sendKeys("User1");
		PurchaseFlight.click();
		return this;
	}
	
	// Verify order details
	
	public  FlightPurchasePage  validateOrderConfirmation() {
		Assert.assertTrue(OrderId.isDisplayed(),"Flight ticket is not booked");
		System.out.println("Flight order id:"+OrderId.getText());
		return this;		
	}


}
