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

        homePage.performSearch(SEARCH_PHRASE);

        List<String> actualItems = searchResultsPage.searchResultsItemsText();
        List<String> expectedItems = actualItems.stream()
                .filter(item -> item.contains(SEARCH_PHRASE))
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedItems, actualItems);
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.quit();
    }
}
