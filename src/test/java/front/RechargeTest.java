package front;

import exception.PageElementNotException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import page.front.RechargePage;
import util.WebDriverUtil;

/**
 * Created by yangdan
 */
public class RechargeTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();
    RechargePage rechargePage=new RechargePage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void rechargeTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        homePage.getAccountCenterPage();
        rechargePage.recharge(driver, Integer.toString(100));

    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
