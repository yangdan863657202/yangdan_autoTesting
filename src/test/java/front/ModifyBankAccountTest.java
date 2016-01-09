package front;

import exception.PageElementNotException;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import page.front.LoginPage;
import page.front.SignPage;
import service.front.SetSelectValueService;
import util.WebDriverUtil;
import xpath.front.LoginPageXpath;
import xpath.front.SignPageXpath;

/**
 * Created by yangdan
 */
public class ModifyBankAccountTest {
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
        WebDriverUtil.getElement(driver,"/html/body/div[2]/div[1]/ul/li[3]/a").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.maxWindow(driver);
        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div[7]/div[2]/div/div[2]/a[4]/button").click();

        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div[3]/div[2]/div[2]/div[2]/button").click();
        WebDriverUtil.sleep(1000);
        //SetSelectValueService.setSelectValue(driver, "//*[@id=\"container\"]/div[1]/div[3]/ul/li[1]/div", "中国工商银行");
        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div[1]/div[3]/ul/li[1]/div/a/span").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div[1]/div[3]/ul/li[1]/div/ul/li[11]/a").click();
        WebDriverUtil.getElement(driver, "//*[@id=\"container\"]/div[1]/div[3]/ul/li[3]/input").sendKeys("6212261001030247933");
        WebDriverUtil.getElement(driver,"//*[@id=\"container\"]/div[1]/div[3]/ul/li[4]/button").click();
        WebDriverUtil.sleep(2000);
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
        System.out.println(alert.getText());
        alert.accept();

    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}
