package page.front;

import model.front.FundDetailInfo;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.PageObject;
import util.WebDriverUtil;
import xpath.front.AccountCenterPageXpath;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdan
 */
public class AccountCenterPage {
    private static Logger logger = Logger.getLogger(LoginPage.class);

    public void leftListClick(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(AccountCenterPageXpath.FUND_ACCOUNT_BUTTON))).build().perform();
        String jsStr = "document.getElementByXpath('/html/body/div[3]/div[1]/div/ul/li[3]/div/a[1]').click();";
        js.executeScript(jsStr);
    }

    public void leftNavClick(WebDriver driver,String subMenuName){
        if(subMenuName.equals("账户首页")){

        }
        if(subMenuName.equals("我的投资券")){

        }
        if(subMenuName.equals("储蓄罐明细")){

        }
        if(subMenuName.equals("债权流转")){

        }
        if(subMenuName.equals("充值")){

        }
        if(subMenuName.equals("提现")){

        }
        if(subMenuName.equals("资金明细")){

        }
        if(subMenuName.equals("绑定银行卡")){

        }
        if(subMenuName.equals("个人资料")){

        }
        if(subMenuName.equals("收货地址")){

        }
        if(subMenuName.equals("会员中心")){

        }
        if(subMenuName.equals("安全设置")){

        }
        if(subMenuName.equals("每日签到")){

        }
        if(subMenuName.equals("积分明细")){

        }

    }

    public void getFundDetail(WebDriver driver){
        List<WebElement> trs = PageObject.getPanelDataGridBTableTrs(driver, "资金明细");
        for (WebElement tr : trs) {
            List<WebElement> tds= tr.findElements(By.xpath("./td"));
            for (WebElement td : tds) {
                String attribute=	td.getAttribute("field");
                System.out.println(attribute+ "  "+td.findElement(By.tagName("div")).getText());
            }
            System.out.println("--------------");
        }

    }

    public List<FundDetailInfo> getAllFundDetails(
            WebDriver driver) {
        String panelName = "资金明细";
        List<FundDetailInfo> infos = new ArrayList<FundDetailInfo>();
        List<WebElement> trs = PageObject.getPanelDataGridBTableTrs(driver, "//*[@id=\"dataTable\"]");

        if (trs == null || trs.size() < 1) {
            logger.info(panelName+"没有数据！");
            return null;
        }
        logger.info(panelName+"共计[" + trs.size() + "]条");
        for (int i = 1; i < trs.size(); i++) {

            FundDetailInfo info = new FundDetailInfo();
            int k=i+1;
            List<WebElement> tds = trs.get(i).findElements(By.xpath("//*[@id=\"dataTable\"]/tbody/tr["+k+"]"));

            for (int j = 0; j < tds.size(); j++) {
                WebElement td = tds.get(j);

                String value=td.getText();
                if (j==0) {
                    info.setDate(value);
                }
                if (j==1) {
                    info.setIncomeOutcome(value);
                }
                if (j==2) {
                    info.setBalance(value);
                }
                if (j==3) {
                    info.setRemark(value);
                }

            }
            logger.info(panelName+info);
            System.out.println(panelName+info);
            infos.add(info);
        }

        return infos;
    }

    public void switchToYjfPage(WebDriver driver){
        WebDriverUtil.sleep(1000);
        driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);

    }

}
