package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {
//	get metode za sve potrebne elemente
//	metodu koja dodaje jelo u korpu - kao parametar se prosleđuje količina
//	metodu koja jelo dodaje u omiljena jela, klikom na dugme Favorite
	
	
	public MealPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}


	//Getters
	public WebElement getMealQuantityInput() {
		return this.driver.findElement(By.className("product_qty"));
	}
	
	public WebElement getAddFavoriteButton() {
		return this.driver.findElement(By.className("item_153"));
	}
	
	public WebElement getAddToCartButton() {
		return this.driver.findElement(By.xpath("//div[@class='price-feature--wrapper']/div[2]/a"));
	}
	
	//Methods
	public void addMealToCart(String numberOfMeals) {
		this.getMealQuantityInput().clear();
		this.getMealQuantityInput().sendKeys(numberOfMeals);
		this.getAddToCartButton().click();
	}
	
	public void addMealToFavorites() {
		this.getAddFavoriteButton().click();
	}
	

}
