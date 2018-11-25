package com.snkit.restversionadvice;

import java.util.ArrayList;
import java.util.List;

public class AppError {
	
	private String errorType;
	
	private String msg;
	
	private String coorlationid;
	
	private String code;
	
	public AppError() {
		errorsList = new ArrayList<String>();
	}
	
	private List<String> errorsList;

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCoorlationid() {
		return coorlationid;
	}

	public void setCoorlationid(String coorlationid) {
		this.coorlationid = coorlationid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getErrorsList() {
		return errorsList;
	}

	public void setErrorsList(List<String> errorsList) {
		this.errorsList = errorsList;
	}
	
	

}
