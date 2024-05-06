import entities.SearchResultItem;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.impl.HomePage;
import pages.impl.SearchResultsPage;

import java.util.List;
import java.util.stream.Collectors;

public class GitHubSearchTest {

    private static final String SEARCH_PHRASE = "selenium";

    private static ChromeDriver driver;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkGitHubSearch() {
        driver.get("https://github.com/");

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.searchComponent().performSearch(SEARCH_PHRASE);

        List<SearchResultItem> actualItems = searchResultsPage.searchResultsItems();
        List<SearchResultItem> expectedItems = actualItems.stream()
                .filter(item -> item.getTitle().contains(SEARCH_PHRASE) || item.getDescription().contains(SEARCH_PHRASE))
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedItems, actualItems);
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.quit();
    }
}
