package front;

import exception.PageElementNotException;
import org.openqa.selenium.Alert;
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
import util.WebDriverUtil;

/**
 * Created by yangdan
 */
public class SetPersonalAvatarTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();


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
        WebDriverUtil.wait(driver, "/html/body/div[2]/div[1]/ul/li[4]/div/a[3]");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[4]/div/a[3]")).click();

        WebDriverUtil.sleep(1000);
        //WebDriverUtil.getElement(driver, "//*[@id=\"select\"]/div[1]").click();
        //WebDriverUtil.getElement(driver,"//*[@id=\"rt_rt_1a6kuu419cid1j4514ra12ug6ve1\"]/input").clear();
        WebDriverUtil.getElement(driver,"//input[@type='file']").sendKeys("C:\\Users\\Administrator\\Desktop\\1.png");
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, "//*[@id=\"save\"]").click();
        int time = 200;
        while (true) {

            if (WebDriverUtil.isAlertExist(driver)){
                break;
            } else {
                time += 100;
                WebDriverUtil.sleep(time);
                if (time >= 6000) {
                    break;
                }
            }
        }

        Alert alert = driver.switchTo().alert();
        alert.accept();


    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }

}
