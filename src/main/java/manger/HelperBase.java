package manger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
