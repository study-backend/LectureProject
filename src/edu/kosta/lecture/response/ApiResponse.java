package edu.kosta.lecture.response;

public class ApiResponse {

	private String msg;
	private ResponseStatus statusCode = ResponseStatus.initial;

	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(String msg, ResponseStatus code) {
		this.msg = msg;
		this.statusCode = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResponseStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(ResponseStatus statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ApiResponse{");
		sb.append("msg='").append(msg).append('\'');
		sb.append(", statusCode=").append(statusCode);
		sb.append('}');
		return sb.toString();
	}
}
