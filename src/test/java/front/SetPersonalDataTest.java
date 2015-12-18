package front;

import exception.PageElementNotException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import page.front.PersonalDataPage;
import util.WebDriverUtil;
/**
 * Created by yangdan
 */
public class SetPersonalDataTest {

    private WebDriver driver;
    HomePage homePage=new HomePage();
    PersonalDataPage personalDataPage=new PersonalDataPage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void setPersonalDataTest ()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        //homePage=loginService.login("13761677814","19901018ab+");
        WebDriverUtil.sleep(1000);
        homePage.getAccountCenterPage();

        WebDriverUtil.sleep(2000);
        WebElement invot = driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[4]/a"));
        Actions ac = new Actions(driver);
        ac.moveToElement(invot).perform();
        WebDriverUtil.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[4]/div/a[1]")).click();

        personalDataPage.setPersonalData(driver);


    }
    @AfterTest
    public void tearDown(){

        //driver.quit();
    }

}
