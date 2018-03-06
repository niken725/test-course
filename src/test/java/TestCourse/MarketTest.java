package TestCourse;



import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YaMarketPage;

import java.util.ArrayList;

public class MarketTest extends BaseTest {

    private static YaMarketPage yaMarketPage;

    @BeforeClass
    public void beforeTest() {
        yaMarketPage = PageFactory.initElements(driver, YaMarketPage.class);
    }

    @Test
    public void marketTest() {
        driver.get("https://market.yandex.ru/");
        yaMarketPage.searchContent("холодильник");
        int result = yaMarketPage.getContentResult();
        Assert.assertEquals(48, result);
    }

    @Test
    public void sortPriceAscIconTest() {
        driver.get("https://market.yandex.ru/");
        yaMarketPage.searchContent("холодильник");
        yaMarketPage.sortPriceAsc();
        Assert.assertTrue( yaMarketPage.sortIconResult().contains("asc"),"true");
    }


    @Test
    public void sortPriceAscTest() {
        driver.get("https://market.yandex.ru/");
        yaMarketPage.searchContent("холодильник");
        yaMarketPage.sortPriceAsc();
        ArrayList<Integer> prices = yaMarketPage.parsePrices(yaMarketPage.sortAscPrice());
        int i = 1;
        Boolean sortAscResult = true;
        while (i < prices.size()){
            Integer element = prices.get(i-1);
            Integer nextElement = prices.get(i);
            if (element <= nextElement) {
                sortAscResult = true;
            }
            else {sortAscResult = false;
                break;}
            i++;
        }
        Assert.assertTrue(sortAscResult);
    }

    @Test
    public void sortPriceDescIconTest() {
        driver.get("https://market.yandex.ru/");
        yaMarketPage.searchContent("холодильник");
        yaMarketPage.sortPriceDesc();
        Assert.assertTrue(yaMarketPage.sortIconResult().contains("desc"), "true");
    }


    @Test
    public void sortPriceDescTest() {
        driver.get("https://market.yandex.ru/");
        yaMarketPage.searchContent("холодильник");
        yaMarketPage.sortPriceDesc();
        ArrayList<Integer> prices = yaMarketPage.parsePrices(yaMarketPage.sortDescPrice());
        int i = 1;
        Boolean sortDescResult = true;
        while (i < prices.size()){
            Integer element = prices.get(i-1);
            Integer nextElement = prices.get(i);
            if (element >= nextElement) {
                sortDescResult = true;
            }
            else {sortDescResult = false;
                break;}
            i++;
        }
        Assert.assertTrue(sortDescResult);
    }
}
