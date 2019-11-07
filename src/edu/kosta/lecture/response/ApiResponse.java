package edu.kosta.lecture.response;

public class ApiResponse {

	private String msg;
	private ResponseStatus statusCode = ResponseStatus.initial;
	private String json;

	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ApiResponse(String msg, ResponseStatus code) {
		this.msg = msg;
		this.statusCode = code;
	}

	public ApiResponse(String msg, ResponseStatus code, String json) {
		this.msg = msg;
		this.statusCode = code;
		this.json = json;
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
	
	

	/**
	 * @return the json
	 */
	public String getJson() {
		return json;
	}

	/**
	 * @param json the json to set
	 */
	public void setJson(String json) {
		this.json = json;
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
