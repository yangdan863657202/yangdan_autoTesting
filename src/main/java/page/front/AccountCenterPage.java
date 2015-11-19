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

    public void getFundDetail(WebDriver driver){
        List<WebElement> trs = PageObject.getPanelDataGridBTableTrs(driver, "账户还款计划信息");
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


}
