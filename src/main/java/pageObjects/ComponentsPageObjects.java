package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class ComponentsPageObjects extends Base{
	
	public ComponentsPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "")
	private WebElement homePage;
	
	

}
