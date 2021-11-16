package manger;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

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
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void takeScreeenshots(String link){
        File screenshotAs = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshots= new File(link);
        try{
            //Files.copy(screenshotAs,screenshots);
            Files.copy(screenshotAs,screenshots);

        }
        catch (IOException exception){
            exception.printStackTrace();
        }

    }
}

