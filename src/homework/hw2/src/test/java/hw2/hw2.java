package hw2;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class hw2 {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kate\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
    }

    @Test
    public void FindYa() {
        WebElement findMenu = driver.findElement(By.cssSelector(".link.dropdown-menu__switcher"));
        findMenu.click();
        WebElement findSeting = driver.findElement(By.xpath("//a[text()='Настройки портала']"));
        findSeting.click();
        WebElement clickLang = driver.findElement(By.cssSelector("a[data-statlog='tabs.lang']"));
        clickLang.click();
        WebElement findSelect = driver.findElement(By.cssSelector(".select__button"));
        findSelect.click();
        WebElement lang = driver.findElement(By.xpath("(//*[text()='English'])[2]"));
        lang.click();
        WebElement saveButton = driver.findElement(By.cssSelector(".button_theme_action"));
        saveButton.click();
        //Проверка на изменение
        findMenu = driver.findElement(By.cssSelector(".link.dropdown-menu__switcher"));
        findMenu.click();
        findSeting = driver.findElement(By.xpath("//a[text()='Настройки портала']"));
        findSeting.click();
        WebElement FindResult = driver.findElement(By.cssSelector("a[data-statlog='tabs.search']"));
        String ResultText = FindResult.getText();
        Assert.assertEquals("Search", ResultText);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
