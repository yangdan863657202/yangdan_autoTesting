package xpath.front;

/**
 * Created by yangdan
 */
public interface ReceiveAddressPageXpath {
    /**
     * 收货地址页面“新增地址”按钮:-->xpath:按钮
     */
    String NEW_ADDRESS_BUTTON = "//*[@id=\"addressbox\"]/div/div/div/a";

    /**
     * 收货地址页面“收货人”输入框:-->xpath:文本输入框
     */
    String RECEIVER_INPUT = "//*[@id=\"add_addr\"]/div/div/div[2]/input";

    /**
     * 收货地址页面“所在地区--省”选择框:-->xpath:选择框
     */
    String AREA_PROVINCE_SELECT = "//*[@id=\"province\"]";

    /**
     * 收货地址页面“所在地区--市”选择框:-->xpath:选择框
     */
    String AREA_CITY_SELECT = "//*[@id=\"city\"]";

    /**
     * 收货地址页面“所在地区--县”选择框:-->xpath:选择框
     */
    String AREA_DISTRICT_SELECT = "//*[@id=\"district\"]";

    /**
     * 收货地址页面“详细地址”输入框:-->xpath:文本输入框
     */
    String DETAIL_ADDRESS_INPUT = "//*[@id=\"add_addr\"]/div/div/div[4]/input";

    /**
     * 收货地址页面“手机号码”输入框:-->xpath:文本输入框
     */
    String CELLPHONE_INPUT = "//*[@id=\"add_addr\"]/div/div/div[5]/input[1]";

    /**
     * 收货地址页面“固定号码”输入框:-->xpath:文本输入框
     */
    String FIXED_NUMBER_INPUT = "//*[@id=\"add_addr\"]/div/div/div[5]/input[2]";

    /**
     * 收货地址页面“地址别名”输入框:-->xpath:文本输入框
     */
    String ADDRESS_ALIAS_INPUT = "//*[@id=\"add_addr\"]/div/div/div[6]/input";

    /**
     * 收货地址页面“保存”按钮:-->xpath:按钮
     */
    String SAVE_BUTTON = "//*[@id=\"add_address\"]";
}
