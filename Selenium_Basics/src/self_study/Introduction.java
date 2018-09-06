
package self_study;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Introduction {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		//Create Driver Object X driver=new X();
		//Path:C:\Users\sanke\Documents\chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanke\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("http://google.com");
		

	}

}
