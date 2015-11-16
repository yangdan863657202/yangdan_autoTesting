package page.front;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import util.WebDriverUtil;
import xpath.front.AccountCenterPageXpath;

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
}
