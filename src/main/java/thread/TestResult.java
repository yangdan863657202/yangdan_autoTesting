package thread;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Yangdan
 *
 */
public class TestResult {

	private String id;// 用例编号
	private String name;// 用例名称
	private String system;// 系统名称
	private Date executeTime;// 用例执行时间
	private boolean isSuccess;// 用例是否成功
	private String errImgPath;// 错误截图存放路径
	private List<DetailCaseResult> detailCaseResults;// 用例明细
	private String remark;// 备注信息

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Date getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Date executeTime) {
		this.executeTime = executeTime;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrImgPath() {
		return errImgPath;
	}

	public void setErrImgPath(String errImgPath) {
		this.errImgPath = errImgPath;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<DetailCaseResult> getDetailCaseResults() {
		return detailCaseResults;
	}

	public void setDetailCaseResults(List<DetailCaseResult> detailCaseResults) {
		this.detailCaseResults = detailCaseResults;
	}

}
