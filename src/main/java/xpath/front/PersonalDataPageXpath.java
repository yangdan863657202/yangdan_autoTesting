package xpath.front;

/**
 * Created by yangdan
 */
public interface PersonalDataPageXpath {
    /**
     * 个人资料页面“性别”选择框:-->xpath:选择框
     */
    String GENDER_SELECT = "";

    /**
     * 个人资料页面“出生地”输入框:-->xpath:文本输入框
     */
    String BIRTH_PLACE_INPUT = "//*[@id=\"member_info\"]/div[2]/input";

    /**
     * 个人资料页面“毕业学校”输入框:-->xpath:文本输入框
     */
    String GRADUATE_SCHOOL_INPUT = "//*[@id=\"member_info\"]/div[3]/input";

    /**
     * 个人资料页面“学历”选择框:-->xpath:选择框
     */
    String EDUCATION_SELECT = "";

    /**
     * 个人资料页面“公司”输入框:-->xpath:文本输入框
     */
    String COMPANY_INPUT = "//*[@id=\"member_info\"]/div[5]/input";

    /**
     * 个人资料页面“职业”输入框:-->xpath:文本输入框
     */
    String JOB_INPUT = "//*[@id=\"member_info\"]/div[6]/input";

    /**
     * 个人资料页面“职位”输入框:-->xpath:文本输入框
     */
    String POSITION_INPUT = "//*[@id=\"member_info\"]/div[7]/input";

    /**
     * 个人资料页面“年收入”输入框:-->xpath:文本输入框
     */
    String ANNAL_INCOME_INPUT = "//*[@id=\"member_info\"]/div[8]/input";
}
