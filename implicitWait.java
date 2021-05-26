package practice;
/**implicitWait concept introduced
 * ImplicitWait asks the webdriver to wait for n number of seconds before throwing an exception
 * it is defined globally so it applies for every line of code
 * the script continues as soon as the webElement is found even if its less than the number of seconds specified
 * using ImplicitWait makes the code more readable, keeping it neat but it is difficult to track performance issues
 * 
 */

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class implicitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chine\\OneDrive\\Desktop\\school\\web drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//implicitWait
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
				
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
								
				driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
				driver.findElement(By.cssSelector("button.promoBtn")).click();
				System.out.println(driver.findElement(By.cssSelector("span.promoinfo")).getText());
				driver.findElement(By.xpath("//button[text()='Place Order']")).click();
				
				WebElement selectDropDown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/select"));
				Select dropDown = new Select(selectDropDown);
				dropDown.selectByIndex(5);
				driver.findElement(By.cssSelector("input.chkagree")).click();
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/button")).click();
				
				

	}
}
