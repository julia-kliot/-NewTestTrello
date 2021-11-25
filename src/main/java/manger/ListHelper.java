package manger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListHelper extends HelperBase{
    public ListHelper(WebDriver wd) {
        super(wd);
    }
    public void create(String listName){
        click(By.cssSelector(".js-add-list"));
        type(By.cssSelector(".list-name-input"),listName);
        click(By.cssSelector(".js-save-edit"));

    }
    public int getCount() {

            return  wd.findElements(By.cssSelector(".list")).size();

        }
    }

