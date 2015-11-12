package page.back;

import exception.PageElementNotException;
import log.MyLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page.PageObject;
import thread.SystemContext;
import org.openqa.selenium.By;

/**
 * 登陆成功后进入的主页面
 * 
 * @author Yangdan
 *
 */
public class HomePage {

	private WebDriver driver = SystemContext.getWebDriver();
	private Logger logger = MyLogger.getLogger(HomePage.class);

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
	 * 业务管理页面
	 * 
	 * @throws PageElementNotException
	 */
	public void getBusinessManagementPage() throws PageElementNotException {
		this.clickBtn("业务管理");
	}


	/**
	 * 根据名称点击按钮
	 * 
	 * @param name
	 * 菜单按钮的文本名称
	 * @throws PageElementNotException
	 */
	public void clickBtn(String name) throws PageElementNotException {
		driver.findElement(By.linkText(name)).click();

	}

}
