package page.front;

import org.openqa.selenium.By;
import org.testng.Assert;
import page.PageObject;
import util.WebDriverUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import xpath.front.LoginPageXpath;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 登陆页面, 提供了登录方法
 * 
 * @author Yangdan
 *
 */
public class LoginPage {


	private static Logger logger = Logger.getLogger(LoginPage.class);

	/**
	 * 登陆系统
	 * @param driver
	 * @param username
	 * @param password
	 * @param url
	 * @return 登陆成功进入主页面
	 */
	public HomePage login(WebDriver driver, String username, String password,
			String url) {
		try {
			//WebDriverUtil.maxWindow(driver);
			driver.get(url);

			driver.findElement(By.linkText("登录")).click();
			// 清空用户名
			WebDriverUtil.getElement(driver, LoginPageXpath.USERNAME_INPUT).clear();
			//PageObject.inputText(driver, LoginPageXpath.USERNAME_INPUT, "用户名", username);
			logger.info("输入用户名:" + username);
			// 输入用户名
			WebDriverUtil.getElement(driver, LoginPageXpath.USERNAME_INPUT).sendKeys(username);
			// 清空密码
			WebDriverUtil.getElement(driver, LoginPageXpath.PASSWORD_INPUT).clear();
			//PageObject.inputText(driver, LoginPageXpath.PASSWORD_INPUT, "密码", password);

			logger.info("输入密码:" + password);
			// 输入密码
			WebDriverUtil.getElement(driver, LoginPageXpath.PASSWORD_INPUT).sendKeys(password);

			WebDriverUtil.sleep(1000);
			WebDriverUtil.getElement(driver, LoginPageXpath.LOGIN_BUTTON).click();
			//PageObject.clickBtn(driver, LoginPageXpath.LOGIN_BUTTON, "登录按钮");
			logger.info("点击登陆按钮!");
			// 点击登陆按钮
			//WebDriverUtil.getElement(driver, "//input[@id='button']").click();
			return new HomePage(driver);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}

	}

	/**
	 * 默认用户名和密码登陆
	 */
	public HomePage login(WebDriver driver) {

		InputStream resourceAsStream = LoginPage.class.getClassLoader()
				.getResourceAsStream("login-info.properties");

		try {
			Properties properties = new Properties();
			properties.load(resourceAsStream);
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String url = properties.getProperty("url");
			logger.info("使用默认用户名密码登陆：username[" + username + "],password["
					+ password + "]");
			return login(driver, username, password, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public HomePage login(WebDriver driver, String username, String password){
		InputStream resourceAsStream = LoginPage.class.getClassLoader()
			.getResourceAsStream("login-info.properties");

		try {
			Properties properties = new Properties();
			properties.load(resourceAsStream);
			String url = properties.getProperty("url");
			logger.info("使用用户名密码登陆：username[" + username + "],password["
					+ password + "]");
			return login(driver, username, password, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void loginMessage(WebDriver driver,String message1){
		WebDriverUtil.sleep(1000);
		String message2=WebDriverUtil.getElement(driver,LoginPageXpath.LOGIN_MESSAGE_TEXT).getText();
		Assert.assertEquals(message1,message2);
	}
}

