package page.front;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import util.WebDriverUtil;
import xpath.front.AccountCenterPageXpath;
import xpath.front.RechargePageXpath;
import xpath.front.SignPageXpath;

/**
 * Created by yangdan
 */
public class RechargePage {
    private static Logger logger = Logger.getLogger(RechargePage.class);
    AccountCenterPage accountCenterPage=new AccountCenterPage();

    public void recharge(WebDriver driver, String amount){

        WebDriverUtil.maxWindow(driver);
        WebDriverUtil.getElement(driver, AccountCenterPageXpath.FUND_ACCOUNT_BUTTON1).click();
        WebDriverUtil.getElement(driver, RechargePageXpath.RECHARGE_BUTTON).click();

        //accountCenterPage.leftListClick(driver);
        //WebDriverUtil.getElement(driver, AccountCenterPageXpath.RECHARGE_BUTTON).click();
        WebDriverUtil.getElement(driver, RechargePageXpath.RECHARGE_AMOUNT_INPUT).sendKeys(amount);
        WebDriverUtil.getElement(driver, RechargePageXpath.NEXT_STEP_BUTTON).click();
        WebDriverUtil.sleep(1000);
        //WebDriverUtil.getElement(driver, RechargePageXpath.CONFIRM_BUTTON).click();

        WebDriverUtil.getElement(driver, RechargePageXpath.CONFIRM_PAY_BUTTON).click();
        logger.info("本次充值" + amount + "元成功");
    }
}
