package firsttest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FistTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kate\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru/");
    }

    @Test
    public void FindYa() {
        WebElement FindText = driver.findElement(By.id("text"));
        FindText.sendKeys("Погода Пенза");
        WebElement FindButton = driver.findElement(By.cssSelector(".search2__button button"));
        FindButton.click();
        WebElement FindResult = driver.findElement(By.cssSelector("li[data-cid='0'] a.organic__url"));
        String ResultText = FindResult.getText();
        Assert.assertEquals("Погода в Пензе", ResultText);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
