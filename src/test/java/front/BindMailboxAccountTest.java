package front;

import exception.PageElementNotException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import page.front.SignPage;
import util.WebDriverUtil;
import xpath.front.LoginPageXpath;
import xpath.front.SignPageXpath;

/**
 * Created by yangdan
 */
public class BindMailboxAccountTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void signTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        homePage.getAccountCenterPage();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"/html/body/div[2]/div[1]/ul/li[6]/a").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div/div[2]/div[4]/div[3]/a").click();
        WebDriverUtil.getElement(driver, "//*[@id=\"newEmail\"]").sendKeys("13817506005@163.com");
        WebDriverUtil.getElement(driver, "//*[@id=\"newpassword\"]").sendKeys("123456");

        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div[2]/div[2]/div/div[5]/a").click();

    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }

}
