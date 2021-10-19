package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

//	get metode za sve potrebne elemente
//		sve elemente za izmenu osnovnih informacija kao i 
//		sve elemente potrebne za rad sa profilnom slikom
//		da bi se na stranici pojavio element input type="file" potrebno je da se prvo izvrši JavaScript kod koji vrši akciju klik na Upload dugme 
//		Skripta: arguments[0].click();
//	metodu koja otprema profilnu sliku - kao parametar se prosleđuje putanja do fajla, tj. u ovom slučaju do slike
//	metodu koja briše profilnu sliku
//		klikom na Remove dugme 
//		Preporuka: izvršite JavaScript kod arguments[0].click(); nad tim dugmetom
//	metodu koja menja sve osnovne informacije korisnika - kao parametri se prosleđuju sve potrebne informacije
	
	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	//Getters and Selects
	public WebElement getFirstNameInput() {
		return this.driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastNameInput() {
		return this.driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getAddressInput() {
		return this.driver.findElement(By.name("user_address"));
	}
	
	public WebElement getPhoneInput() {
		return this.driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getZipCodeInput() {
		return this.driver.findElement(By.name("user_zip"));
	}

	public WebElement getImageUploadButton() {
		return this.driver.findElement(By.xpath("//*[@class='upload']"));
	}
	
	public WebElement getImageRemoveButton() {
		return this.driver.findElement(By.xpath("//*[@class='remove']"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("(//*[@name='btn_submit'])[2]"));
	}
	
	public Select getCountry() {
		return new Select (this.driver.findElement(By.name("user_country_id")));
	}
	
	public Select getState() {
		return new Select (this.driver.findElement(By.name("user_state_id")));
	}
	
	public Select getCity() {
		return new Select (this.driver.findElement(By.name("user_city")));
	}
	
	
	//Methods
	
	public void uploadProfileImage(String image) {
		js.executeScript("arguments[0].click()", this.getImageUploadButton());
		File img = new File(image);
		String imgPath = img.getAbsolutePath();
		this.getImageUploadButton().sendKeys(imgPath);
	}
	
	public void removeProfileImage() {
		js.executeScript("arguments[0].click()", this.getImageRemoveButton());
	}
	
	public void inputUserInfo(String firstName, String lastName, String address, String phone, String zipCode, String countryName, String stateName, String cityName) throws InterruptedException {
		this.getFirstNameInput().clear();
		this.getFirstNameInput().sendKeys(firstName);
		Thread.sleep(1000);
		this.getLastNameInput().clear();
		this.getLastNameInput().sendKeys(lastName);
		Thread.sleep(1000);
		this.getAddressInput().clear();
		this.getAddressInput().sendKeys(address);
		Thread.sleep(1000);
		this.getPhoneInput().clear();
		this.getPhoneInput().sendKeys(phone);
		Thread.sleep(1000);
		this.getZipCodeInput().clear();
		this.getZipCodeInput().sendKeys(zipCode);
		Thread.sleep(1000);
		this.getCountry().selectByVisibleText(countryName);
		Thread.sleep(1000);
		this.getState().selectByVisibleText(stateName);
		Thread.sleep(1000);
		this.getCity().selectByVisibleText(cityName);
		Thread.sleep(1000);
		this.getSaveButton().click();
		Thread.sleep(1000);
	}
	
	
}
