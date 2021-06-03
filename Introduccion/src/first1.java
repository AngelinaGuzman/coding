import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class first1 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\samsung\\Desktop\\SeleniumJava\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Facebook - Inicia sesión o regístrate");
        driver.quit();
	}
	
}
