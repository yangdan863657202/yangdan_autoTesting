package xpath.front;

/**
 * Created by yangdan
 */
public interface SignPageXpath {
    /**
     * 账户中心右上角“立即签到”按钮:-->xpath:按钮
     */
    String SIGN1_BUTTON = "//*[@id=\"container\"]/div[1]/div[3]/div/a";

    /**
     * 签到页面“立即签到”按钮:-->xpath:按钮
     */
    String SIGN2_BUTTON = "//*[@id=\"container\"]/div[1]/div[3]/div[1]/div[1]/button";

    /**
     * 累积签到:-->xpath:只读文本
     */
    String CUMULATE_SIGN_INPUT = "//*[@id=\"lnum\"]";

    /**
     * 赚取积分:-->xpath:只读文本
     */
    String EARN_POINT_INPUT = "//*[@id=\"total_integral\"]";
}
