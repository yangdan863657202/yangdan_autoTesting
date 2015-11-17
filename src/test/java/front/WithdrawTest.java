package front;

import exception.PageElementNotException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import page.front.RechargePage;
import util.WebDriverUtil;

/**
 * Created by yangdan
 */
public class WithdrawTest {

    private WebDriver driver;
    HomePage homePage=new HomePage();
    RechargePage rechargePage=new RechargePage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void signTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver,"13817527498","123456a.");
//        /html/body/div[3]/div[1]/div/ul/li[2]/a
//        $("a").mouseover();
        WebDriverUtil.sleep(1000);

        WebElement invot = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[2]/a"));
//        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[2]/a")).click();
        Actions ac = new Actions(driver);
        ac.moveToElement(invot).perform();
        WebDriverUtil.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[2]/div/a[2]")).click();



    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
