package service.front;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import util.WebDriverUtil;

/**
 * Created by Administrator on 2016/1/11.
 */
public class GetVerificationCodeService {
    public static String getVerificationCode(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.open('http://yjf3.pccb.com/haha.php','_blank');");
        WebDriverUtil.sleep(1000);
        //Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        //Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            System.out.println("+++" + winHandle);
            driver.switchTo().window(winHandle);
        }


        String s=WebDriverUtil.getElement(driver,"/html/body").getText();
        System.out.println(s);
        System.out.println("1111111");
        driver.switchTo().window(winHandleBefore);

        //WebDriver.Navigation navigation = driver.navigate();
        //navigation.to("http://yjf3.pccb.com/haha.php");
        return(s);
    }
}
