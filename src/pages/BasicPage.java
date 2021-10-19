package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
//	apstraktna klasa koja sadrži sve zajedničke funkcionalnosti page klasa
//	sve ostale page klase nasleđuju ovu klasu

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;

	public BasicPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	
	
}
