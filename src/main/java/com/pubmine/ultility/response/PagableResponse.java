package com.pubmine.ultility.response;

import com.pubmine.ultility.Pagable;

public class PagableResponse extends Response {

	private Object data;
	private Pagable pagable;
	
	public PagableResponse() {
		super();
	}

	public PagableResponse(Object data, Pagable pagable) {
		super();
		this.data = data;
		this.pagable = pagable;
	}

	public PagableResponse(boolean status, Object data, Pagable pagable) {
		super(status);
		this.data = data;
		this.pagable = pagable;
	}

	public PagableResponse(boolean status, String message, Object data, Pagable pagable) {
		super(status, message);
		this.data = data;
		this.pagable = pagable;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Pagable getPagable() {
		return pagable;
	}

	public void setPagable(Pagable pagable) {
		this.pagable = pagable;
	}

	@Override
	public String toString() {
		return "PagableResponse [data=" + data + ", pagable=" + pagable + ", status=" + status + ", message=" + message
				+ "]";
	}

}
