package tests;

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

		@Test
		public void editProfileTest() throws InterruptedException {
			driver.get(baseURL + "guest-user/login-form");
			this.popupPage.clickCloseButton();
			Thread.sleep(1000);
			this.loginPage.login(username, password);
			Assert.assertTrue(this.notificationPage.messageText().contains("Login Successfull"), "[ERROR] Message did not appear, not successful login.");
			Thread.sleep(1000);
			
			driver.get(baseURL + "member/profile");
			this.profilePage.inputUserInfo(firstName, lastName, address, phone, zipCode, countryName, stateName, cityName);
			
			
		}
		
	

}
