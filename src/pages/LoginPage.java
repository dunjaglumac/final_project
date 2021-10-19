package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
	
//	get metode za sve potrebne elemente
//	metodu koja prijavljuje korisnika na sistem - kao parametri se prosleđuju imejl i lozinka

//	Notification Sistem Page:
//	get metodu za element koji prikazuje poruku
//			//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]
//	metodu koja vraća poruku koja se nalazi u obaveštenju
//	metodu koja čeka da obaveštenje nestane
//		čeka se da element //*[contains(@class, 'system_message')]
//		za atribut style dobije vrednost  "display: none;"

	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	//getters
	public WebElement getUsernameInput() {
		return this.driver.findElement(By.name("username"));
	}
	
	public WebElement getPasswordInput() {
		return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	//Methods
	public void login(String email, String password) throws InterruptedException {
		this.getUsernameInput().clear();
		this.getUsernameInput().sendKeys(email);
		Thread.sleep(1000);
		this.getPasswordInput().clear();
		this.getPasswordInput().sendKeys(password);
		Thread.sleep(1000);
		this.getLoginButton().click();
		Thread.sleep(1000);
	}
	
}
