package front;

import exception.PageElementNotException;
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
public class InvestXianShiBiaoTest {
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
        investPage.setScroll(driver,500);

        investPage.immediateBuyingClick(driver, "Auto Testing 限时标勿投");
        investPage.immediateInvestClick(driver,Integer.toString(10000));
    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
