package manger;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator2, String text) {
        click(locator2);
        wd.findElement(locator2).clear();
        wd.findElement(locator2).sendKeys(text);
    }


    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void takeScreeenshots(String link) {
        File screenshotAs = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshots = new File(link);
        try {
            //Files.copy(screenshotAs,screenshots);
            Files.copy(screenshotAs, screenshots);

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public void openTabAndSwitch() throws InterruptedException {
        ((JavascriptExecutor) wd).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window((tabs.get(1)));
        wd.navigate().to("https://www.google.com/");
        Thread.sleep(10000);
    }
    public void  attachFile(By locator, File file){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());

    }
    public void waitForElementAndClick(By locator, int time) {
        new WebDriverWait(wd, time).until(ExpectedConditions.elementToBeClickable(locator)).click();
        // wd.findElement(locator).click();
    }
}

