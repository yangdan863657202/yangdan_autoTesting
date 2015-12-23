package page.front;

import exception.PageElementNotException;
import org.openqa.selenium.WebDriver;
import page.PageObject;
import service.front.SetSelectValueService;
import util.WebDriverUtil;
import xpath.front.PersonalDataPageXpath;
import xpath.front.ReceiveAddressPageXpath;

/**
 * Created by yangdan
 */
public class ReceiveAddressPage extends PageObject {
    public void setReceiveAddress(WebDriver driver)throws PageElementNotException {
        WebDriverUtil.sleep(1000);
        WebDriverUtil.getElement(driver, ReceiveAddressPageXpath.NEW_ADDRESS_BUTTON).click();

        WebDriverUtil.getElement(driver, ReceiveAddressPageXpath.RECEIVER_INPUT).sendKeys("杨丹");
        SetSelectValueService.setSelectValue(driver, ReceiveAddressPageXpath.AREA_PROVINCE_SELECT, "上海");
        //this.inputText(driver, ReceiveAddressPageXpath.AREA_PROVINCE_SELECT, "所在地区--省", "上海");
        WebDriverUtil.sleep(1000);
        SetSelectValueService.setSelectValue(driver, ReceiveAddressPageXpath.AREA_CITY_SELECT, "上海");
        //this.inputText(driver, ReceiveAddressPageXpath.AREA_CITY_SELECT, "所在地区--市", "上海");
        WebDriverUtil.sleep(1000);
        SetSelectValueService.setSelectValue(driver, ReceiveAddressPageXpath.AREA_DISTRICT_SELECT, "浦东新区");
        //this.inputText(driver, ReceiveAddressPageXpath.AREA_DISTRICT_SELECT, "所在地区--县", "浦东新区");
        WebDriverUtil.getElement(driver, ReceiveAddressPageXpath.DETAIL_ADDRESS_INPUT).sendKeys("中科路2600号");
        WebDriverUtil.getElement(driver, ReceiveAddressPageXpath.CELLPHONE_INPUT).sendKeys("13761677814");
        WebDriverUtil.getElement(driver, ReceiveAddressPageXpath.FIXED_NUMBER_INPUT).sendKeys("86551122");
        WebDriverUtil.getElement(driver, ReceiveAddressPageXpath.ADDRESS_ALIAS_INPUT).sendKeys("川杨");

        WebDriverUtil.getElement(driver, ReceiveAddressPageXpath.SAVE_BUTTON).click();

    }
}
