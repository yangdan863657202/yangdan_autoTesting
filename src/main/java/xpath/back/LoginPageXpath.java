package xpath.back;

/**
 * Created by yangdan
 */
public interface LoginPageXpath {
    /**
     * 用户名xpath
     */
    String USERNAME_INPUT = "//*[@id=\"txUserId\"]";//TODO
    /**
     * 密码xpath
     */
    String PASSWORD_INPUT = "//*[@id=\"passwordId\"]";//TODO

    /**
     * 登录按钮xpath
     */
    String LOGIN_BUTTON="/html/body/div[1]/div[2]/form/div[4]/input";//TODO
}
