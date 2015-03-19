import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Solver {
    private static final String CHROME_DRIVER_NAME = "chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String GAME_URL = "http://erhosen.github.io/projects/colorgame/";
    private static WebDriver driver = null;
    
    @FindBy(css = "#timer")
    private WebElement timer;

    @FindBy(css = "#start-button")
    private WebElement startButton;

    @FindBy(css = "#true-tile")
    private WebElement trueTile;

    public Solver() throws Exception {
        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_NAME);
        driver = new ChromeDriver();
        driver.get(GAME_URL);
        TimeUnit.MILLISECONDS.sleep(2000);
        PageFactory.initElements(driver, this);

        startButton.click();

        while (!timer.getText().equals("00:00")) {
            trueTile.click();
        }
    }

    public static void main(String[] args) throws Exception {
        Solver solver = new Solver();
    }
}
