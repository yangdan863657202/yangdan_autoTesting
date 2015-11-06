package thread;

import java.util.List;

import org.openqa.selenium.WebDriver;

import thread.TestResult;

public class SystemContext {

	private SystemContext() {
	}

	private static ThreadLocal<Integer> startCount = new ThreadLocal<Integer>();

	private static ThreadLocal<TestResult> testResult = new ThreadLocal<TestResult>();

	private static ThreadLocal<List<TestResult>> testResults = new ThreadLocal<List<TestResult>>();

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private static ThreadLocal<String> content = new ThreadLocal<String>();

	/**
	 * 获取 homeDriver
	 * @return homeDriver 
	 */
	public static String getHomeDriver() {
		return homeDriver.get();
	}

	/**
	 * 设置 homeDriver 
	 * @param homeDriver homeDriver
	 */
	public static void setHomeDriver(String homeDriver) {
		SystemContext.homeDriver.set(homeDriver);
	}

	private static ThreadLocal<String> homeDriver=new  ThreadLocal<String>();

	
	private static ThreadLocal<String> subject = new ThreadLocal<String>();

	public static WebDriver getWebDriver() {
		return driver.get();
	}

	public static void setWebDriver(WebDriver driver) {
		SystemContext.driver.set(driver);
	}

	public static void removeWebDriver() {
		driver.remove();
	}

	public static TestResult getTestResult() {
		return testResult.get();
	}

	public static void setTestResult(TestResult testResult) {
		SystemContext.testResult.set(testResult);
	}

	public static void removeTestResult() {
		SystemContext.testResult.remove();
	}

	public static List<TestResult> getTestResults() {
		return testResults.get();
	}

	public static void setTestResults(List<TestResult> testResults) {
		SystemContext.testResults.set(testResults);
	}

	public static void removeTestResults() {
		SystemContext.testResults.remove();
	}

	public static Integer getStartCount() {
		Integer index = startCount.get();
		setStartCount(index + 1);
		return index;
	}

	public static void setStartCount(Integer startCount) {
		SystemContext.startCount.set(startCount);
	}

	public static void removeStartCount() {
		SystemContext.startCount.remove();
	}

	public static String getContent() {
		return content.get();
	}

	public static void setContent(String content) {
		SystemContext.content.set(content);
	}

	public static void removeContent() {
		SystemContext.content.remove();
	}

	public static String getSubject() {
		return subject.get();
	}

	public static void setSubject(String subject) {
		SystemContext.subject.set(subject);
	}

	public static void removeSubject() {
		SystemContext.subject.remove();
	}
}
