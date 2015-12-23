package service.front;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.WebDriverUtil;

/**
 * Created by yangdan
 */
public class SetSelectValueService {
    public static void setSelectValue(WebDriver driver, String xpath, String value){
        WebElement element = WebDriverUtil.getElement(driver, xpath);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
}
