package front;

import exception.PageElementNotException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import util.WebDriverUtil;

/**
 * Created by yangdan
 */
public class LogoutTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public void loginTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver);
        //homePage=loginService.login("13761677814","19901018ab+");
        WebDriverUtil.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[5]/a")).click();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
