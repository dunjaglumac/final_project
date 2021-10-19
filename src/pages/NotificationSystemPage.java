package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {
 
//	get metodu za element koji prikazuje poruku
//			//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]
//	metodu koja vraća poruku koja se nalazi u obaveštenju
//	metodu koja čeka da obaveštenje nestane
//			čeka se da element //*[contains(@class, 'system_message')]
//			za atribut style dobije vrednost  "display: none;"

	public NotificationSystemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	//Getters
	public WebElement getMessage() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	
	//Methods
	public String messageText() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]")).getText();
	}
	
	public void waitTillmessageDisappear() {
		wait.until(ExpectedConditions.attributeContains(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"), "style", "display: none"));
	}
	
	
	
}
