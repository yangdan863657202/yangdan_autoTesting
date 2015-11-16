package page.front;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.WebDriverUtil;
import xpath.front.AccountCenterPageXpath;

import java.util.List;

/**
 * Created by yangdan
 */
public class AccountCenterPage {

    public void leftListClick(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(AccountCenterPageXpath.FUND_ACCOUNT_BUTTON))).build().perform();
        String jsStr = "document.getElementByXpath('/html/body/div[3]/div[1]/div/ul/li[3]/div/a[1]').click();";
        js.executeScript(jsStr);
    }

    public void getFundDetail(){
        List<WebElement> trs = accountInfoPage.getPanelDataGridHTableTrs(driver, "账户还款计划信息");
        for (WebElement tr : trs) {
            List<WebElement> tds= tr.findElements(By.xpath("./td"));
            for (WebElement td : tds) {
                String attribute=	td.getAttribute("field");
                System.out.println(attribute+ "  "+td.findElement(By.tagName("div")).getText());
            }
            System.out.println("--------------");
        }

    }


}
