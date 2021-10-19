package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {
//	get metodu za Clear All dugme
//	metodu koja briše sve stavke iz korpe klikom na Clear All dugme

	public CartSummaryPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	//Getters
	public WebElement getClearAllButton() {
		return this.driver.findElement(By.xpath("//*[@class='cart-head']/a[2]"));
	}
	
	//Methods
	public void clickOnClearAllButton() {
		this.getClearAllButton().click();
	}
	
}
