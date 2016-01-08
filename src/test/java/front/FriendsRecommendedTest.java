package front;

import exception.PageElementNotException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
public class FriendsRecommendedTest {
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
        WebDriverUtil.sleep(2000);
        WebElement invot = driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[7]/a"));
        Actions ac = new Actions(driver);
        ac.moveToElement(invot).perform();
        WebDriverUtil.wait(driver, "/html/body/div[2]/div[1]/ul/li[7]/div/a[3]");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[7]/div/a[3]")).click();


    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}
