package front;

import exception.PageElementNotException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import util.WebDriverUtil;

/**
 * Created by Yangdan
 */
public class DebtSellTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();

    @BeforeTest
    public void setUp() {
        driver=new ChromeDriver();
    }
    @Test
    public void insuranceTest1()throws PageElementNotException {
        driver.get("http://yjf3.pccb.com/");
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"/html/body/div[3]/div/div[2]/ul/li[2]/a").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, "/html/body/div[4]/div/div/div/div[2]/ul/li[2]").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, "//*[@id=\"listtwo\"]/table/tbody/tr[1]/td[7]/a").click();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
