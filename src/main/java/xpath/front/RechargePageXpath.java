package xpath.front;

/**
 * Created by yangdan
 */
public interface RechargePageXpath {

    /**
     * 账户中心资金账户页面“充值”按钮:-->xpath:按钮
     */
    String RECHARGE_BUTTON = "//*[@id=\"container\"]/div[3]/div[3]/div[3]/div[2]/div[2]/div/p[5]/a[2]";

    /**
     * 易极付充值页面“充值金额”输入框:-->xpath:文本输入框
     */
    String RECHARGE_AMOUNT_INPUT = "//*[@id=\"depositSubmitData\"]/div[1]/input";

    /**
     * 易极付充值页面“下一步”按钮:-->xpath:按钮
     */
    String NEXT_STEP_BUTTON = "//*[@id=\"depositSubmitBtn\"]";

    /**
     * 易极付提示信息页面“确认”按钮:-->xpath:按钮
     */
    String CONFIRM_BUTTON = "//*[@id=\"fn-chargeLayer\"]/div[2]/button";

    /**
     * 易极付我的订单页面“确定支付”按钮:-->xpath:按钮
     */
    String CONFIRM_PAY_BUTTON = "//*[@id=\"submitImg\"]";
}
