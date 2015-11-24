package front;

import exception.PageElementNotException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import util.WebDriverUtil;

/**
 * Created by yangdan
 */
public class InvestHuaQiTongTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void loginTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.wait(driver,"/html/body/div[3]/div/div[2]/ul/li[2]/a");
        homePage.getInvestPage();
        
    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
