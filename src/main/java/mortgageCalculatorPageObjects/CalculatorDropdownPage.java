package mortgageCalculatorPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorDropdownPage {

	WebDriver driver;

	public CalculatorDropdownPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//a[@data-qa='nav-calc-main']")
	WebElement calculator;
	
	@FindBy(className="b-Link--plain")
	WebElement allCalculator;
	
	@FindBy(linkText="Refinance Mortgage Calculator")
	WebElement refinanceCalculator;
	
	@FindBy(css="a[href='/calculator-mortgage?qlsource=nav']")
	WebElement purchaseCalculator;
	
	@FindBy(linkText="Home Affordability Calculator")
	WebElement homeCalculator;
	
	@FindBy(className="b-Link--plain")
	WebElement amortizationCalculator;
	
	
	
	public WebElement calDropdown()
	{
		return calculator;
	}
	
	public WebElement allCalculator()
	{
		return allCalculator;
	}
	public WebElement refinance()
	{
		return refinanceCalculator;
	}
	public WebElement purchase()
	{
		return purchaseCalculator;
	}
	public WebElement home()
	{
		return homeCalculator;
	}
	public WebElement amortization()
	{
		return amortizationCalculator;
	}
	
}
