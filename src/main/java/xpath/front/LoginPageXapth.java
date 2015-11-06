package xpath.front;

/**
 * 登陆页面
 * 
 * @author Yangdan
 *
 */
public interface LoginPageXapth {
	/**
	 * 用户名xpath
	 */
	String USERNAME_INPUT = "//*[@id=\"userId\"]";//TODO
	/**
	 * 密码xpath
	 */
	String PASSWORD_INPUT = "//*[@id=\"loginPassword\"]";//TODO
	
	/**
	 * 登录按钮xpath
	 */
	String LOGIN_BUTTON="//*[@id=\"new-logo\"]/div/div[2]/div/div[1]/form/ul/li[3]/div[2]/input";//TODO
}
