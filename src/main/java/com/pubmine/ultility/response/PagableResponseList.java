package com.pubmine.ultility.response;

import com.pubmine.ultility.Pagable;

public class PagableResponseList extends Response {

	private Object[] data;
	private Pagable pagable;
	
	public PagableResponseList() {
		super();
	}

	public PagableResponseList(Pagable pagable, Object... data) {
		super();
		this.data = data;
		this.pagable = pagable;
	}

	public PagableResponseList(boolean status, Pagable pagable, Object... data) {
		super(status);
		this.data = data;
		this.pagable = pagable;
	}

	public PagableResponseList(boolean status, String message, Pagable pagable, Object... data) {
		super(status, message);
		this.data = data;
		this.pagable = pagable;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object... data) {
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
