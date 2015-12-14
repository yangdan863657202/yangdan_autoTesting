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
import util.Des;
import util.Md5;

/**
 * Created by yangdan
 */
public class SubmitPostsApprovalTest {
    @Test
    public static void submitPostsApprovalTest() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost("http://www.pccb.com/appforum/submit_posts_approval");
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("app_type","1"));
            list.add(new BasicNameValuePair("userid", Des.encryptDES("82044")));
            list.add(new BasicNameValuePair("id", Des.encryptDES("41301")));
            list.add(new BasicNameValuePair("approval_type","1"));
            list.add(new BasicNameValuePair("sign_key", Md5.md5( "82044"+"41301"+"1"+"pccbSubmitPostsApproval" )));
            System.out.println("-----" + Md5.md5("82044" + "pccbUserCheckIn") + "-----");
            System.out.println("-----" + Des.encryptDES("82044") + "-----");
            post.setEntity(new UrlEncodedFormEntity(list));
            CloseableHttpResponse response = httpclient.execute(post);

            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity2 = response.getEntity();
                String entity = EntityUtils.toString(entity2);
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

    }
}
