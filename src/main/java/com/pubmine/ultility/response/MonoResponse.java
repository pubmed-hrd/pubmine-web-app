package com.pubmine.ultility.response;

public class MonoResponse extends Response {

	public MonoResponse() {
		super();
	}

	public MonoResponse(Object data) {
		super();
		this.data = data;
	}

	public MonoResponse(boolean status, Object data) {
		super(status);
		this.data = data;
	}

	public MonoResponse(boolean status, String message, Object data) {
		super(status, message);
		this.data = data;
	}

	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MonoResponse [data=" + data + ", status=" + status + ", message=" + message + "]";
	}

}
