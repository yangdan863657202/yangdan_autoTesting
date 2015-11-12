package xpath.back;

/**
 * 借款模板管理页面
 * Created by yangdan
 */
public interface LoanTemplateManagementPageXpath {
    /**
     * 模板ID-->xpath:文本输入框
     */
    String TEMPLATE_ID_INPUT = "//*[@id=\"form_loan_demo\"]/div/div[1]/div[2]/div[1]/p[1]/input";

    /**
     * 模板名称-->xpath:文本输入框
     */
    String TEMPLATE_NAME_INPUT = "//*[@id=\"form_loan_demo\"]/div/div[1]/div[2]/div[1]/p[2]/input";

    /**
     * 创建人-->xpath:文本输入框
     */
    String CREATE_PERSON_INPUT = "//*[@id=\"form_loan_demo\"]/div/div[1]/div[2]/div[1]/p[3]/input";

    /**
     * 借款人-->xpath:文本输入框
     */
    String BORROWER_INPUT = "//*[@id=\"form_loan_demo\"]/div/div[1]/div[2]/div[1]/p[4]/input";

    /**
     * 创建时间-->xpath:文本输入框
     */
    String CREATE_TIME_INPUT = "//*[@id='residenceAddress']";

    /**
     * 搜索:-->xpath:按钮
     */
    String SEARCH_BUTTON = "//*[@id=\"form_loan_demo\"]/div/div[1]/div[2]/div[1]/p[6]/input[1]";

    /**
     * 新增:-->xpath:按钮
     */
    String NEW_ADD_BUTTON = "//*[@id=\"form_loan_demo\"]/div/div[1]/div[2]/div[1]/p[6]/a";

    /**
     * 批量删除:-->xpath:按钮
     */
    String BATCH_DELETE_BUTTON = "//*[@id=\"form_loan_demo\"]/div/div[1]/div[2]/div[1]/p[6]/input[2]";


}
