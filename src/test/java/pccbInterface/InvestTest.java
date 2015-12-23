package pccbInterface;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.front.HomePage;
import service.front.GetTokenService;
import service.front.ReturnUrlService;
import util.Des;
import util.Md5;
import util.WebDriverUtil;

/**
 * Created by yangdan
 */
public class InvestTest {
    private WebDriver driver;
    HomePage homePage=new HomePage();

    @BeforeTest
    public void setUp() {
        //driver = WebDriverUtil.getWebDriver(BrowserType.CHROME);
        driver=new ChromeDriver();
    }
    @Test
    public  void investTest() throws Exception {
        driver.get(ReturnUrlService.returnUrlService());
        driver.findElement(By.xpath("//*[@id=\"payPassword\"]")).sendKeys("123abc");
        driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();
        WebDriverUtil.sleep(2000);
        String s=driver.getCurrentUrl();
        System.out.println(s);

        String token= GetTokenService.getTokenService(s);
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpPost post = new HttpPost("http://yjf3.pccb.com/api/mobile/invest");
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("app_type", "1"));
            list.add(new BasicNameValuePair("userid", Des.encryptDES("82044")));
            list.add(new BasicNameValuePair("borrow_id", Des.encryptDES("5554")));
            list.add(new BasicNameValuePair("money", "10000"));
            list.add(new BasicNameValuePair("coupon", "0"));
            list.add(new BasicNameValuePair("piggy", "0"));
            list.add(new BasicNameValuePair("pay_token", Des.encryptDES(token)));
            list.add(new BasicNameValuePair("sign_key", Md5.md5("1" + "82044" + "5554" + token + "pccbYjfUserInvest")));

            post.setEntity(new UrlEncodedFormEntity(list));
            CloseableHttpResponse response = httpclient.execute(post);

            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity2 = response.getEntity();
                String entity = EntityUtils.toString(entity2);
                if (entity.contains("")) {
                    System.out.println("Success!");
                    System.out.println("response content:" + entity);
                } else {
                    System.out.println("Failure!");
                    System.out.println("response content:" + entity);
                    AssertJUnit.fail(entity);
                }
            } finally {
                response.close();
            }
        }
            finally{
                httpclient.close();

            }
    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}
