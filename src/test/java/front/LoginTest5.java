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
public class LoginTest5 {
    private WebDriver driver;
    HomePage homePage=new HomePage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void signTest()throws PageElementNotException {
        driver.get("http://yjf3.pccb.com/");
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"/html/body/div[3]/div/div[2]/ul/li[3]/a").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, "//*[@id=\"new-logo\"]/div/div[2]/div/div[1]/form/ul/li[1]/div[2]/input").sendKeys("13817506005");
        WebDriverUtil.getElement(driver, "//*[@id=\"new-logo\"]/div/div[2]/div/div[1]/form/ul/li[2]/div[2]/input").sendKeys("123456");
        WebDriverUtil.getElement(driver,"//*[@id=\"new-logo\"]/div/div[2]/div/div[1]/form/ul/li[3]/div[2]/input[1]").click();


    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}
