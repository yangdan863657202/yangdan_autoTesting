package page.front;

import org.apache.log4j.Logger;
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

	private WebDriver driver = SystemContext.getWebDriver();
	private Logger logger = MyLogger.getLogger(HomePage.class);
	private String currentHandle;

	/**
	 * 退出
	 * 
	 * @throws PageElementNotException
	 */
	public void logout() throws PageElementNotException {
		logger.info("----------------退出------------------");
		driver.switchTo().window(currentHandle);
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
	 * 根据名称点击按钮
	 * 
	 * @param name
	 * 菜单按钮的文本名称
	 * @throws PageElementNotException
	 */
	public void clickBtn(String name) throws PageElementNotException {
		String xpath = "//*[@id='side-menu']//a[contains(text(),'" + name
				+ "')]";

		PageObject.clickBtn(driver, xpath, name);

	}

}
