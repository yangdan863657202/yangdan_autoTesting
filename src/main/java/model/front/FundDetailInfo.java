package model.front;

/**
 * Created by yangdan
 */
public class FundDetailInfo {
    /**
     * 日期
     */
    private String date;

    /**
     * 收入/支出（元）
     */
    private String incomeOutcome;

    /**
     * 余额
     */
    private String balance;

    /**
     * 备注
     */
    private String remark;

    /* get or set 方法 */

    /**
     * 获取 日期
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置 日期
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 获取 收入/支出（元）
     *
     * @return incomeOutcome
     */
    public String getIncomeOutcome() {
        return incomeOutcome;
    }

    /**
     * 设置 收入/支出（元）
     *
     * @param incomeOutcome
     */
    public void setIncomeOutcome(String incomeOutcome) {
        this.incomeOutcome = incomeOutcome;
    }

    /**
     * 获取 余额
     *
     * @return balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * 设置 余额
     *
     * @param balance
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * 获取 备注
     *
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FundDetailInfo [date=" + date + ", incomeOutcome="
                + incomeOutcome + ", balance=" + balance + ", remark=" + remark + "]";
    }
}
