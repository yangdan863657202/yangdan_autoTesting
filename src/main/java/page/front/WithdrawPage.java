package page.front;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import util.WebDriverUtil;
import xpath.front.AccountCenterPageXpath;
import xpath.front.RechargePageXpath;
import xpath.front.WithdrawPageXpath;

/**
 * Created by yangdan
 */
public class WithdrawPage {
    private static Logger logger = Logger.getLogger(WithdrawPage.class);
    public void withdraw(WebDriver driver, String amount){
        WebDriverUtil.maxWindow(driver);
        WebDriverUtil.getElement(driver, AccountCenterPageXpath.FUND_ACCOUNT_BUTTON1).click();
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_BUTTON).click();

    }
}
