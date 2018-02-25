package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class YaMarketPage {
    private By searchInput = By.cssSelector("#header-search");
    private By searchButton = By.cssSelector(".button2");
    private By searchResultField = By.cssSelector(".n-snippet-card2");
    private By sortPriceField = By.xpath("//a[text()=\"по цене\"]");
    private By sortAscField = By.cssSelector(".n-filter-sorter_sort_asc");
    private By priceField = By.cssSelector(".n-snippet-card2__main-price .price");


    private final WebDriver driver;
    public YaMarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String text) {
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchButton).click();

    }

    public Integer getResult() {
        return driver.findElements(searchResultField).size();
    }

    public void sortPrice() {
        driver.findElement(sortPriceField).click();

    }
    public void priceRe() {
        //return driver.findElement(priceField).getText();
        List<WebElement> prices = driver.findElements(priceField);
        prices = parsePrices.;
        ArrayList<Integer> prices = parsePrices();
    }

    protected ArrayList<Integer> parsePrices(List<WebElement> prices) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        prices.forEach(element -> {
            String rawPrice = element.getText();
            rawPrice = rawPrice.replaceAll("[^\\d]", "");
            Integer price = Integer.parseInt(rawPrice);
            result.add(price);
        });

        return result;
    }



    public void priceSt() {
        //Alert(priceRe().substring(0,priceRe().length()-1));
       //return priseI = driver.findElements(priceField).toArray();
       // String st = new String((driver.findElement(priceField)).getText());
    }
}
