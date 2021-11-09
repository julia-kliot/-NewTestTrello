package manger;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String user, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), user);
        Thread.sleep(2000);
        click(By.cssSelector("#login"));
        type(By.name("password"), password);
        click(By.id("login-submit"));
        Thread.sleep(20000);
    }

    public void logOut() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("#logout-submit"));

    }
    public boolean isLogged()  {
        return wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size()>0;

    }
    public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("._9Bfh6AVH84yAZe"))));
        return wd.findElement(By.cssSelector("._9Bfh6AVH84yAZe")).isDisplayed();
    }
    public void submitLogin() {
        click(By.id("login-submit"));
    }

    public void fillLoginForm(String user, String password) throws InterruptedException {
        type(By.cssSelector("#user"), user);
        Thread.sleep(2000);
        click(By.cssSelector("#login"));
        type(By.name("password"), password);
    }

    public void fillLoginForm(User user) throws InterruptedException {
        type(By.cssSelector("#user"),user.getEmail() );
        Thread.sleep(2000);
        click(By.cssSelector("#login"));
        type(By.name("password"),user.getPassword() );
    }
    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }
}

