package front;

import exception.PageElementNotException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import util.WebDriverUtil;
import xpath.front.LoginPageXpath;

/**
 * Created by Yangdan
 */
public class RegisterTest2 {
    private WebDriver driver;
    HomePage homePage=new HomePage();

    @BeforeTest
    public void setUp() {
        driver=new ChromeDriver();
    }
    @Test
    public void aboutUsTest1()throws PageElementNotException {
        driver.get("http://yjf3.pccb.com/member/common/login/?act=register");
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"member\"]").sendKeys("13817506005");
        WebDriverUtil.getElement(driver,"//*[@id=\"regpassword\"]").sendKeys("123456");
        WebDriverUtil.getElement(driver,"//*[@id=\"reg-phone-code\"]").sendKeys("8888");
        WebDriverUtil.getElement(driver, "//*[@id=\"new-logo\"]/div/div[2]/div/div[2]/div[1]/form/ul/li[2]/div[2]/input[1]").click();
        WebDriverUtil.sleep(1000);
        String message=WebDriverUtil.getElement(driver, "//*[@id=\"show_err\"]").getText();
        Assert.assertEquals("该手机号码已被注册", message);
    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}
