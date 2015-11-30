package page.front;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import util.WebDriverUtil;
import xpath.front.AccountCenterPageXpath;
import xpath.front.LoginPageXpath;
import xpath.front.RechargePageXpath;
import xpath.front.WithdrawPageXpath;

/**
 * Created by yangdan
 */
public class WithdrawPage {
    private static Logger logger = Logger.getLogger(WithdrawPage.class);
    AccountCenterPage accountCenterPage=new AccountCenterPage();
    public void withdraw(WebDriver driver, String amount){
        WebDriverUtil.maxWindow(driver);
        WebDriverUtil.getElement(driver, AccountCenterPageXpath.FUND_ACCOUNT_BUTTON1).click();
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_BUTTON).click();
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_AMOUNT_INPUT).sendKeys(amount);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_BUTTON1).click();
        WebDriverUtil.sleep(1000);
        accountCenterPage.switchToYjfPage(driver);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.NEXT_STEP_BUTTON).click();
        WebDriverUtil.sleep(2000);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.PAYMENT_PASSWORD_INPUT).sendKeys("123abc");
        WebDriverUtil.getElement(driver, WithdrawPageXpath.CONFIRM_BUTTON).click();

    }
}
