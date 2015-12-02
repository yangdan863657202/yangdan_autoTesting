import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import util.SendMail;

/**
 * Created by yangdan
 */
public class MailTest {
    @Test

    @AfterTest
    public static void sendmail() {

        SendMail sendmail = new SendMail();

        sendmail.setHost("smtp.163.com");
        sendmail.setUserName("yangdan863657202@163.com");
        sendmail.setPassWord("963622");
        sendmail.setTo("yd@pccb.com");
        sendmail.setFrom("yangdan863657202@163.com");
        sendmail.setSubject("test report!");
        sendmail.setContent("check the test report as attachfile!");
        sendmail.attachfile("D:/workspace/test-output/html/overview.html");
//        sendmail.attachfile("target/surefire-reports/html/index.html");
//		sendmail.attachfile("target/surefire-reports/html/overview.html");
//		sendmail.attachfile("target/surefire-reports/html/reportng.css");
//		sendmail.attachfile("target/surefire-reports/html/reportng.js");
//		sendmail.attachfile("target/surefire-reports/html/sorttable.js");
//		sendmail.attachfile("target/surefire-reports/html/suite1_test1_results.html");
//		sendmail.attachfile("target/surefire-reports/html/suites.html");

        System.out.println(sendmail.sendMail());

    }
}
