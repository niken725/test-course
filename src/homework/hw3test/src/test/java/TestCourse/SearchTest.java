package TestCourse;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.SearchYaPage;

public class SearchTest extends BaseTest {

        private static SearchYaPage searchYaPage;

        @BeforeClass
        public void beforeTest() throws InterruptedException {
            searchYaPage = PageFactory.initElements(driver, SearchYaPage.class);
        }


        @Test
        public void searchTest() throws InterruptedException {
            driver.get("https://ya.ru/");
            searchYaPage.search("Погода пенза");

            String result = searchYaPage.getResult();

            Assert.assertEquals("Погода в Пензе", result);
        }

}
