package page.front;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.front.SetSelectValueService;
import util.WebDriverUtil;
import xpath.front.InvestPageXpath;
import xpath.front.WithdrawPageXpath;

import java.util.List;

/**
 * Created by yangdan
 */
public class InvestPage {
    private static Logger logger = Logger.getLogger(InvestPage.class);
    AccountCenterPage accountCenterPage=new AccountCenterPage();

    public void immediateBuyingClick(WebDriver driver,String targetName){
        //首先得到所有tr的集合
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"listone\"]/table"));
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
                cols.get(5).click();
            }


        }
    }

    //投资华企通，不使用储蓄罐
    public void immediateInvestClick(WebDriver driver,String investAmount,String paymentPassword){
        WebDriverUtil.sleep(2000);
        WebDriverUtil.getElement(driver, InvestPageXpath.INVEST_AMOUNT_INPUT).clear();
        WebDriverUtil.getElement(driver,InvestPageXpath.INVEST_AMOUNT_INPUT).sendKeys(investAmount);
        //WebDriverUtil.getElement(driver, InvestPageXpath.IMMEDIATE_INVEST_BUTTON).click();
        driver.findElement(By.linkText("立即投资")).click();

        WebDriverUtil.sleep(2000);
        WebDriverUtil.maxWindow(driver);
        SetSelectValueService.setSelectValue(driver, "//*[@id=\"coupons_num\"]", "0");
        WebDriverUtil.getElement(driver, InvestPageXpath.PIGGY_DEDUCT_INPUT).clear();
        WebDriverUtil.getElement(driver,InvestPageXpath.PIGGY_DEDUCT_INPUT).sendKeys("0");
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAY_BUTTON).click();
        WebDriverUtil.sleep(3000);
        accountCenterPage.switchToYjfPage(driver);
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, InvestPageXpath.PAYMENT_PASSWORD_INPUT).sendKeys(paymentPassword);
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAYMENT_BUTTON).click();

    }

    //投资限时标，E言九鼎
    public void immediateInvestClick2(WebDriver driver,String investAmount,String paymentPassword){
        WebDriverUtil.sleep(2000);
        WebDriverUtil.getElement(driver, InvestPageXpath.INVEST_AMOUNT_INPUT).clear();
        WebDriverUtil.getElement(driver,InvestPageXpath.INVEST_AMOUNT_INPUT).sendKeys(investAmount);
        //WebDriverUtil.getElement(driver, InvestPageXpath.IMMEDIATE_INVEST_BUTTON).click();
        driver.findElement(By.linkText("立即投资")).click();

        WebDriverUtil.sleep(2000);
        WebDriverUtil.maxWindow(driver);
        SetSelectValueService.setSelectValue(driver, "//*[@id=\"coupons_num\"]", "0");
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAY_BUTTON).click();
        WebDriverUtil.sleep(3000);
        accountCenterPage.switchToYjfPage(driver);
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, InvestPageXpath.PAYMENT_PASSWORD_INPUT).sendKeys(paymentPassword);
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAYMENT_BUTTON).click();

    }

    //投资华企通，使用10元储蓄罐
    public void immediateInvestClick3(WebDriver driver,String investAmount,String paymentPassword){
        WebDriverUtil.sleep(2000);
        WebDriverUtil.getElement(driver, InvestPageXpath.INVEST_AMOUNT_INPUT).clear();
        WebDriverUtil.getElement(driver,InvestPageXpath.INVEST_AMOUNT_INPUT).sendKeys(investAmount);
        //WebDriverUtil.getElement(driver, InvestPageXpath.IMMEDIATE_INVEST_BUTTON).click();
        driver.findElement(By.linkText("立即投资")).click();

        WebDriverUtil.sleep(2000);
        WebDriverUtil.maxWindow(driver);
        SetSelectValueService.setSelectValue(driver, "//*[@id=\"coupons_num\"]", "0");
        WebDriverUtil.getElement(driver, InvestPageXpath.PIGGY_DEDUCT_INPUT).clear();
        WebDriverUtil.getElement(driver,InvestPageXpath.PIGGY_DEDUCT_INPUT).sendKeys("10");
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAY_BUTTON).click();
        WebDriverUtil.sleep(3000);
        accountCenterPage.switchToYjfPage(driver);
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, InvestPageXpath.PAYMENT_PASSWORD_INPUT).sendKeys(paymentPassword);
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAYMENT_BUTTON).click();

    }

    //投资普惠精选，不使用投资券
    public void immediateInvestClick4(WebDriver driver,String investAmount,String paymentPassword){
        WebDriverUtil.sleep(2000);
        WebDriverUtil.getElement(driver, "//*[@id=\"investMoney\"]").clear();
        WebDriverUtil.getElement(driver, "//*[@id=\"investMoney\"]").sendKeys(investAmount);
        //WebDriverUtil.getElement(driver, InvestPageXpath.IMMEDIATE_INVEST_BUTTON).click();
        driver.findElement(By.linkText("立即投资")).click();

        WebDriverUtil.sleep(2000);
        WebDriverUtil.maxWindow(driver);
        SetSelectValueService.setSelectValue(driver, "//*[@id=\"coupons_num\"]", "0");
        WebDriverUtil.getElement(driver,"//*[@id=\"invest_sure\"]").click();

        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, InvestPageXpath.PAYMENT_PASSWORD_INPUT).sendKeys(paymentPassword);
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAYMENT_BUTTON).click();

    }

    //投资普惠精选，使用一张投资券
    public void immediateInvestClick5(WebDriver driver,String investAmount,String paymentPassword){
        WebDriverUtil.sleep(2000);
        WebDriverUtil.getElement(driver, "//*[@id=\"investMoney\"]").clear();
        WebDriverUtil.getElement(driver, "//*[@id=\"investMoney\"]").sendKeys(investAmount);
        //WebDriverUtil.getElement(driver, InvestPageXpath.IMMEDIATE_INVEST_BUTTON).click();
        driver.findElement(By.linkText("立即投资")).click();

        WebDriverUtil.sleep(2000);
        WebDriverUtil.maxWindow(driver);

        WebDriverUtil.getElement(driver,"//*[@id=\"invest_sure\"]").click();

        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, InvestPageXpath.PAYMENT_PASSWORD_INPUT).sendKeys(paymentPassword);
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAYMENT_BUTTON).click();
    }

    //投资华企通，使用一张投资券
    public void immediateInvestClick6(WebDriver driver,String investAmount,String paymentPassword){
        WebDriverUtil.sleep(2000);
        WebDriverUtil.getElement(driver, InvestPageXpath.INVEST_AMOUNT_INPUT).clear();
        WebDriverUtil.getElement(driver,InvestPageXpath.INVEST_AMOUNT_INPUT).sendKeys(investAmount);
        //WebDriverUtil.getElement(driver, InvestPageXpath.IMMEDIATE_INVEST_BUTTON).click();
        driver.findElement(By.linkText("立即投资")).click();

        WebDriverUtil.sleep(2000);
        WebDriverUtil.maxWindow(driver);
        SetSelectValueService.setSelectValue(driver, "//*[@id=\"coupons_num\"]", "1");
        WebDriverUtil.getElement(driver, InvestPageXpath.PIGGY_DEDUCT_INPUT).clear();
        WebDriverUtil.getElement(driver, InvestPageXpath.PIGGY_DEDUCT_INPUT).sendKeys("0");
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAY_BUTTON).click();
        WebDriverUtil.sleep(3000);
        accountCenterPage.switchToYjfPage(driver);
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, InvestPageXpath.PAYMENT_PASSWORD_INPUT).sendKeys(paymentPassword);
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAYMENT_BUTTON).click();

    }


    //投资限时标，E言九鼎，使用一张投资券
    public void immediateInvestClick7(WebDriver driver,String investAmount,String paymentPassword){
        WebDriverUtil.sleep(2000);
        WebDriverUtil.getElement(driver, InvestPageXpath.INVEST_AMOUNT_INPUT).clear();
        WebDriverUtil.getElement(driver,InvestPageXpath.INVEST_AMOUNT_INPUT).sendKeys(investAmount);
        //WebDriverUtil.getElement(driver, InvestPageXpath.IMMEDIATE_INVEST_BUTTON).click();
        driver.findElement(By.linkText("立即投资")).click();

        WebDriverUtil.sleep(2000);
        WebDriverUtil.maxWindow(driver);
        SetSelectValueService.setSelectValue(driver, "//*[@id=\"coupons_num\"]", "1");
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAY_BUTTON).click();
        WebDriverUtil.sleep(3000);
        accountCenterPage.switchToYjfPage(driver);
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, InvestPageXpath.PAYMENT_PASSWORD_INPUT).sendKeys(paymentPassword);
        WebDriverUtil.getElement(driver, InvestPageXpath.CONFIRM_PAYMENT_BUTTON).click();

    }

    //将滚动条滚到适合的位置
    public void setScroll(WebDriver driver,int height){
        try {
            String setscroll = "document.documentElement.scrollTop=" + height;

            JavascriptExecutor jse=(JavascriptExecutor) driver;
            jse.executeScript(setscroll);
        } catch (Exception e) {
            System.out.println("Fail to set the scroll.");
        }
    }

    public void setScrollToElement(WebDriver driver,String elementXpath){
        WebElement element = driver.findElement(By.xpath(elementXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
