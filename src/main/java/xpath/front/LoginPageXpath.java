package xpath.front;

/**
 * 登陆页面
 * 
 * @author Yangdan
 *
 */
public interface LoginPageXpath {
	/**
	 * 登录提示信息xpath
	 */
	String LOGIN_MESSAGE_TEXT = "//*[@id=\"new-logo\"]/div/div[2]/div/div[1]/form/div";
	/**
	 * 用户名xpath
	 */
	String USERNAME_INPUT = "//*[@id=\"new-logo\"]/div/div[2]/div/div[1]/form/ul/li[1]/div[2]/input";//TODO
	/**
	 * 密码xpath
	 */
	String PASSWORD_INPUT = "//*[@id=\"new-logo\"]/div/div[2]/div/div[1]/form/ul/li[2]/div[2]/input";//TODO
	
	/**
	 * 登录按钮xpath
	 */
	String LOGIN_BUTTON="//*[@id=\"new-logo\"]/div/div[2]/div/div[1]/form/ul/li[3]/div[2]/input[1]";//TODO
}
