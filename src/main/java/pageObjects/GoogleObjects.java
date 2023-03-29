package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleObjects {
WebDriver driver;	

	public GoogleObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "q")
	private WebElement Keyword;
	
	@FindBy(how = How.XPATH, using = "(//input[@name='btnK'])[2]")
	private WebElement Search;
	
	public void enter_Keyword(String keyword) {
		Keyword.sendKeys(keyword);
	}
	
	public void click_Search() {
		Search.click();
	}
 
	public void fill_Data() {
		enter_Keyword("Kartik Chetankumar Patel");
	}
}