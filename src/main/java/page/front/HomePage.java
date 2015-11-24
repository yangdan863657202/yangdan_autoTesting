package page.front;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import exception.PageElementNotException;
import page.PageObject;
import log.MyLogger;
import thread.SystemContext;

/**
 * 登陆成功后进入的主页面
 * 
 * @author Yangdan
 *
 */
public class HomePage {

	private WebDriver driver;
	private Logger logger = MyLogger.getLogger(HomePage.class);

	public HomePage(WebDriver driver){
		this.driver=driver;
	}

	public HomePage(){
	}

	/**
	 * 退出
	 * 
	 * @throws PageElementNotException
	 */
	public void logout() throws PageElementNotException {
		logger.info("----------------退出------------------");
//		WebElement getElement = WebDriverUtil.getElement(driver,
//				"//*[@id='btnToOut']");
//		getElement.click();
//		getElement = WebDriverUtil.getElement(driver, "//*[@id='logoutBtn']");
//		getElement.click();
//		new MsgBox().clickYesBtn();
		driver.close();
		// driver.quit();
	}

	/**
	 * 账户中心页面
	 * 
	 * @throws PageElementNotException
	 */
	public void getAccountCenterPage() throws PageElementNotException {
		this.clickBtn("账户中心");
	}

	/**
	 * 我要投资页面
	 *
	 * @throws PageElementNotException
	 */
	public void getInvestPage() throws PageElementNotException {
		this.clickBtn("我要投资");
	}

	/**
	 * 业务模式页面
	 *
	 * @throws PageElementNotException
	 */
	public void getBusinessModelPage() throws PageElementNotException {
		this.clickBtn("业务模式");
	}

	/**
	 * 安全保障页面
	 *
	 * @throws PageElementNotException
	 */
	public void getSafetyAssurancePage() throws PageElementNotException {
		this.clickBtn("安全保障");
	}

	/**
	 * 关于我们页面
	 *
	 * @throws PageElementNotException
	 */
	public void getAboutUsPage() throws PageElementNotException {
		this.clickBtn("关于我们");
	}


	/**
	 * 根据名称点击按钮
	 * @param name
	 * 菜单按钮的文本名称
	 * @throws PageElementNotException
	 */
	public void clickBtn(String name) throws PageElementNotException {
		driver.findElement(By.linkText(name)).click();

	}

}
