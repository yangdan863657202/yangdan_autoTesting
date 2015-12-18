package pccbInterface;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import util.Des;
import util.Md5;

/**
 * Created by yangdan
 */
public class PwdControlTest {
    @Test
    public static void pwdControlTest() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpPost post = new HttpPost("http://yjf3.pccb.com/api/mobile/pwd_control");
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("app_type","1"));
            list.add(new BasicNameValuePair("userid", Des.encryptDES("82044")));
            list.add(new BasicNameValuePair("sign_key", Md5.md5("1" + "82044"+""+"pccbYjfUserPwdControl" )));
            System.out.println("-----" + Md5.md5("82044" + "pccbUserCheckIn") + "-----");
            System.out.println("-----" + Des.encryptDES("82044") + "-----");
            post.setEntity(new UrlEncodedFormEntity(list));
            CloseableHttpResponse response = httpclient.execute(post);

            try {
                System.out.println(response.getStatusLine());
                System.out.println(response.getEntity());
                HttpEntity entity2 = response.getEntity();
                String entity = EntityUtils.toString(entity2);

                JSONObject object = JSONObject.parseObject(entity);
                String url=object.getString("url").toString();
                System.out.println(url);



                String str2 = "http://ezmoney.yijifu.net/userptk/return_password_dialog?isSuccess=truepayt&k=TK1512171916fvx3ec992bdc20b1ffba4f7514ecf6891d2f4abfde7f4a04738a&_t=1450343594539";

                String[] tempArrStr = str2.split("\\?");

                String url1 = tempArrStr[0];

                String[] tempArrStr2 = tempArrStr[1].split("&");

                for(String tempStr : tempArrStr2){

                    System.out.println(tempStr);
                }

                System.out.println(tempArrStr2[1].split("=")[1]);


//                JSONObject jsonObject = new JSONObject(entity);
//                url = jsonObject.getJSONObject("url");
                /**把json字符串转换成json对象**/


                /**
                 * jsonObject.getString("code") 取出code
                 * 比如这里返回的json 字符串为 [code:0,msg:"ok",data:[list:{"name":1},{"name":2}]]
                 * **/

                /**得到url这个key**/


                if(entity.contains("")){
                    System.out.println("Success!");
                    System.out.println("response content:" + entity);
                }
                else
                {
                    System.out.println("Failure!");
                    System.out.println("response content:" + entity);
                    AssertJUnit.fail(entity);
                }
            } finally {
                response.close();
            }
        }
        finally {
            httpclient.close();

        }
        //return(url);

    }
}
