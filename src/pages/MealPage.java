package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
		return this.driver.findElement(By.name("product_qty"));
	}
	
	public WebElement getAddFavoriteButton() {
		return this.driver.findElement(By.id("item_119"));
	}
	
	public WebElement getAddToCartButton() {
		return this.driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary btn--large j')]"));
	}
	
	//Methods
	public void addMealToCart(String numberOfMeals) {
		this.getMealQuantityInput().sendKeys(Keys.CONTROL+"a"+Keys.ENTER);
		this.getMealQuantityInput().sendKeys(numberOfMeals);
		this.getAddToCartButton().click();
	}
	
	public void addMealToFavorites() {
		this.getAddFavoriteButton().click();
	}
	

}
