import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class GitHubSearchTest {

    private static ChromeDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void checkGitHubSearch() {
        driver.get("https://github.com/");

        String searchPhrase = "selenium";
        WebElement searchBox = driver.findElement(By.cssSelector(".search-input"));
        searchBox.click();
        WebElement searchInput = driver.findElement(By.cssSelector("#query-builder-test"));

        searchInput.sendKeys(searchPhrase);
        searchInput.sendKeys(Keys.ENTER);

        System.out.println(LocalDateTime.now());
        waitForElementVisibility(By.cssSelector("[data-testid='results-list'] > div"));

        List<String> actualItems = driver.findElements(By.cssSelector("[data-testid='results-list'] > div")).stream()
                .map(element -> element.getText().toLowerCase())
                .collect(Collectors.toList());

        List<String> expectedItems = actualItems.stream()
                .filter(item -> item.contains(searchPhrase))
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedItems, actualItems);
    }

    private static void waitForElementVisibility(By selector) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDownDriver() {
        System.out.println(LocalDateTime.now());
        driver.quit();
    }
}
