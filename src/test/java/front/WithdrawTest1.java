package front;

import exception.PageElementNotException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import page.front.RechargePage;
import page.front.WithdrawPage;
import util.WebDriverUtil;

/**
 * Created by yangdan
 */
public class WithdrawTest1 {

    private WebDriver driver;
    HomePage homePage=new HomePage();
    WithdrawPage withdrawPage=new WithdrawPage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new FirefoxDriver();
    }
    @Test
    public void withdrawTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        homePage.getAccountCenterPage();
        withdrawPage.withdraw(driver,String.valueOf(0.5));
    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
