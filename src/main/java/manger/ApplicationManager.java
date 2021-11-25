package manger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
    //WebDriver wd;
    EventFiringWebDriver wd;
    BoardHelper board;
    UserHelper user;
    AtlassianHelper atlassian;
    CardHelper card;
    ListHelper list;

    public void init() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
       // wd= new ChromeDriver();
        wd= new EventFiringWebDriver(new ChromeDriver());
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\julia\\Documents\\QA\\QA_Automation\\QA\\-NewTestTrello\\chromedriver.exe");
        logger.info("Test starts");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");

        board = new BoardHelper(wd);
        user = new UserHelper(wd);
        atlassian = new AtlassianHelper(wd);
        card = new CardHelper(wd);
        list = new ListHelper(wd);

        user.login("juliakliot.jk@gmail.com","misha240613");
        wd.register(new MyListener());
    }
    public void stop(){
        logger.info("Tests are finished");
        wd.quit();

    }

    public BoardHelper getBoard() {
        return board;
    }

    public UserHelper getUser() {
        return user;
    }

    public AtlassianHelper getAtlassian() {
        return atlassian;
    }

    public CardHelper getCard() {
        return card;
    }

    public ListHelper getList() {
        return list;
    }

    public String getURL() {
        return wd.getCurrentUrl();

    }
}
