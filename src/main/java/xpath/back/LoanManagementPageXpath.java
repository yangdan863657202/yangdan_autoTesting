package xpath.back;

/**
 * Created by yangdan
 */
public interface LoanManagementPageXpath {

    /**
     * 标的ID-->xpath:文本输入框
     */
    String TARGET_ID_INPUT = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/p[1]/input";

    /**
     * 产品类别-->xpath:select选择框
     */
    String PRODUCT_CATEGORY_SELECT = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/p[2]/select";

    /**
     * 审核状态-->xpath:select选择框
     */
    String AUDIT_STATUS_SELECT = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/p[3]/select";

    /**
     * 是否上架-->xpath:select选择框
     */
    String ON_SHELF_SELECT = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/p[4]/select";

    /**
     * 是否到期-->xpath:select选择框
     */
    String IS_DUE_SELECT = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/p[5]/select";

    /**
     * 标的状态-->xpath:select选择框
     */
    String TARGET_STATUS_SELECT = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/p[6]/select";

    /**
     * 借款人-->xpath:select选择框
     */
    String BORROWER_SELECT = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/p[7]/select";

    /**
     * 发布渠道-->xpath:select选择框
     */
    String RELEASE_CHANNEL_SELECT = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/p[8]/select";

    /**
     * 申请时间-->xpath:文本输入框
     */
    String APPLICATION_TIME_INPUT = "";

    /**
     * 搜索-->xpath:按钮
     */
    String SEARCH_BUTTON = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/input[1]";

    /**
     * 新增-->xpath:按钮
     */
    String ADD_BUTTON = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/input[2]";

    /**
     * 上架-->xpath:按钮
     */
    String ON_SHELF_BUTTON = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/input[3]";

    /**
     * 下架-->xpath:按钮
     */
    String OFF_SHELF_BUTTON = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/input[4]";

    /**
     * 发布-->xpath:按钮
     */
    String RELEASE_BUTTON = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/input[5]";

    /**
     * 导出Excel-->xpath:按钮
     */
    String EXPORT_EXCEL_BUTTON = "//*[@id=\"form_loan\"]/div/div[1]/div[2]/div[1]/a";

}
