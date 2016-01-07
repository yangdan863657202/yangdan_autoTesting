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
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div[1]/div[1]/ul/li[2]/a")).click();
//        WebElement invot = driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[2]/a"));
//        Actions ac = new Actions(driver);
//        ac.moveToElement(invot).perform();
//        //WebDriverUtil.sleep(2000);
//        WebDriverUtil.wait(driver, "/html/body/div[2]/div[1]/ul/li[2]/div/a[1]");
//        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[2]/div/a[1]")).click();

        WebDriverUtil.sleep(1000);
        //首先得到所有tr的集合
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/table/tbody"));
        System.out.println(rows.size());
        for (WebElement row : rows) {
            //得到当前tr里td的集合

            List<WebElement> cols =  row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText());//得到td里的文本
                System.out.print(" ");

            }
            System.out.println("");
            System.out.println("11111111"+cols.get(20).getText());
            for(int i=0;i<=34;i++) {
                if (targetName.equals(cols.get(i).getText())) {
                    cols.get(i+7).click();
                }
            }
        }

        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"confirmAppointment\"]").click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver,"//*[@id=\"payPassword\"]").sendKeys("123abc");
        WebDriverUtil.getElement(driver,"//*[@id=\"btnSubmit\"]").click();


    }
}
