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
public class InvestPuHuiJingXuanTest3 {
    private WebDriver driver;
    HomePage homePage=new HomePage();
    InvestPage investPage=new InvestPage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void investEYanJiuDingTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        driver.get("http://yjf3.pccb.com/invest/5910.html");
        investPage.immediateInvestClick4(driver, Integer.toString(1000000),"123abc");
    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
