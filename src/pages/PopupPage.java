package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupPage extends BasicPage {

//	get metoda za element koji prikazuje lokaciju u hederu 
//	get metodu za close element
//	get metode potrebne za implementaciju metode u kojoj se postavlja lokacija
//	getKeyword()
//	//*[@id='locality_keyword']
//	getLocationItem(String locationName)
//	//li/a[contains(text(), '" + locationName + "')]/..
//	i nije greska na kraju postoje dve tacke!
//	getLocationInput()
//	//*[@id='location_id']
//	getSubmit()
//	//*[@name='btn_submit']
	
	
//	metodu koja otvara iskačući dijalog klikom na lokaciju iz hedera
//	metodu koja postavlja lokaciju - naziv lokacije (locationName) se prosleđuje kao parametar metode
//	metoda prvo klikne na element keyword element
//	čita vrednost data-value atributa location item elementa
//	postavlja lokaciju izvršavajući JavaScript kod
//	Skripta: arguments[0].value=arguments[1]
//	prvi argument skripte je location input
//	drugi argument skripte je vrednost pročitanog atributa iz drugog koraka.
//	Klikće na submit element preko skripte arguments[0].click();
//	metodu koja zatvara iskačući dijalog, klikom na X dugme

	public PopupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	//Getters
	public WebElement getLocationInHeader() {
		return this.driver.findElement(By.xpath("//*[@class='location-selector']/a"));
	}
	
	public WebElement getCloseButton() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'close-btn-white')]"));
	}
	
	public WebElement getKeyword() {
		return this.driver.findElement(By.id("locality_keyword"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput() {
		return this.driver.findElement(By.id("location_id"));
	}
	
	public WebElement getSubmit() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	//Methods
	public void clickLocationHeader() {
		this.getLocationInHeader().click();
	}
	
	public void setLocation(String locationName) throws InterruptedException {
		this.getKeyword().click();
		Thread.sleep(1000);
		this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), this.getLocationItem(locationName).getAttribute("data-value"));
		js.executeScript("arguments[0].click()", this.getSubmit());
	}
	
	public void clickCloseButton() {
		this.getCloseButton().click();
	}
	
}
