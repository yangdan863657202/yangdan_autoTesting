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
public class BindNewPhoneNumberTest {
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
        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div/div[2]/div[3]/div[3]/a").click();
        WebDriverUtil.getElement(driver, "//*[@id=\"new_phone\"]").sendKeys("13817506005");
        WebDriverUtil.getElement(driver, "//*[@id=\"card\"]").sendKeys("310110198304191537");

        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div[2]/div[2]/div/div[6]/a").click();

    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }

}
