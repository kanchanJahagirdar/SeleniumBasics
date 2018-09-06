package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanke\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Navigate to shopping site
		driver.get("https://www.bol.com");
		//Steps to login
		driver.findElement(By.xpath("//a[@href='/nl/rnwy/account/overzicht']")).click();
		driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("kawarkanchan@yahoo.com");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("Sanket1986!");
		driver.findElement(By.xpath("//input[@value='Inloggen']")).click();
		
		
		
		//_______________________________________________________________________________________________
		Thread.sleep(1000);
		//Navigate to my orders
		driver.findElement(By.xpath("//div[contains(@class,'fluid-grid--rev')]/div[2]/ul/li[8]/a")).click();
		//Empty the cart before proceeding further
		driver.findElement(By.xpath("//a[@id='basket']")).click();
		System.out.println(driver.findElements(By.xpath("//fieldset[contains(@class,'fluid-grid--auto')]")).size());
		int count=driver.findElements(By.xpath("//fieldset[contains(@class,'fluid-grid--auto')]")).size();
		//count =0 means your cart is already empty
		if (count!=0) {
		if(driver.findElement(By.xpath("//a[@id='tst_remove_from_basket']")).isEnabled()) {
			//delete the item present in cart
			driver.findElement(By.xpath("//a[@id='tst_remove_from_basket']")).click();
			if(driver.findElement(By.xpath("//div[@class='fluid-grid__item']")).isDisplayed())
			{
				System.out.println("Cart is empty");
				
			}
			
		}
		}
		//Click on continue shopping
		driver.findElement(By.xpath("//div[@class='fluid-grid__item']")).click();
		//Click on to the shop
		driver.findElement(By.xpath("//div[contains(@class,'h-boxedright--xs')]")).click();
		//________________________________________________________________________________________________
		//Go to Categories,under which you have different sections for shopping
		Actions a=new Actions(driver);//build ,perform
		/*WebElement Category=driver.findElement(By.cssSelector("nav[data-test='category-menu']"));		
		a.moveToElement(Category).build().perform();
		a.clickAndHold(Category).build().perform();
		//a.moveToElement(driver.findElement(By.xpath("//nav[@data-test='category-menu']"))).click().moveToElement(driver.findElement(By.xpath("//font[contains(@style,'vertical-align:')]"))).build().perform();
		WebElement BabyKind=driver.findElement(By.cssSelector("font[style*='vertical-align:']"));
		a.moveToElement(BabyKind).click().build().perform();  */
		//___________________________________________________________________________________
		
		
		//Add product using search for box
		//a.moveToElement(driver.findElement(By.xpath("//input[@id='searchfor']"))).sendKeys("Google chromecast").sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.xpath("//input[@id='searchfor']")).sendKeys("Google chromecast");
		driver.findElement(By.xpath("//input[@data-test='search-button']")).click();
		//a.moveToElement(driver.findElement(By.xpath("//a[contains(@title,'Streamer')]"))).click().build().perform();
		//a.moveToElement(driver.findElement(By.linkText(" Google Chromecast - Media Streamer"))).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[text()='Google Chromecast - Media Streamer']"))).click().build().perform();
		//add-to-basket
		driver.findElement(By.xpath("//a[@data-test='add-to-basket']")).click();
		//A pop-up appears
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-test='btn-continue-shopping']")).click();
		String Total_price=driver.findElement(By.xpath("//td[@id='tst_total_price']")).getText().substring(1);
		//System.out.println(Total_price.substring(0));
		String tempArr[]=Total_price.split(",");
		int resultPrice = Integer.parseInt(tempArr[0].trim());
	
		//Continue to order
		driver.findElement(By.xpath("//input[@class='js_basket_bottom_button']")).click();
		
		//Checking if shipping is free
		
		String Shipping_Value = driver.findElement(By.xpath("//td[@data-content-section='shipping_value']")).getText();
		if (resultPrice>20) {
			
			if (Shipping_Value.equalsIgnoreCase("Gratis"))
				System.out.println("Shipping is free");
			else
				System.out.println("Shipping is not free");
		}
		else {
			System.out.println("Shipping is not free");
		}
			
	}
		
	
		
	}



