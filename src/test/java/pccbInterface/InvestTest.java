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
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import util.Des;
import util.Md5;

/**
 * Created by yangdan
 */
public class InvestTest {
    @Test
    public static void investTest() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();


//        HttpPost post = new HttpPost("http://yjf3.pccb.com/api/mobile/pwd_control");
//        List<NameValuePair> list = new ArrayList<NameValuePair>();
//        list.add(new BasicNameValuePair("app_type","0"));
//        list.add(new BasicNameValuePair("userid", Des.encryptDES("82044")));
////        list.add(new BasicNameValuePair("borrow_id",Des.encryptDES("5554")));
//        list.add(new BasicNameValuePair("sign_key", Md5.md5("0" + "82044" + "pccbGetProjectUserInfo")));
//        post.setEntity(new UrlEncodedFormEntity(list));
//        CloseableHttpResponse response = httpclient.execute(post);
//
//        System.out.println(response.getStatusLine());
//        HttpEntity entity2 = response.getEntity();
//        String entity = EntityUtils.toString(entity2);
//        System.out.println("response content:" + entity);
        try {
            HttpPost post = new HttpPost("http://yjf3.pccb.com/api/mobile/pwd_control");
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("app_type","0"));
            list.add(new BasicNameValuePair("userid", Des.encryptDES("82044")));
            list.add(new BasicNameValuePair("sign_key", Md5.md5("0" + "82044" + "pccbYjfUserPwdControl")));
            post.setEntity(new UrlEncodedFormEntity(list));
            CloseableHttpResponse response = httpclient.execute(post);

            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity2 = response.getEntity();
                String entity = EntityUtils.toString(entity2);
                System.out.println("response content:" + entity);
            } finally {
                response.close();
            }
        }
        finally {
            httpclient.close();

        }



//        try {
//            HttpPost post = new HttpPost("http://yjf3.pccb.com/api/mobile/invest");
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
//            list.add(new BasicNameValuePair("app_type","0"));
//            list.add(new BasicNameValuePair("userid", Des.encryptDES("82044")));
//            list.add(new BasicNameValuePair("borrow_id",Des.encryptDES("5554")));
//            list.add(new BasicNameValuePair("money","10000"));
//            list.add(new BasicNameValuePair("coupon","0"));
//            list.add(new BasicNameValuePair("piggy","0"));
//            list.add(new BasicNameValuePair("pay_token","TK1512091616n5k8c49442da46e4a7bc506c1f45cc0bbff742bfdbc318186e57"));
//            list.add(new BasicNameValuePair("sign_key"," "));
//
//            post.setEntity(new UrlEncodedFormEntity(list));
//            CloseableHttpResponse response = httpclient.execute(post);
//
//            try {
//                System.out.println(response.getStatusLine());
//                HttpEntity entity2 = response.getEntity();
//                String entity = EntityUtils.toString(entity2);
//                if(entity.contains("")){
//                    System.out.println("Success!");
//                    System.out.println("response content:" + entity);
//                }
//                else
//                {
//                    System.out.println("Failure!");
//                    System.out.println("response content:" + entity);
//                    AssertJUnit.fail(entity);
//                }
//            } finally {
//                response.close();
//            }
//        }
//        finally {
//            httpclient.close();
//
//        }

    }
}
