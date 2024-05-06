package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebComponent {

    private final WebElement rootElement;

    protected WebComponent(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    protected WebElement findElement(By selector) {
        return rootElement.findElement(selector);
    }

    protected void click() {
        rootElement.click();
    }

    public String getText() {
        return rootElement.getText();
    }
}
