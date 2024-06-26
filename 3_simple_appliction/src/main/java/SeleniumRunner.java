import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRunner {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://github.com/");

        String searchPhrase = "selenium";
        WebElement searchBox = driver.findElement(By.cssSelector(".search-input"));
        searchBox.click();
        WebElement searchInput = driver.findElement(By.cssSelector("#query-builder-test"));
        searchInput.sendKeys(searchPhrase);
        searchInput.sendKeys(Keys.ENTER);
        driver.quit();
    }
}
