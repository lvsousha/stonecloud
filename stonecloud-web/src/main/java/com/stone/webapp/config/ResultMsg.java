package com.stone.webapp.config;

import com.alibaba.fastjson.JSONObject;

public class ResultMsg {

	private String code;
	private String message;
	private Object result;
	
	public static ResultMsg FAIL = new ResultMsg("500", "操作失败", new JSONObject());
	public static ResultMsg SUCCESS = new ResultMsg("200", "操作成功", new JSONObject());
	
	public ResultMsg(String code, String message, Object result){
		this.setCode(code);
		this.setMessage(message);
		this.setResult(result);
	}
	
	public static ResultMsg getSuccess(Object result){
		return new ResultMsg("200", "操作成功", result);
	}
	
	public static ResultMsg getFail(Object result){
		return FAIL;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}
