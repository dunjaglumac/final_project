package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.PopupPage;
import pages.ProfilePage;

public abstract class BasicTest {

//	Basic Test:
//		apstraktna klasa koja sadrži sve zajedničke funkcionalnosti za sve test klase
//		od dodatnih atributa ima:
//			baseUrl 
//			imejl i lozinku demo korisnika customer@dummyid.com/12345678a
//		BeforeMethod metoda koja konfiguriše Selenium drajver
//		AfterMethod metoda koja u slučaju pada testa kreira screenshot stranice i te slike čuva u okviru 
//		screenshots direktorijuma i zatvara sesiju drajvera
//		sve ostale test klase nasleđuju ovu klasu
		
	
		protected WebDriver driver;
		protected WebDriverWait wait;
		protected JavascriptExecutor js;
		protected SoftAssert sa;
	
		// Pages
		protected AuthPage authPage;
		protected CartSummaryPage cartPage;
		protected LoginPage loginPage;
		protected MealPage mealPage;
		protected NotificationSystemPage notificationPage;
		protected PopupPage popupPage;
		protected ProfilePage profilePage;

		// URL
		protected String baseURL = "https://demo.yo-meals.com/";

		// User Information
		protected String username = "customer@dummyid.com";
		protected String password = "12345678a";
		
		@BeforeMethod
		public void beforeMethod() {
			System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
			this.driver = new ChromeDriver();
			this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			this.wait= new WebDriverWait(driver, 20);
			this.sa = new SoftAssert();
			
			this.authPage = new AuthPage(driver, wait, js);
			this.cartPage = new CartSummaryPage(driver, wait, js) ;
			this.loginPage = new LoginPage(driver, wait, js) ;
			this.mealPage = new MealPage(driver, wait, js) ;
			this.notificationPage = new NotificationSystemPage(driver, wait, js) ;
			this.popupPage = new PopupPage(driver, wait, js) ;
			this.profilePage = new ProfilePage(driver, wait, js) ;
			
		}
		
		@AfterMethod
		public void afterTest() {
//			this.driver.quit();
		}

}
