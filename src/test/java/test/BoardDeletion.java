package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletion extends TestBase{

    @Test
    public void testBoardDeletion() throws InterruptedException {
        int bordCountBeforeDeletion = app.getBoard().getBordCount();
        //click on FirsBoard
        app.getBoard().ClickOnfirstBoard();
        app.getBoard().openSideBoardMenu();
        app.getBoard().openMore();

        app.getBoard().closeBoard();

        app.getBoard().returnToHomePage();
        int bordCountAfterDeletion = app.getBoard().getBordCount();
        Assert.assertEquals(bordCountAfterDeletion, bordCountBeforeDeletion - 1);
    }
}

