package TestCourse;



import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YaMarketPage;

public class MarketTest extends BaseTest {

    private static YaMarketPage yaMarketPage;

    @BeforeClass
    public void beforeTest() {
        yaMarketPage = PageFactory.initElements(driver, YaMarketPage.class);
    }

    @Test
    public void marketTest() {
        driver.get("https://market.yandex.ru/");
        yaMarketPage.search("холодильник");

        int result = yaMarketPage.getResult();
        Assert.assertEquals(12, result);
    }

    @Test
    public void sortTest() {
        driver.get("https://market.yandex.ru/");
        yaMarketPage.search("холодильник");
        yaMarketPage.sortPrice();
    }

    @Test
    public void oneTest() {
        driver.get("https://market.yandex.ru/");
        yaMarketPage.search("холодильник");
        yaMarketPage.sortPrice();
        yaMarketPage.priceRe();
    }
}
