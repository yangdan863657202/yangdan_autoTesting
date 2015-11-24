package xpath.front;

/**
 * Created by yangdan
 */
public interface WithdrawPageXpath {
    /**
     * 账户中心资金账户页面“提现”按钮:-->xpath:按钮
     */
    String WITHDRAW_BUTTON = "//*[@id=\"container\"]/div[3]/div[3]/div[3]/div[2]/div[2]/div/p[5]/a[1]";

    /**
     * 普资提现页面“提现金额”输入框:-->xpath:文本输入框
     */
    String WITHDRAW_AMOUNT_INPUT = "//*[@id=\"container\"]/div[2]/div[2]/div[2]/ul/li[2]/span[2]/input";

    /**
     * 普资提现页面“提现”按钮:-->xpath:按钮
     */
    String WITHDRAW_BUTTON1 = "//*[@id=\"container\"]/div[2]/div[2]/div[2]/ul/li[3]/a";
}
