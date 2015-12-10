package front;

import exception.PageElementNotException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.InvestPage;
import page.front.LoginPage;
import util.WebDriverUtil;
import xpath.front.InvestPageXpath;

/**
 * Created by yangdan
 */
public class InvestHuaQiTongTest4 {
    private WebDriver driver;
    HomePage homePage=new HomePage();
    InvestPage investPage=new InvestPage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new FirefoxDriver();
    }
    @Test
    public void investHuaQiTongTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        homePage.getInvestPage();
        WebDriverUtil.sleep(2000);
        investPage.setScrollToElement(driver, "/html/body/div[4]/div/div/div/div[2]/ul/li[1]");
        WebDriverUtil.maxWindow(driver);
        //investPage.immediateBuyingClick(driver, "Auto Testing 华企通勿投");
        driver.get("http://yjf3.pccb.com/Rent/detail/bid/5554");
        investPage.immediateInvestClick(driver, Integer.toString(1),"1234abc");

    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
