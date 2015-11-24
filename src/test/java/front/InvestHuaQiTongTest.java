package front;

import exception.PageElementNotException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.InvestPage;
import page.front.LoginPage;
import util.WebDriverUtil;

/**
 * Created by yangdan
 */
public class InvestHuaQiTongTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();
    InvestPage investPage=new InvestPage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void loginTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        homePage.getInvestPage();
        WebDriverUtil.sleep(1000);
        investPage.setScrollToElement(driver, "/html/body/div[4]/div/div/div/div[2]/ul/li[1]");

        investPage.immediateBuyingClick(driver, "质保部-预约标001");
        //investPage.immediateBuyingClick(driver, "Auto Testing 华企通勿投");
        investPage.immediateInvestClick(driver,Integer.toString(10000));
    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
