package service.front;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import exception.PageElementNotException;
import page.front.HomePage;
import page.front.LoginPage;
import thread.SystemContext;
import util.WebDriverUtil;

/**
 * 登录页面服务
 * 
 * @author Yangdan
 */
public class LoginService {

	public void login(String id, String psw) throws PageElementNotException {
		// 设置firefox的启动项
//		System.setProperty("webdriver.firefox.bin",
//				"D:\\software\\FireFox\\firefox.exe");
//		// 打开firefox
//		WebDriver driver = new FirefoxDriver();
//		SystemContext.setWebDriver(driver);
		SystemContext.setWebDriver(WebDriverUtil.getWebDriver(BrowserType.CHROME));

		// SystemContext.setStartCount(1);
		// TestResult testCase = new TestResult();
		// SystemContext.setTestResult(testCase);
		// SystemContext.getTestResult().setDetailCaseResults(
		// new ArrayList<DetailCaseResult>());

		LoginPage loginPage = new LoginPage();

		// 进入登录页面
		//HomePage homePage = loginPage.login(id, psw);
		//return homePage;
	}



}
