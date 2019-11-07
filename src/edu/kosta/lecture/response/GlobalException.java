package edu.kosta.lecture.response;

public class GlobalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg;
	private ResponseStatus statusCode = ResponseStatus.initial;

	public GlobalException() {
		// TODO Auto-generated constructor stub
	}

	public GlobalException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GlobalException(String message, ResponseStatus code) {
		super(message);
		this.msg = message;
		this.statusCode = code;
	}

	public GlobalException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public GlobalException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String message) {
		this.msg = message;
	}

	public ResponseStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(ResponseStatus statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("GlobalException{");
		sb.append("msg='").append(msg).append('\'');
		sb.append(", statusCode=").append(statusCode);
		sb.append('}');
		return sb.toString();
	}
}
