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
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2015/12/7.
 */
public class AccountBoundRequest {
    @Test
    public static void AccountBound() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost("http://openapitest.pzex.cn/service?channel=AccountBoundRequest");
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("platformId","3664491c354894882a623c34923d3711"));
            list.add(new BasicNameValuePair("appKey","web"));
            list.add(new BasicNameValuePair("brokerId","000000"));
            list.add(new BasicNameValuePair("memberAccount","717303"));
            list.add(new BasicNameValuePair("card","330182198612122233"));
            list.add(new BasicNameValuePair("payOrgCode","yjf"));
            list.add(new BasicNameValuePair("payOrgName"," "));

            post.setEntity(new UrlEncodedFormEntity(list));
            CloseableHttpResponse response = httpclient.execute(post);

            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity2 = response.getEntity();
                String entity = EntityUtils.toString(entity2);
                if(entity.contains("code\":\"0")){
                    System.out.println("Push Account Bound Success!");
                    System.out.println("response content:" + entity);
                }
                else
                {
                    System.out.println("Push Account Bound Failure!");
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

    }
}
