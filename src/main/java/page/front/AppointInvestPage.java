package page.front;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.WebDriverUtil;

import java.util.List;

/**
 * Created by yangdan
 */
public class AppointInvestPage {
    AccountCenterPage accountCenterPage=new AccountCenterPage();

    public void appointInvestPage(WebDriver driver,String targetName){
        WebDriverUtil.sleep(2000);
        WebDriverUtil.maxWindow(driver);
        WebElement invot = driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[2]/a"));
        Actions ac = new Actions(driver);
        ac.moveToElement(invot).perform();
        //WebDriverUtil.sleep(2000);
        WebDriverUtil.wait(driver, "/html/body/div[2]/div[1]/ul/li[2]/div/a[1]");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[2]/div/a[1]")).click();

        WebDriverUtil.sleep(1000);
        //首先得到所有tr的集合
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/table"));
        System.out.println(rows.size());
        for (WebElement row : rows) {
            //得到当前tr里td的集合

            List<WebElement> cols =  row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText());//得到td里的文本
                System.out.print(" ");
            }
            System.out.println();

            if(targetName.equals(cols.get(0).getText())){
                cols.get(7).click();
            }
        }

        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"confirmAppointment\"]").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"payPassword\"]").sendKeys("123abc");
        WebDriverUtil.getElement(driver,"//*[@id=\"btnSubmit\"]").click();


    }
}
