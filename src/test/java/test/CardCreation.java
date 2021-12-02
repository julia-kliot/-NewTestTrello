package test;

import models.Card;
import org.testng.annotations.Test;

public class CardCreation extends TestBase {

    @Test(groups = {"logs"})
    public void cardCreation1(){
        Card card= Card.builder().cardName("test_new").color("green").build();
        app.getBoard().ClickOnfirstBoard();
        if(app.getList().getCount()==0){
        app.getList().create("Test");}
        app.getCard().initCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCreation();
    }

}
