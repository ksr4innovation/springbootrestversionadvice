package com.snkit.restversionadvice;

public class DemoException extends RuntimeException {

	
	private String corelationid;
	private String msg;
	
	public DemoException(String coid,String msg){
		super(msg);
		this.corelationid = coid;
		this.msg = msg;
	}

	public String getCorelationid() {
		return corelationid;
	}

	public void setCorelationid(String corelationid) {
		this.corelationid = corelationid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
