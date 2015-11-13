package model.back;

/**
 * Created by yangdan
 */
public class LoanManagementInfo {

    /**
     * 标的ID
     */
    private String targetID;

    /**
     * 标名
     */
    private String targetName;

    /**
     * 借款人
     */
    private String borrower;

    /**
     * 借款金额
     */
    private String borrowAmount;

    /**
     * 借款时间
     */
    private String borrowTime;

    /**
     * 年化利率
     */
    private String annualInterest;

    /**
     * 还款方式
     */
    private String repaymentMethod;

    /**
     * 申请时间
     */
    private String applyTime;

    /**
     * 标的状态
     */
    private String targetStatus;

    /* get or set 方法 */

    /**
     * 获取 标名
     *
     * @return targetName
     */
    public String getTargetName() {
        return targetName;
    }

    /**
     * 设置 标名
     *
     * @param targetName
     */
    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    /**
     * 获取 借款人
     *
     * @return borrower
     */
    public String getBorrower() {
        return borrower;
    }

    /**
     * 设置 借款人
     *
     * @param borrower
     */
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    /**
     * 获取 借款金额
     *
     * @return borrowAmount
     */
    public String getBorrowAmount() {
        return borrowAmount;
    }

    /**
     * 设置 借款金额
     *
     * @param borrowAmount
     */
    public void setBorrowAmount(String borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    /**
     * 获取 借款时间
     *
     * @return borrowTime
     */
    public String getBorrowTime() {
        return borrowTime;
    }

    /**
     * 设置 借款时间
     *
     * @param borrowTime
     */
    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    /**
     * 获取 年化利率
     *
     * @return annualInterest
     */
    public String getAnnualInterest() {
        return annualInterest;
    }

    /**
     * 设置 年化利率
     *
     * @param annualInterest
     */
    public void setAnnualInterest(String annualInterest) {
        this.annualInterest = annualInterest;
    }

    /**
     * 获取 还款方式
     *
     * @return repaymentMethod
     */
    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    /**
     * 设置 还款方式
     *
     * @param repaymentMethod
     */
    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }

    /**
     * 获取 申请时间
     *
     * @return applyTime
     */
    public String getApplyTime() {
        return applyTime;
    }

    /**
     * 设置 申请时间
     *
     * @param applyTime
     */
    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取 标的ID
     *
     * @return targetID
     */
    public String gettargetID() {
        return targetID;
    }

    /**
     * 设置 标的ID
     *
     * @param targetID
     */
    public void setTargetID(String targetID) {
        this.targetID = targetID;
    }

    /**
     * 获取 标的状态
     *
     * @return targetStatus
     */
    public String getTargetStatus() {
        return targetStatus;
    }

    /**
     * 设置 标的状态
     *
     * @param targetStatus
     */
    public void setTargetStatus(String targetStatus) {
        this.targetStatus = targetStatus;
    }


}
