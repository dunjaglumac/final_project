package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealTest extends BasicTest {
	
//	U okviru add meal to cart testa potrebno je izvršiti sledeće korake:
//	učitajte stranicu http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo
//		ugasite lokacioni iskačući dijalog
//		dodajte jelo u korpu, količina je proizvoljna
//		verifikujte da je prikazana poruka sa tekstom 
//		"The Following Errors Occurred: Please Select Location"
//		sačekajte da obaveštenje nestane
//		postavite lokaciju na "City Center - Albany"
//		dodajte jelo u korpu, količina je proizvoljna
//		verifikujte da je prikazana poruka sa tekstom "Meal Added To Cart"
	
		private String location = "City Center - Albany";
	
		@Test
		public void addMealToCartTest() throws InterruptedException {
			
			this.driver.get(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
			
			this.popupPage.getCloseButton().click();
			Thread.sleep(1000);
			
			this.mealPage.addMealToCart("3");
			String message = this.notificationPage.messageText();
			sa.assertEquals(message,"The Following Errors Occurred:\r\n" + 
					"Please Select Location", "[ERROR] Message did not appear");
					
			wait.until(ExpectedConditions.invisibilityOf(this.notificationPage.getMessage()));
			
			this.popupPage.setLocation(location);
			Thread.sleep(1000);
			this.mealPage.addMealToCart("5");
			Thread.sleep(1000);
			message = this.notificationPage.messageText();
			sa.assertEquals(message,"Meal Added To Cart", "[ERROR] Message did not appear" );
		}
	
//
//		U okviru add meal to favorite testa potrebno je izvršiti sledeće korake:
//		učitajte stranicu http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo
//		ugasite lokacioni iskačući dijalog
//		dodajte jelo u omiljena jela
//		verifikujte da je prikazana poruka sa tekstom "Please login first!"
//		učitajte stranicu za prijavu
//		prijavite se na aplikaciju preko demo naloga
//		učitajte stranicu http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo
//		dodajte jelo u omiljena jela
//		verifikujte da je prikazana poruka sa tekstom "Product has been added to your favorites."
//
		
		@Test
		public void addMealToFavorite() throws InterruptedException {
			driver.get(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
			
			this.popupPage.getCloseButton().click();
			Thread.sleep(1000);
			
			this.mealPage.addMealToFavorites();
			String message = this.notificationPage.messageText();
			sa.assertEquals(message, "Please login first!", "[ERROR] Message did not appear" );
			
			driver.get(this.baseURL + "guest-user/login-form");
			loginPage.login(username, password);
			
			this.driver.get(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
			this.mealPage.addMealToFavorites();
			
			message = this.notificationPage.messageText();
			sa.assertEquals(message, "Product has been added to your favorites.", "[ERROR] Message did not appear" );
			
		}
		
//		U okviru clear cart testa potrebno je izvršiti sledeće korake:
//		učitajte stranicu http://demo.yo-meals.com/meals
//		postavite lokaciju na "City Center - Albany"
//		čitate podatke iz xlsx fajla > Meals Sheet 
//		u korpu dodajte svaki proizvod sa određenom količinom
//		za svako dodavanje proizvioda verifikujte da je prikazana poruka sa tekstom "Meal Added To Cart"
//		koristite SoftAssert za ovu proveru
//		obrišite sve stavke iz korpe
//		verifikujte da je prikazana poruka sa tekstom "All meals removed from Cart successfully"

		@Test
		public void clearCartTest() throws InterruptedException, IOException {
			this.driver.get(this.baseURL + "meals");
			Thread.sleep(1000);
			
			this.popupPage.getCloseElement().click();
			this.popupPage.setLocation(location);
			Thread.sleep(1000);
			
			File file = new File("data/Data.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheetMeals= wb.getSheet("Meals");
			
			for (int i = 1; i <=5; i++) {
				String meal = (sheetMeals.getRow(i).getCell(0).getStringCellValue());
				Thread.sleep(500);
				this.driver.get(meal);
				this.mealPage.addMealToCart("5");
				
				String message = this.notificationPage.messageText();
				sa.assertTrue(message.contains("Meal Added To Cart"), "[ERROR] Meal Is Not Added To Cart");
			}	
			
			Thread.sleep(1000);
			
			this.cartPage.clickOnClearAllButton();
			String message = this.notificationPage.messageText();
			sa.assertTrue(message.contains("All meals removed from Cart successfully"), "[ERROR] Meals are not removed from cart");
			
		}
	
}
