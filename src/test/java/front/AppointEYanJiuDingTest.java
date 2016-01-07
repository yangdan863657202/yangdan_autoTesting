package front;

import exception.PageElementNotException;
import model.front.FundDetailInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.*;
import util.WebDriverUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdan
 */
public class AppointEYanJiuDingTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();
    AppointInvestPage appointInvestPage=new AppointInvestPage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void appointEYanJiuDingTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        homePage.getAccountCenterPage();
        appointInvestPage.appointInvestPage(driver,"5866");

    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}
