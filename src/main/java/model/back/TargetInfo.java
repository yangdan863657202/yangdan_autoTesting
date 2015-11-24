package model.back;

/**
 * Created by yangdan
 */
public class TargetInfo {

    /**
     * 借款标题
     */
    private String targetName;

    /**
     * 借款金额
     */
    private String borrowAmount;

    /**
     * 每份投资额
     */
    private String perInvestAmount;

    /**
     * 年化利率
     */
    private String annualInterest;

    /**
     * 还款方式
     */
    private String repaymentMethod;

    /**
     * 借款期限
     */
    private String borrowDeadtime;

    /**
     * 债权转让手续费
     */
    private String debtFee;

    /**
     * 投资券可使用类型
     */
    private String investUsedType;

    /**
     * 借款标分类
     */
    private String targetClassification;

    /**
     * 前台显示认证
     */
    private String displayAuthentication;

    /**
     * 是否通过
     */
    private String isPassed;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 募集截止日期
     */
    private String raiseDeadline;

    /* get or set 方法 */

    /**
     * 获取 借款标题
     *
     * @return targetName
     */
    public String getTargetName() {
        return targetName;
    }

    /**
     * 设置 借款标题
     *
     * @param targetName
     */
    public void setTargetName(String targetName) {
        this.targetName = targetName;
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
     * 获取 每份投资额
     *
     * @return perInvestAmount
     */
    public String getPerInvestAmount() {
        return perInvestAmount;
    }

    /**
     * 设置 每份投资额
     *
     * @param perInvestAmount
     */
    public void setPerInvestAmount(String perInvestAmount) {
        this.perInvestAmount = perInvestAmount;
    }

    /**
     * 获取 借款期限
     *
     * @return borrowDeadtime
     */
    public String getBorrowDeadtime() {
        return borrowDeadtime;
    }

    /**
     * 设置 借款期限
     *
     * @param borrowDeadtime
     */
    public void setBorrowDeadtime(String borrowDeadtime) {
        this.borrowDeadtime = borrowDeadtime;
    }

    /**
     * 获取 债权转让手续费
     *
     * @return debtFee
     */
    public String getDebtFee() {
        return debtFee;
    }

    /**
     * 设置 债权转让手续费
     *
     * @param debtFee
     */
    public void setDebtFee(String debtFee) {
        this.debtFee = debtFee;
    }

    /**
     * 获取 开始时间
     *
     * @return startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置 开始时间
     *
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取 募集截止日期
     *
     * @return raiseDeadline
     */
    public String getRaiseDeadline() {
        return raiseDeadline;
    }

    /**
     * 设置 募集截止日期
     *
     * @param raiseDeadline
     */
    public void setRaiseDeadline(String raiseDeadline) {
        this.raiseDeadline = raiseDeadline;
    }



}
