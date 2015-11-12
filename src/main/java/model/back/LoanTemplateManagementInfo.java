package model.back;

/**
 * Created by yangdan
 */
public class LoanTemplateManagementInfo {
    /**
     * 模板ID
     */
    private String templateID;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 借款人
     */
    private String borrower;

    /**
     * 创建人
     */
    private String createPerson;

    /**
     * 创建时间
     */
    private String createTime;

    /* get or set 方法 */

    /**
     * 获取 模板ID
     *
     * @return templateID
     */
    public String getTemplateID() {
        return templateID;
    }

    /**
     * 设置 模板ID
     *
     * @param templateID
     */
    public void setTemplateID(String templateID) {
        this.templateID = templateID;
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
     * 获取 创建人
     *
     * @return createPerson
     */
    public String getCreatePerson() {
        return createPerson;
    }

    /**
     * 设置 创建人
     *
     * @param createPerson
     */
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    /**
     * 获取 创建时间
     *
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间
     *
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
