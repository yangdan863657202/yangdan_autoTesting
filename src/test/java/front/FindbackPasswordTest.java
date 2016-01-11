package front;

import exception.PageElementNotException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import service.front.GetVerificationCodeService;
import util.WebDriverUtil;
import xpath.front.LoginPageXpath;

/**
 * Created by Yangdan
 */
public class FindbackPasswordTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();

    @BeforeTest
    public void setUp() {
        driver=new FirefoxDriver();
    }
    @Test
    public void aboutUsTest1()throws PageElementNotException {
        driver.get("http://yjf3.pccb.com/member/common/login/?act=login");
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"new-logo\"]/div/div[2]/div/div[1]/form/ul/div[1]/div[2]/div[2]").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"member2\"]").sendKeys("13761677814");
        WebDriverUtil.getElement(driver,"//*[@id=\"cz_code\"]").sendKeys("8888");
        WebDriverUtil.getElement(driver,"//*[@id=\"out_click\"]").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"bcheck2\"]/a").click();
        WebDriverUtil.sleep(2000);
        String s= GetVerificationCodeService.getVerificationCode(driver);
        WebDriverUtil.getElement(driver,"//*[@id=\"tpcode2\"]").sendKeys(s);
        WebDriverUtil.getElement(driver,"//*[@id=\"again_click\"]").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"cz_pwd\"]").sendKeys("123456");
        WebDriverUtil.getElement(driver,"//*[@id=\"cz_pwd1\"]").sendKeys("123456");
        WebDriverUtil.getElement(driver,"//*[@id=\"step3\"]/div[2]/ul/a").click();
        WebDriverUtil.sleep(2000);


    }
    @AfterTest
    public void tearDown(){

        //driver.quit();
    }

}
