import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class sample {
    public static void main(String[] args) throws InterruptedException {
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\samsung\\Desktop\\SeleniumJava\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // IMPLICIT WAIT se aplica a todas las lineas
        WebDriverWait w = new WebDriverWait(driver, 5); //  EXPLICIT WAIT  se aplica a la linea imediata siguiente

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Carrot"};
        //Thread.sleep(3000);
        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("a.cart-icon")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); // EXPLICIT WAIT
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); // EXPLICIT WAIT
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
              

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded){
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int cont = 0;
        for(int i=0; i<products.size(); i++){
            
            // Cucumber - 1 Kg
            String[] name = products.get(i).getText().split("-"); 
            String formattedName = name[0].trim(); // Cucumber

            List<String> itemsNeededList = Arrays.asList(itemsNeeded);
       
            if(itemsNeededList.contains(formattedName)){

                System.out.println(formattedName);
                cont++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                if(cont==itemsNeeded.length)
                    break;
            }
        }
        //driver.quit();
    }

}