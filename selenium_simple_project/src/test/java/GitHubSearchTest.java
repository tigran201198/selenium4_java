import entities.SearchResultItem;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.impl.HomePage;
import pages.impl.SearchResultsPage;

import java.time.Duration;
import java.util.List;

public class GitHubSearchTest {

    private static final String SEARCH_PHRASE = "selenium";

    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriverAndWait() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkGitHubSearch() {
        driver.get("https://github.com/");

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.searchComponent().performSearch(SEARCH_PHRASE);

        List<SearchResultItem> actualItems = searchResultsPage.searchResultItems();
        List<SearchResultItem> expectedItems =  searchResultsPage.searchResultItems().stream()
                .filter(item -> item.getTitle().contains(SEARCH_PHRASE) || item.getDescription().contains(SEARCH_PHRASE))
                .toList();

        actualItems.forEach(item -> System.out.println(item.hashCode()));
        expectedItems.forEach(item -> System.out.println(item.hashCode()));

        Assertions.assertEquals(expectedItems, actualItems);
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.quit();
    }
}
