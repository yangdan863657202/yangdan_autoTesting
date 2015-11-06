package exception;

@SuppressWarnings("serial")
public class LoginException extends Exception{

	private static final String loginErr = "登录异常：";

	public LoginException() {
		super();
	}

	public LoginException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(loginErr+message, cause, enableSuppression, writableStackTrace);
	}

	public LoginException(String message, Throwable cause) {
		super(loginErr+message, cause);
	}

	public LoginException(String message) {
		super(loginErr+message);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}

	
}
