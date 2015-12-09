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
public class LeftNavTest {
    private WebDriver driver=new ChromeDriver();
    HomePage homePage=new HomePage(driver);

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);

//        driver=new FirefoxDriver();
    }
    @Test
    public void loginTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        WebDriverUtil.sleep(1000);
        homePage.getAccountCenterPage();
        //  driver.findElement(By.linkText("账户中心")).click();
//        /html/body/div[2]/div[1]/ul/li[2]/a/text()
//        body > div.uCenter.clearfix > div.uCenter-left > ul > li:nth-child(2) > a
        WebDriverUtil.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        String js = "$(\".uCenter-left .nav li:nth-child(2)\").hover(function(){ $(this).children(\".hidden\").toggle(); })";
        executor.executeScript(js);

//        ((JavascriptExecutor)driver).executeScript("alert(\"haha\")");
//        driver.get(http://yjf.pccb.com//member/borrowin/index.html);

//       WebElement invot = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[2]/a"));
//        Actions ac = new Actions(driver);
//        ac.moveToElement(invot).perform();
//        WebDriverUtil.sleep(1000);
//        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[2]/div/a[2]")).click();

        //homePage=loginService.login("13761677814","19901018ab+");
        WebDriverUtil.sleep(3000);
//        driver.findElement(By.linkText("退出")).click();
    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
