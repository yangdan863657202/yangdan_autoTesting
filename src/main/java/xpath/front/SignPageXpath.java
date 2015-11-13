package xpath.front;

/**
 * Created by yangdan
 */
public interface SignPageXpath {
    /**
     * 账户中心右上角“立即签到”按钮:-->xpath:按钮
     */
    String SIGN1_BUTTON = "/html/body/div[3]/div[2]/div/div/div[1]/div[3]/div/a";

    /**
     * 签到页面“立即签到”按钮:-->xpath:按钮
     */
    String SIGN2_BUTTON = "/html/body/div[3]/div[2]/div/div[2]/div[1]/div/button";

    /**
     * 累积签到:-->xpath:只读文本
     */
    String CUMULATE_SIGN_INPUT = "/html/body/div[3]/div[2]/div/div[1]/div/p/span[1]";

    /**
     * 赚取积分:-->xpath:只读文本
     */
    String EARN_POINT_INPUT = "/html/body/div[3]/div[2]/div/div[1]/div/p/span[2]";
}
