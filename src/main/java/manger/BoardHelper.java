package manger;

import models.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase {


    public BoardHelper(WebDriver wd) {
        super(wd);
    }
    public int getBordCount() {
        return wd.findElements(By.cssSelector("boards-page-board-section-list-item")).size()-1-recentlyViewedBoardCounts();
    }

    public void closeBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector("[data-test-id='close-board-delete-board-button']"));
        click(By.cssSelector("[data-test-id='close-board-delete-board-confirm-button']"));
    }

    public void openMore() {
        click((By.cssSelector(".js-open-more")));
    }

    public void openSideBoardMenu() {
        click(By.cssSelector(".js-show-sidebar"));
    }

    public void ClickOnfirstBoard() {
        click(By.cssSelector(".boards-page-board-section-list-item"));
    }

    public void fillBoardCreationForm(String boardName) throws InterruptedException {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
    }
    public void fillBoardCreationForm(Board board) throws InterruptedException {
        type(By.cssSelector("[data-test-id='create-board-title-input']"),board.getTitle());

    }
    public boolean isSubmitionConfirmed() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector("[data-test-id='create-board-submit-button']"))));
        return wd.findElement(By.cssSelector("[data-test-id='create-board-submit-button']")).isDisplayed();

    }


    public  void  submitBoardCreation(){
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }
    public boolean isCreated(){
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".list-name-input"))));
        return wd.findElement(By.cssSelector(".list-name-input")).isDisplayed();
    }
    public void initBoardCreationfromHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));

        click(By.cssSelector("[aria-label='BoardIcon']"));
        //click(( By.xpath("//div[@class='board-tile mod-add']")));
    }
    public int recentlyViewedBoardCounts(){
        return wd.findElements(By.xpath("//*[contains(@class,'icon-clock')]/../../..//li")).size();

    }
    public void returnToHomePage() {click(By.cssSelector("._9Bfh6AVH84yAZe")); }

    public void newCreation() {
        Actions action = new Actions(wd);
        WebElement container = wd.findElement(By.cssSelector("[data-test-id='header-create-menu-popover'"));
        Rectangle rect= container.getRect();
        int x= rect.getX()+10;
        int y= rect.getY()+ rect.getHeight()/2;
        action.moveByOffset(x,y).click().perform();
    }
}

