package hw2;

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
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        WebElement lang = driver.findElement(By.xpath("//*[text()='English']"));
        lang.click();
        //WebElement FindResult = driver.findElement(By.cssSelector("li[data-cid='0'] a.organic__url"));
       // String ResultText = FindResult.getText();
        //Assert.assertEquals("Погода в Пензе", ResultText);
    }

}
