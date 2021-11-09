package test;

import models.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {


    @Test
    public void testBoardCreation() throws InterruptedException {
        Board board = new Board().withTitle("test");
        //int bordCountBeforeCreation = app.getBoard().getBordCount();
        app.getBoard().initBoardCreationfromHeader();
        //app.getBoard().fillBoardCreationForm("test");
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().isSubmitionConfirmed();
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();
        //app.getBoard().returnToHomePage();
        //int bordCountAfterCreation = app.getBoard().getBordCount();

        //Assert.assertEquals(bordCountBeforeCreation, bordCountAfterCreation + 1);
        Assert.assertTrue(app.getBoard().isCreated());

    }
}
