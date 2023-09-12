package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class DesktopsPageObjects extends Base {
	
	public DesktopsPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='TEST ENVIRONMENT']")
	private WebElement textToValidate;
    @FindBy(xpath = "//a[text()='Desktops']")
    private WebElement desktops;
    @FindBy(xpath = "//a[text()='Show All Desktops']")
    private WebElement showAllDesktops;
    @FindBy(xpath = "//a[text()='Apple Cinema 30\"']")
    private WebElement appleCinema;
    @FindBy(xpath = "//a[text()='Description']")
    private WebElement appleCinemaDescrip;
    @FindBy(xpath = "//a[text()='Specification']")
    private WebElement appleCinemaSpecific;
    @FindBy(xpath = "//a[text()='Reviews (0)']")
    private WebElement appleCinemaReviews;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement appleCinemaReviewInputName;
    @FindBy(xpath = "//textarea[@id='input-review']")
    private WebElement appleCinemaInputReview;
    @FindBy(xpath = "//input[@value='1']")
    private WebElement appleCinemaRating1;
    @FindBy(xpath = "//parent::div[@class='form-group required']//input[@value='2']")
    private WebElement appleCinemaRating2;
    @FindBy(xpath = "//input[@value='3']")
    private WebElement appleCinemaRating3;
    @FindBy(xpath = "//input[@value='4']")
    private WebElement appleCinemaRating4;
    @FindBy(xpath = "//input[@value='5']")
    private WebElement appleCinemaRating5;

    
}
