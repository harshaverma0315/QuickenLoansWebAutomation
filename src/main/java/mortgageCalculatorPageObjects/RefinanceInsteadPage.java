package mortgageCalculatorPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RefinanceInsteadPage {

	WebDriver driver;

	public RefinanceInsteadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "refinanceGoal")
	WebElement refinanceGoal;

	@FindBy(id = "currentLoanBalanceAmount")
	WebElement currentLoanBalanceAmount;

	@FindBy(id = "homeValue")
	WebElement homeValue;

	@FindBy(id = "includeVaChoice1")
	WebElement yesRadioButton;

	@FindBy(id = "includeVaChoice2")
	WebElement noRadioButton;

	@FindBy(id = "zipCode")
	WebElement zipCode;

	@FindBy(id = "creditScore")
	WebElement creditScore;

	@FindBy(xpath = "//button[@data-analytics-click='ql:Refinance Calculator:Calculate:button']")
	WebElement refinaceSubmit;

	public WebElement refinanceGoal() {
		return refinanceGoal;
	}

	public WebElement currentLoanBalanceAmount() {
		return currentLoanBalanceAmount;
	}

	public WebElement homeValue() {
		return homeValue;
	}

	public WebElement yesButton() {
		return yesRadioButton;
	}

	public WebElement noButton() {
		return noRadioButton;
	}

	public WebElement zipCode() {
		return zipCode;
	}

	public WebElement creditScore() {
		return creditScore;
	}

	public WebElement submit() {
		return refinaceSubmit;
	}
}
