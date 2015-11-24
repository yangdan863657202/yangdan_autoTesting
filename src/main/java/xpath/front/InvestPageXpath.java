package xpath.front;

/**
 * Created by yangdan
 */
public interface InvestPageXpath {

    /**
     * 投资详情页面“投资金额”输入框:-->xpath:文本输入框
     */
    String INVEST_AMOUNT_INPUT = "//*[@id=\"detail_money\"]";

    /**
     * 投资详情页面“立即投资”按钮:-->xpath:按钮
     */
    String IMMEDIATE_INVEST_BUTTON = "//*[@id=\"zdtz\"]/div/div[2]/div[1]/div[2]/div/div[2]/a[2]";

    /**
     * 投资确认页面“储蓄罐抵扣”输入框:-->xpath:文本输入框
     */
    String PIGGY_DEDUCT_INPUT = "//*[@id=\"piggy_detail\"]";

    /**
     * 投资确认页面“确认支付”按钮:-->xpath:按钮
     */
    String CONFIRM_PAY_BUTTON = "//*[@id=\"invest_sure\"]";
}
