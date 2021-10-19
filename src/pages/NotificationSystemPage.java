package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
	
	
	
}
