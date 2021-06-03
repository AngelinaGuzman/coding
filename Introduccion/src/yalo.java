import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class yalo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\samsung\\Desktop\\SeleniumJava\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://demo.guru99.com/V4/index.php");
        WebElement ID = driver.findElement(By.xpath("//input[@name='uid']"));
        ID.sendKeys("mngr326413");
        WebElement  pass= driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys("mybEvYb");
        WebElement  BT= driver.findElement(By.xpath("//input[@name='btnLogin']"));
        BT.click();
        WebElement  x= driver.findElement(By.cssSelector(".heading3"));
        Assert.assertTrue(x.isDisplayed());
        Assert.assertTrue(driver.getTitle().contains("Manager"));
        clickItemslist(driver, "Log out");
        //driver.quit();
        
    }
    
    public static void clickItemslist(WebDriver driver, String busca){
        List<WebElement> itemsList = driver.findElements(By.cssSelector(".menusubnav > li"));
        System.out.println(busca);
        for(int i=0; i<itemsList.size(); i++){

            String name=itemsList.get(i).getText();
           // System.out.println(name);

            if(name.contains(busca)){

                //System.out.println(busca);
                itemsList.get(i).click();
            }
        }
    }
    

}
