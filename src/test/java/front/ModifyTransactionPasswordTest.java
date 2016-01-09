package front;

import exception.PageElementNotException;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.AccountCenterPage;
import page.front.HomePage;
import page.front.LoginPage;
import page.front.SignPage;
import service.front.SetSelectValueService;
import util.WebDriverUtil;
import xpath.front.LoginPageXpath;
import xpath.front.SignPageXpath;

/**
 * Created by yangdan
 */
public class ModifyTransactionPasswordTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();
    AccountCenterPage accountCenterPage=new AccountCenterPage();


    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new FirefoxDriver();
    }
    @Test
    public void signTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        homePage.getAccountCenterPage();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"/html/body/div[2]/div[1]/ul/li[3]/a").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.maxWindow(driver);
        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div[7]/div[2]/div/div[2]/a[4]/button").click();

        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div[3]/div[2]/div[3]/div[2]/a[2]").click();
        accountCenterPage.switchToYjfPage(driver);
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, "//*[@id=\"modify_form\"]/div[2]/div[1]/input").sendKeys("123abc");
        WebDriverUtil.getElement(driver, "//*[@id=\"newPayPwd\"]").sendKeys("123abc");
        WebDriverUtil.getElement(driver, "//*[@id=\"modify_form\"]/div[2]/div[3]/input").sendKeys("123abc");
        WebDriverUtil.getElement(driver, "//*[@id=\"modify_form\"]/div[3]/a/button").click();
        WebDriverUtil.sleep(2000);

    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }

}
