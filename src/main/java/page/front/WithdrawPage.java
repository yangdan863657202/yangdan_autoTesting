package page.front;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_BUTTON).click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_AMOUNT_INPUT).sendKeys(amount);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_BUTTON1).click();
        WebDriverUtil.sleep(1000);
        accountCenterPage.switchToYjfPage(driver);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.NEXT_STEP_BUTTON).click();
        WebDriverUtil.sleep(2000);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.PAYMENT_PASSWORD_INPUT).sendKeys("123abc");
        WebDriverUtil.getElement(driver, WithdrawPageXpath.CONFIRM_BUTTON).click();

    }

    public void withdraw1(WebDriver driver, String amount){
        WebDriverUtil.maxWindow(driver);
        WebDriverUtil.getElement(driver, AccountCenterPageXpath.FUND_ACCOUNT_BUTTON1).click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_BUTTON).click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_AMOUNT_INPUT).sendKeys(amount);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_BUTTON1).click();
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
        Assert.assertEquals("提现金额不可为0",alert.getText());
        alert.accept();
    }

    public void withdraw2(WebDriver driver, String amount){
        WebDriverUtil.maxWindow(driver);
        WebDriverUtil.getElement(driver, AccountCenterPageXpath.FUND_ACCOUNT_BUTTON1).click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_BUTTON).click();
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_AMOUNT_INPUT).sendKeys(amount);
        WebDriverUtil.getElement(driver, WithdrawPageXpath.WITHDRAW_BUTTON1).click();
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
        Assert.assertEquals("提现金额大于可用余额", alert.getText());
        alert.accept();

    }

}
