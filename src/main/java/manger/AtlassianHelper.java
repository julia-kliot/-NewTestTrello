package manger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class AtlassianHelper extends HelperBase {
    public AtlassianHelper(WebDriver wd) {
        super(wd);
    }

    public void initChangePhoto() {
        new Actions(wd).
                moveToElement(wd.findElement(new By.ByCssSelector("[data-test-selector='profile-hover-info']"))).pause(3).click(wd.findElement(By.cssSelector(".css-j9ugw7"))).perform();
        click(By.xpath("//*[@role='menuitem'][1]"));
    }



    public void uploadPhoto() throws InterruptedException {
        attachFile(By.cssSelector("[id=image-input]"),
                new File("C:\\Users\\julia\\Documents\\QA\\QA_Automation\\QA\\New_Test\\src\\test\\resources\\download.jfif"));

        waitForElementAndClick(By.cssSelector(".css-19r5em7"), 10);
        Thread.sleep(5000);
    }
}
