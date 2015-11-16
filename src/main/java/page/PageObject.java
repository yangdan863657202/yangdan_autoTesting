package page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import exception.PageElementNotException;
import log.MyLogger;
import thread.DetailCaseResult;
import thread.SystemContext;
import util.WebDriverUtil;

public class PageObject {

	private static Logger logger = MyLogger.getLogger(PageObject.class);

	/**
	 * 记录操作步骤
	 * 
	 * @param desc
	 * @param xpath
	 * @param param
	 */
	public static void setDetailCase(String desc, String xpath,
			boolean isPassed, String... param) {
		SystemContext
				.getTestResult()
				.getDetailCaseResults()
				.add(new DetailCaseResult(SystemContext.getStartCount() + "",
						SystemContext.getTestResult(), desc, xpath, isPassed,
						Arrays.toString(param)));
		logger.info("=========描述:" + (isPassed ? "操作正常" : "操作异常") + "(" + desc
				+ "),xpath:(" + xpath + "),参数:(" + Arrays.toString(param)
				+ ")===================");
	}

	/**
	 * 通过对象在控件[文本输入框、下拉选择、文本区域输入框]中输入值，注：不包括checkbox
	 * 
	 * @param element
	 * @param description
	 * @param param
	 * @throws PageElementNotException
	 */
	public static void inputText(WebElement element, String description,
			String... param) throws PageElementNotException {
		try {
			if ("input".equalsIgnoreCase(element.getTagName())) {
				description = "input输入:" + description;
				element.clear();
				element.sendKeys(param[0]);
			}
			if ("textarea".equalsIgnoreCase(element.getTagName())) {
				element.clear();
				element.sendKeys(param[0]);
				description = "textarea输入:" + description;
			}
			if ("select".equalsIgnoreCase(element.getTagName())) {
				setSelect(element, param[0]);
				description = "select选择:" + description;
			}

			logger.info("=========描述:操作正常(" + description + "),参数:("
					+ Arrays.toString(param) + ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description,
							"无", true, Arrays.toString(param)));
		} catch (Exception e) {
			logger.info("=========描述:操作异常(" + description + "),参数:("
					+ Arrays.toString(param) + ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description,
							"无", false, Arrays.toString(param)));
			String img = WebDriverUtil.screenShot(SystemContext.getWebDriver(),
					SystemContext.getTestResult().getName() + "获取对象_"
							+ description + "_失败");
			SystemContext.getTestResult().setErrImgPath(img);
			throw new PageElementNotException(element.getTagName() + "输入异常"
					+ e.getMessage());
		}
	}

	/**
	 * 在控件[文本输入框、下拉选择、checkbox多选框、文本区域输入框]中输入值
	 * 
	 * @param driver
	 * @param xpath
	 * @param description
	 * @param param
	 *            输入的参数
	 * @throws PageElementNotException
	 */
	public static void inputText(WebDriver driver, String xpath,
			String description, String... param) throws PageElementNotException {
		try {
			WebElement element = getElement(driver, xpath);

			if ("input".equalsIgnoreCase(element.getTagName())) {
				description = "input输入:" + description;
				element.clear();
				element.sendKeys(param[0]);
			}
			if ("textarea".equalsIgnoreCase(element.getTagName())) {
				element.clear();
				element.sendKeys(param[0]);
				description = "textarea输入:" + description;
			}
			if ("select".equalsIgnoreCase(element.getTagName())) {
				setSelect(driver, xpath, param[0]);
				description = "select选择:" + description;
			}
			if ("checkbox".equalsIgnoreCase(element.getAttribute("show_type"))) {
				selectCheckbox(driver, xpath, param);
				description = "checkbox选择:" + description;
			}
			logger.info("=========描述:操作正常(" + description + "),xpath:(" + xpath
					+ "),参数:(" + Arrays.toString(param)
					+ ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description,
							xpath, true, Arrays.toString(param)));
		} catch (Exception e) {
			logger.info("=========描述:操作异常(" + description + "),xpath:(" + xpath
					+ "),参数:(" + Arrays.toString(param)
					+ ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description,
							xpath, false, Arrays.toString(param)));

			String img = WebDriverUtil.screenShot(driver, SystemContext
					.getTestResult().getName() + "获取对象_" + description + "_失败");
			SystemContext.getTestResult().setErrImgPath(img);
			//throw new PageElementNotException(xpath + "输入异常" + e.getMessage());
		}
	}

	public static void setTime(WebDriver driver, String xpath,
			String description, String param) throws PageElementNotException {
		try {
			WebElement e = getElement(driver, xpath);
			String id = e.getAttribute("id");
			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('" + id
							+ "').removeAttribute('readonly');");
			e.clear();
			e.sendKeys(param);
			try {
				e.click();
			} catch (Exception es) {
			}
			logger.info("=========描述:操作正常(时间控件-->" + description + "),xpath:("
					+ xpath + "),参数:(" + param + ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description,
							xpath, true, param));
		} catch (Exception e) {
			logger.info("=========描述:操作异常(时间控件-->" + description + "),xpath:("
					+ xpath + "),参数:(" + param + ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description,
							xpath, false, param));
			String img = WebDriverUtil.screenShot(driver, SystemContext
					.getTestResult().getName() + "获取对象_" + description + "_失败");
			SystemContext.getTestResult().setErrImgPath(img);
			throw new PageElementNotException(xpath + "时间控件输入异常"
					+ e.getMessage());
		}
	}

	public static void clickBtn(WebDriver driver, String xpath,
			String description) throws PageElementNotException {

		try {
			WebElement element = getElement(driver, xpath);
			element.click();
			logger.info("=========描述:操作正常(点击-->" + description + "),xpath:("
					+ xpath + ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description,
							xpath, true, "点击事件，没有参数"));
		} catch (Exception e) {
			logger.info("=========描述:操作异常(点击-->" + description + "),xpath:("
					+ xpath + ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description,
							xpath, false, "点击事件，没有参数"));
			String img = WebDriverUtil.screenShot(driver, SystemContext
					.getTestResult().getName() + "获取对象_" + description + "_失败");
			SystemContext.getTestResult().setErrImgPath(img);
			throw new PageElementNotException(xpath + ",==异常" + e.getMessage());
		}
	}

	/**
	 * 获取页面文本值
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 * @throws PageElementNotException
	 */
	public static String getText(WebDriver driver, String xpath,
			String description) throws PageElementNotException {
		WebElement element = null;
		try {

			element = getElement(driver, xpath);
			String tagName = element.getTagName();
			if (tagName.equalsIgnoreCase("input")
					|| tagName.equalsIgnoreCase("textarea")) {

				logger.info("=========描述:操作正常(获取文本-->" + description + " : "
						+ element.getAttribute("value") + "),xpath:(" + xpath
						+ ")===================");
				SystemContext
						.getTestResult()
						.getDetailCaseResults()
						.add(new DetailCaseResult(SystemContext.getStartCount()
								+ "", SystemContext.getTestResult(),
								description + ":["
										+ element.getAttribute("value") + "]",
								xpath, true, "获取文本，没有参数"));
				return element.getAttribute("value");
			}
			if ("select".equalsIgnoreCase(tagName)) {
				String v = getSelectValue(driver, xpath);
				logger.info("=========描述:操作正常(获取文本-->" + description + " : "
						+ v + "),xpath:(" + xpath + ")===================");
				SystemContext
						.getTestResult()
						.getDetailCaseResults()
						.add(new DetailCaseResult(SystemContext.getStartCount()
								+ "", SystemContext.getTestResult(),
								description + ":[" + v + "]", xpath, true,
								"获取文本，没有参数"));
				return v;
			}

			logger.info("=========描述:操作正常(获取文本-->" + description + " : "
					+ element.getText() + "),xpath:(" + xpath
					+ ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description
							+ " :[" + element.getText() + "]", xpath, true,
							"获取文本，没有参数"));

			return element.getText();
		} catch (Exception e) {
			logger.info("=========描述:操作异常(获取文本-->" + description + " : "
					+ element.getText() + "),xpath:(" + xpath
					+ ")===================");
			SystemContext
					.getTestResult()
					.getDetailCaseResults()
					.add(new DetailCaseResult(SystemContext.getStartCount()
							+ "", SystemContext.getTestResult(), description
							+ " :[" + element.getText() + "]", xpath, false,
							"获取文本，没有参数"));

			String img = WebDriverUtil.screenShot(driver, "获取对象_" + description
					+ "_失败");
			SystemContext.getTestResult().setErrImgPath(img);
			throw new PageElementNotException(xpath + "获取文本异常" + e.getMessage());
		}
	}

	/**
	 * 根据xpath进行对象封装，当对象没有找到时会做错误截图
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 * @throws PageElementNotException
	 */
	private static WebElement getElement(WebDriver driver, String xpath)
			throws PageElementNotException {

		WebElement element = WebDriverUtil.getElement(driver, xpath);
		return element;

	}

	/**
	 * 选择checkbox的选项
	 * 
	 * @param driver
	 * @param xpath
	 * @param values
	 * @throws PageElementNotException
	 */
	private static void selectCheckbox(WebDriver driver, String xpath,
			String... values) throws PageElementNotException {
		Map<WebElement, WebElement> checkbox = getCheckbox(driver, xpath);
		Set<WebElement> keySet = checkbox.keySet();
		String exist = exist(checkbox, xpath, values);
		if (exist==null) {
			for (int i = 0; i < values.length; i++) {
				Iterator<WebElement> it = keySet.iterator();
				while (it.hasNext()) {
					WebElement kObj = it.next();
					WebElement vObj = checkbox.get(kObj);

					String text = kObj.getText();
					if (text.equals(values[i])) {
						if (!vObj.isSelected()) {
							vObj.click();
						}
					}
				}
			}
		}else{
			throw new  PageElementNotException("没有找到checkbox元素:["+exist+"]");
		}
	}

	private static String exist(Map<WebElement, WebElement> checkbox,
			String xpath, String[] values) {

		List<String> keys = new ArrayList<String>();
		Set<WebElement> keySet = checkbox.keySet();
		Iterator<WebElement> it = keySet.iterator();
		while (it.hasNext()) {
			WebElement kObj = it.next();
			String text = kObj.getText();
			keys.add(text);

		}
		
		for (int i = 0; i < values.length; i++) {
			boolean exist = false;
			for (String key : keys) {
				if (key.equals(values[i])) {
					exist=true;
				}
			}
			if(!exist){
				return values[i];
			}
		}

		return null;
	}


	/**
	 * 根据xpath封装页面中的checkbox，其中key为文本，value为勾选框（根据现实的文字来找勾选框）,当对象没有找到时会做错误截图
	 * 
	 * @param driver
	 * @param xpath
	 * @return map
	 * @throws PageElementNotException
	 */
	private static Map<WebElement, WebElement> getCheckbox(WebDriver driver,
			String xpath) throws PageElementNotException {
		WebElement e = WebDriverUtil.getElement(driver, xpath);
		List<WebElement> keys = e.findElements(By.xpath(".//label"));
		Map<WebElement, WebElement> map = new HashMap<WebElement, WebElement>();
		int keysCount = keys.size();
		for (int i = 0; i < keysCount; i++) {
			WebElement value = keys.get(i).findElement(
					By.xpath("./preceding-sibling::input[1]"));
			map.put(keys.get(i), value);
		}
		if (map.size() < 1) {
			String img = WebDriverUtil.screenShot(driver);
			SystemContext.getTestResult().setErrImgPath(img);
			throw new PageElementNotException(img);
		}
		return map;
	}

	/**
	 * 下拉选择输入值
	 * 
	 * @param driver
	 * @param xpath
	 * @param value
	 * @throws PageElementNotException
	 */
	private static void setSelect(WebDriver driver, String xpath, String value)
			throws PageElementNotException {

		setSelect(getElement(driver, xpath), value);
	}

	private static void setSelect(WebElement element, String value)
			throws PageElementNotException {

		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			String img = WebDriverUtil.screenShot(SystemContext.getWebDriver());
			SystemContext.getTestResult().setErrImgPath(img);
			throw new PageElementNotException(img);
		}

	}

	/**
	 * 下拉选择输入值
	 * 
	 * @param driver
	 * @param xpath
	 * @throws PageElementNotException
	 */
	private static String getSelectValue(WebDriver driver, String xpath)
			throws PageElementNotException {

		try {
			Select select = new Select(getElement(driver, xpath));
			return select.getFirstSelectedOption().getText();
		} catch (Exception e) {
			String img = WebDriverUtil.screenShot(driver);
			SystemContext.getTestResult().setErrImgPath(img);
			throw new PageElementNotException(img);
		}

	}

	/**
	 * 判断是否为空
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNull(String string) {

		if (string == null || string == "")
			return true;
		else
			return false;
	}
}
