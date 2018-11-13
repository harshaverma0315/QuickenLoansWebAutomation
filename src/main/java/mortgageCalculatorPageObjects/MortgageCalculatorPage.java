package mortgageCalculatorPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MortgageCalculatorPage {

	WebDriver driver;

	public MortgageCalculatorPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//input[@aria-describedby='purchasePrice_helper']")
	WebElement purchasePrice;
	
	@FindBy(xpath="//input[@aria-describedby='downPayment_helper']")
	WebElement downPayment;
	
	@FindBy(id="includeVaChoice1")
	WebElement yesRadioButton;
	
	@FindBy(id="includeVaChoice2")
	WebElement noRadioButton;
	
	@FindBy(id="zipCode")
	WebElement zipCode;
	
	@FindBy(id="creditScore")
	WebElement creditScore;
	
	@FindBy(xpath="//button[@data-analytics-click='ql:Purchase Calculator:Calculate:button']")
	WebElement submit;
	
	@FindBy(id="need_close")
	WebElement popUp;	
	
	@FindBy(className="LPMimage")
	WebElement chatNow;
	
	public WebElement purchasePrice()
	{
		return purchasePrice;
	}
	
	public WebElement downPayment()
	{
		return downPayment;
	}
	public WebElement yesButton()
	{
		return yesRadioButton;
	}
	public WebElement noButton()
	{
		return noRadioButton;
	}
	public WebElement zipCode()
	{
		return zipCode;
	}
	public WebElement creditScore()
	{
		return creditScore;
	}
	public WebElement submit()
	{
		return submit;
	}
	
	public WebElement popUp()
	{
		return popUp;
	}
	
	public WebElement chatNow()
	{
		return chatNow;
	}
	
}
