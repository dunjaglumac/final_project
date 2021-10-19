package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

//	get metode za sve potrebne elemente sa stranice   
//	metodu koja odjavljuje korisnika sa sistema

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	
	//Getters
	public WebElement getUserButton() {
		return driver.findElement(By.xpath("//*[@class='filled ']/a"));
	}
	public WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//*[@class='my-account-dropdown']/ul/li[2]"));
	} 
	
	//Methods
	public void loggingOut() throws InterruptedException {
		this.getUserButton().click();
		Thread.sleep(1000);
		this.getLogoutButton().click();
	}
	
}
