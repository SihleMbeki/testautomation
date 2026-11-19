package learning.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public final class FormPage {
    private final WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        SelfHealingLocator.find(driver, "name input", By.id("name"), By.cssSelector("input[name='name']"))
            .sendKeys(name);
    }

    public void chooseAge(String answer) {
        SelfHealingLocator.find(
            driver,
            answer + " age option",
            By.cssSelector("input[name='above18'][value='" + answer + "']"),
            By.xpath("//label[normalize-space()='" + answer + "']//input")
        ).click();
    }

    public void chooseInterest(String interest) {
        new Select(SelfHealingLocator.find(
            driver, "interest dropdown", By.id("interest"), By.cssSelector("select[name='interest']")))
            .selectByValue(interest);
    }

    public void setRobotCheckbox(boolean selected) {
        var checkbox = SelfHealingLocator.find(
            driver, "robot checkbox", By.cssSelector("input[name='notRobot']"));
        if (checkbox.isSelected() != selected) {
            checkbox.click();
        }
    }

    public void submit() {
        SelfHealingLocator.find(driver, "submit button", By.cssSelector("#userForm button[type='submit']"))
            .click();
    }
}
