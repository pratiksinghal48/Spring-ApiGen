package gen.api.mvc.exceptions;

@SuppressWarnings("serial")
public class BuilderException extends Exception {

	public BuilderException() {
		super();
	}

	public BuilderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BuilderException(String message, Throwable cause) {
		super(message, cause);
	}

	public BuilderException(String message) {
		super(message);
	}

	public BuilderException(Throwable cause) {
		super(cause);
	}
}
