package front;

import exception.PageElementNotException;
import model.front.FundDetailInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.AccountCenterPage;
import page.front.HomePage;
import page.front.LoginPage;
import page.front.RechargePage;
import util.WebDriverUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdan
 */
public class GetFundDetailTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();
    AccountCenterPage accountCenterPage=new AccountCenterPage();
    List<FundDetailInfo> infos = new ArrayList<FundDetailInfo>();

    @BeforeTest
    public void setUp() {
        driver=new ChromeDriver();
    }
    @Test
    public void signTest()throws PageElementNotException {
        homePage = new LoginPage().login(driver,"13817506005","123456");
        WebDriverUtil.sleep(1000);
        homePage.getAccountCenterPage();

        WebDriverUtil.sleep(2000);
        WebDriverUtil.wait(driver, "/html/body/div[3]/div[1]/div/ul/li[3]/a");

        WebElement invot = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[3]/a"));
        Actions ac = new Actions(driver);
        ac.moveToElement(invot).perform();
        //WebDriverUtil.wait(driver, "/html/body/div[3]/div[1]/div/ul/li[3]/div/a[3]");
        WebDriverUtil.wait(driver, "/html/body/div[3]/div[1]/div/ul/li[3]/div/a[3]");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[3]/div/a[3]")).click();

        WebDriverUtil.sleep(2000);
        //infos=accountCenterPage.getAllFundDetails(driver);

        //首先得到所有tr的集合
        List<WebElement> rows = driver.findElements(By.id("dataTable"));
        System.out.println(rows.size());
        //打印出所有单元格的数据
        for (WebElement row : rows) {
            //得到当前tr里td的集合
            List<WebElement> cols =  row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText());//得到td里的文本
            }
            System.out.println();
        }


    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}
