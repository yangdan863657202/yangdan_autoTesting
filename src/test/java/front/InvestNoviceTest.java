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
import xpath.front.InvestPageXpath;

/**
 * Created by yangdan
 */
public class InvestNoviceTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();
    InvestPage investPage=new InvestPage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void investNoviceTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, "/html/body/div[7]/a/img").click();
        WebDriverUtil.getElement(driver, "//*[@id=\"btnTry\"]").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, "//*[@id=\"btnDoInvest\"]").click();
    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
