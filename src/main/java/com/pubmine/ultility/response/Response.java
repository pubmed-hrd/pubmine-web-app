package com.pubmine.ultility.response;

public class Response {

	protected boolean status;
	protected String message;

	public Response() {
		this(true, "Operation Successfully!");
	}

	public Response(boolean status) {
		this.setStatus(status);
	}

	public Response(boolean status, String message) {
		this.setStatus(status);
		this.setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
		if (this.status)
			this.setMessage("Operation Successfully!");
		else
			this.setMessage("Operation Failed!");
	}

	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + "]";
	}

}
