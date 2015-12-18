package service.front;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import util.Des;
import util.Md5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdan
 */
public class ReturnUrlService {
    public static String returnUrlService()throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost post = new HttpPost("http://yjf3.pccb.com/api/mobile/pwd_control");
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("app_type","1"));
        list.add(new BasicNameValuePair("userid", Des.encryptDES("82044")));
        list.add(new BasicNameValuePair("sign_key", Md5.md5("1" + "82044" + "" + "pccbYjfUserPwdControl")));
        System.out.println("-----" + Md5.md5("82044" + "pccbUserCheckIn") + "-----");
        System.out.println("-----" + Des.encryptDES("82044") + "-----");
        post.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse response = httpclient.execute(post);

        System.out.println(response.getStatusLine());
        System.out.println(response.getEntity());
        HttpEntity entity2 = response.getEntity();
        String entity = EntityUtils.toString(entity2);

        JSONObject object = JSONObject.parseObject(entity);
        String url=object.getString("url").toString();
        System.out.println(url);

        return(url);
    }
}
