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
public class InvestmentPlateTest4 {
    private WebDriver driver;
    HomePage homePage=new HomePage();

    @BeforeTest
    public void setUp() {
        driver=new ChromeDriver();
    }
    @Test
    public void investmentPlateTest4()throws PageElementNotException {
        driver.get("http://yjf3.pccb.com/");
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, "//*[@id=\"pro1Ul\"]/li[4]/a").click();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
