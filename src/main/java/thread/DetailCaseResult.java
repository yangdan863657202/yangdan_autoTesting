package thread;

public class DetailCaseResult {

	private String id;// 明细编号
	private TestResult testCase;// 属于哪一条用例
	private String desc;// 明细描述
	private String xpath;// 页面元素对象xpath
	private boolean passed;// 是否通过
	private String param;// 参数

	public DetailCaseResult() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public DetailCaseResult(String id, TestResult testCase, String desc, String xpath,
			boolean passed, String param) {
		super();
		this.id = id;
		this.testCase = testCase;
		this.desc = desc;
		this.xpath = xpath;
		this.passed = passed;
		this.param = param;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public TestResult getTestCase() {
		return testCase;
	}

	public void setTestCase(TestResult testCase) {
		this.testCase = testCase;
	}

	@Override
	public String toString() {
		return "DetailCase [id=" + id + ", testCase=" + testCase + ", desc="
				+ desc + ", xpath=" + xpath + ", passed=" + passed + ", param="
				+ param + "]";
	}

}
