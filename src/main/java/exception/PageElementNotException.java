package exception;


@SuppressWarnings("serial")
public class PageElementNotException extends Exception{
	private static final String loginErr = "页面元素对象没有找到：";
	public PageElementNotException() {
		super();
	}
	public PageElementNotException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(loginErr+message, cause, enableSuppression, writableStackTrace);
	}

	public PageElementNotException(String message, Throwable cause) {
		super(loginErr+message, cause);
	}

	public PageElementNotException(String message) {
		super(loginErr+message);
	}

	public PageElementNotException(Throwable cause) {
		super(cause);
	}

}
