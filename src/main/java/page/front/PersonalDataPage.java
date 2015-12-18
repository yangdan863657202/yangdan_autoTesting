package page.front;

import exception.PageElementNotException;
import org.openqa.selenium.WebDriver;
import page.PageObject;
import util.WebDriverUtil;
import xpath.front.LoginPageXpath;
import xpath.front.PersonalDataPageXpath;

/**
 * Created by yangdan
 */
public class PersonalDataPage extends PageObject {

    public void setPersonalData(WebDriver driver)throws PageElementNotException {
        WebDriverUtil.sleep(1000);
        this.inputText(driver, PersonalDataPageXpath.GENDER_SELECT, "性别", "女性");
        WebDriverUtil.getElement(driver, PersonalDataPageXpath.BIRTH_PLACE_INPUT).clear();
        WebDriverUtil.getElement(driver, PersonalDataPageXpath.BIRTH_PLACE_INPUT).sendKeys("中国");

        WebDriverUtil.getElement(driver, PersonalDataPageXpath.GRADUATE_SCHOOL_INPUT).clear();
        WebDriverUtil.getElement(driver, PersonalDataPageXpath.GRADUATE_SCHOOL_INPUT).sendKeys("上海");

        this.inputText(driver, PersonalDataPageXpath.EDUCATION_SELECT, "学历", "本科");

        WebDriverUtil.getElement(driver, PersonalDataPageXpath.COMPANY_INPUT).clear();
        WebDriverUtil.getElement(driver, PersonalDataPageXpath.COMPANY_INPUT).sendKeys("普资金融");

        WebDriverUtil.getElement(driver, PersonalDataPageXpath.JOB_INPUT).clear();
        WebDriverUtil.getElement(driver, PersonalDataPageXpath.JOB_INPUT).sendKeys("IT");

        WebDriverUtil.getElement(driver, PersonalDataPageXpath.POSITION_INPUT).clear();
        WebDriverUtil.getElement(driver, PersonalDataPageXpath.POSITION_INPUT).sendKeys("测试");

        WebDriverUtil.getElement(driver, PersonalDataPageXpath.ANNAL_INCOME_INPUT).clear();
        WebDriverUtil.getElement(driver, PersonalDataPageXpath.ANNAL_INCOME_INPUT).sendKeys("10000");
    }
}
