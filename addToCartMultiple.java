package practice;
import java.util.Arrays;
//this code will add multiple products to the cart using an array
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addToCartMultiple {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\chine\\OneDrive\\Desktop\\school\\web drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
				
		String[] cartItems= {"Carrot","Cucumber","Cauliflower","Beetroot"};
		addItemsToCart(driver,cartItems); //calls the method without creating an object of the class because the method is static
		
	}
	
		public static void addItemsToCart(WebDriver driver ,String[] cartItems ) {//method to add items to the cart
		
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
			
				
				for(int i =0;i<products.size();i++) {
					
					//format to get actual name of the vegetable
					String[] productName= products.get(i).getText().split("-");
					String formattedName = productName[0].trim();
					
					
			//convert the array to an arraylist
				List cartItemsList =Arrays.asList(cartItems);
					
					if(cartItemsList.contains(formattedName))
					{
						
						
						driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
						
					}
										
				}
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/a[4]/img")).click();
				driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
				
								 

			}

		
	}

