package front;

import exception.PageElementNotException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import util.WebDriverUtil;

/**
 * Created by Yangdan
 */
public class LoginTest4 {
    private WebDriver driver;
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void loginTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver,"13817506005","12345");
        loginPage.loginMessage(driver,"用户名或密码错误");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
