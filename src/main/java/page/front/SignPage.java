package page.front;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import util.WebDriverUtil;
import xpath.front.SignPageXpath;

/**
 * Created by yangdan
 */
public class SignPage {

    String cumulateSign,earnPoint;
    private static Logger logger = Logger.getLogger(SignPage.class);

    public void sign(WebDriver driver){
        WebDriverUtil.sleep(1000);
        WebDriverUtil.maxWindow(driver);
        WebDriverUtil.getElement(driver, SignPageXpath.SIGN1_BUTTON).click();
        WebDriverUtil.getElement(driver, SignPageXpath.SIGN2_BUTTON).click();
        cumulateSign=WebDriverUtil.getElement(driver, SignPageXpath.CUMULATE_SIGN_INPUT).getText();
        earnPoint=WebDriverUtil.getElement(driver, SignPageXpath.EARN_POINT_INPUT).getText();
        logger.info("您已累积签到" + cumulateSign+"次");
        logger.info("共赚取" + earnPoint+"积分");
    }


}
