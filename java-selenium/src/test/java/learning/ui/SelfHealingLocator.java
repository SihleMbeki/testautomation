package learning.ui;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SelfHealingLocator {
    private static final Logger log = LoggerFactory.getLogger(SelfHealingLocator.class);

    private SelfHealingLocator() {}

    public static WebElement find(WebDriver driver, String description, By... candidates) {
        for (int index = 0; index < candidates.length; index++) {
            List<WebElement> matches = driver.findElements(candidates[index]);
            for (WebElement match : matches) {
                if (match.isDisplayed()) {
                    if (index > 0) {
                        log.warn("Primary locator failed for {}; using fallback {}", description, candidates[index]);
                    }
                    return match;
                }
            }
        }

        throw new NoSuchElementException(
            "No visible element found for " + description + " using " + List.of(candidates));
    }
}
