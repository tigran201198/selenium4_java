import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

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

        List<String> actualItems = driver.findElements(By.cssSelector("[data-testid='results-list'] > div"))
                .stream()
                .map(element -> element.getText().toLowerCase())
                .collect(Collectors.toList());
        List<String> expectedItems = actualItems.stream()
                .filter(item -> item.contains(searchPhrase))
                .collect(Collectors.toList());

        Assert.assertEquals(expectedItems, actualItems);

        driver.quit();
    }
}
