package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

//	U okviru edit profile testa potrebno je izvršiti sledeće korake:
//		učitajte stranicu http://demo.yo-meals.com/guest-user/login-form
//		ugasite lokacioni iskačući dijalog
//		prijavite se na aplikaciju preko demo naloga
//		verifikujte da je prikazana poruka sa tekstom "Login Successfull"

	//		učitajte stranicu http://demo.yo-meals.com/member/profile
//		zamenite sve osnovne informacije korisnika
//		verifikujte da je prikazana poruka sa tekstom "Setup Successful"
	
//		odjavite se sa sajta
//		verifikujte da je prikazana poruka sa tekstom "Logout Successfull!"
//
	
	
//		U okviru change profile image testa potrebno je izvršiti sledeće korake:
//		učitajte stranicu http://demo.yo-meals.com/guest-user/login-form
//		ugasite lokacioni iskačući dijalog
//		prijavite se na aplikaciju preko demo naloga
//		verifikujte da je prikazana poruka sa tekstom "Login Successfull"
//		učitajte stranicu http://demo.yo-meals.com/member/profile
	
//		otpremite profilnu sliku
//		sliku iz images foldera
//		s obzirom na to da se za otpremanje šalje apsolutna putanja do slike, a mi koristimo relativnu, moramo da pribavimo putanju na sledeći način
//		String imgPath = new File("imagеs/slika.png").getCanonicalPath();
//		Koristan link
//		verifikujte da je prikazana poruka sa tekstom "Profile Image Uploaded Successfully"
//		sačekajte da nestane obaveštenje
//		obrišite profilnu sliku
//		verifikujte da je prikazana poruka sa tekstom "Profile Image Deleted Successfully"
//		sačekajte da nestane obaveštenje
//		odjavite se sa sajta
//		verifikujte da je prikazana poruka sa tekstom "Logout Successfull!"
	
	
		private String firstName = "Laza";
		private String lastName = "Lazic";
		private String address = "Zmaj Jovina 20";
		private String phone = "061123456";
		private String zipCode = "21000";
		private String countryName= "United Kingdom" ;
		private String stateName= "Belfast" ;
		private String cityName= "Dundonald" ;
		


//		@Test
//		public void editProfileTest() throws InterruptedException {
//			driver.get(baseURL + "guest-user/login-form");
//			this.popupPage.clickCloseButton();
//			Thread.sleep(1000);
//			this.loginPage.login(username, password);
//			
//			String message = this.notificationPage.messageText();
//			Assert.assertTrue(message.contains("Login Successfull"), "[ERROR] Message did not appear, not successful login.");
//			Thread.sleep(1000);
//			
//			driver.get(baseURL + "member/profile");
//			Thread.sleep(1000);
//			this.profilePage.inputUserInfo(firstName, lastName, address, phone, zipCode, countryName, stateName, cityName);
//			message = this.notificationPage.messageText();
//			Assert.assertTrue(message.contains("Setup Successful"),"[ERROR] Message did not appear, not successful setup.");
//			
//			this.authPage.loggingOut();
//			message = this.notificationPage.messageText();
//			Assert.assertTrue(message.contains("Logout Successfull"),"[ERROR] Message did not appear, not successful logout.");
//			
//		}
		
		@Test
		public void changeProfileTest() throws InterruptedException, IOException {
			driver.get(baseURL + "guest-user/login-form");
			this.popupPage.clickCloseButton();
			Thread.sleep(1000);
			this.loginPage.login(username, password);
			
			String message = this.notificationPage.messageText();
			this.sa.assertTrue(message.contains("Login Successfull"), "[ERROR] Message did not appear, not successful login.");
			Thread.sleep(1000);
			
			driver.get(baseURL + "member/profile");
			Thread.sleep(1000);
			
			String imgPath = new File("C:\\Users\\Dunja\\Desktop\\emoji_neutral_face.jpg").getCanonicalPath();
			Thread.sleep(1000);
			this.profilePage.uploadProfileImage(imgPath);
			
			message = this.notificationPage.messageText();
			this.sa.assertTrue(message.contains("Profile Image Uploaded Successfully"), "[ERROR] Profile Image Did Not Upload Successfully");
			Thread.sleep(1000);
			
			this.profilePage.removeProfileImage();
			this.sa.assertTrue(message.contains("Profile Image Deleted Successfully"), "[ERROR] Profile Image Did Not Delete Successfully");
			Thread.sleep(1000);
			
			this.notificationPage.waitTillmessageDisappear();
			
			this.authPage.loggingOut();
			message = this.notificationPage.messageText();
			this.sa.assertTrue(message.contains("Logout Successfull"),"[ERROR] Message did not appear, not successful logout.");
			
			
		}
	

}
