package learning.ui;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormFlowTests {
    private static final Logger log = LoggerFactory.getLogger(FormFlowTests.class);
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1280,900");
        driver = new ChromeDriver(options);
        driver.get(Paths.get("..", "html", "index.html").toAbsolutePath().toUri().toString());
    }

    @DataProvider(name = "formCases")
    public Object[][] formCases() {
        return new Object[][] {
            {"Alex Example", "Yes", "games", true},
            {"Jordan Example", "No", "sport", false},
            {"Taylor Example", "Yes", "movie", true}
        };
    }

    @Test(dataProvider = "formCases")
    public void submitFormOpensResultsInNewWindow(
        String name, String age, String interest, boolean notRobot) {
        FormPage form = new FormPage(driver);
        form.enterName(name);
        form.chooseAge(age);
        form.chooseInterest(interest);
        form.setRobotCheckbox(notRobot);

        String originalWindow = driver.getWindowHandle();
        Set<String> windowsBeforeSubmit = driver.getWindowHandles();
        form.submit();

        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.numberOfWindowsToBe(windowsBeforeSubmit.size() + 1));
        String resultsWindow = driver.getWindowHandles().stream()
            .filter(handle -> !windowsBeforeSubmit.contains(handle))
            .findFirst()
            .orElseThrow(() -> new NoSuchWindowException("Results window did not open"));

        driver.switchTo().window(resultsWindow);
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("page2.html"));

        Assert.assertTrue(driver.getCurrentUrl().contains("name=" + name.replace(" ", "+")));
        Assert.assertTrue(driver.findElement(By.id("results")).getText().contains(name));
        Assert.assertTrue(driver.findElement(By.id("results")).getText().contains(interest));
        Assert.assertTrue(driver.findElement(By.id("results")).getText().contains(age));
        Assert.assertTrue(driver.findElement(By.id("results")).getText()
            .contains(notRobot ? "Yes" : "Not selected"));

        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @Test
    public void missingAgeSelectionShowsAlertAndPreventsNavigation() {
        new FormPage(driver).submit();

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "Please select Yes or No for the above 18 question.");
        alert.accept();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("index.html"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            log.error("Test failed: {}", result.getName(), result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            log.info("Test passed: {}", result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
