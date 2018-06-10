package com.stone.webapp.config.exception;

import com.stone.webapp.config.ResultMsg;

public class ApiException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private ResultMsg result;
	
	public ApiException(ResultMsg result) {
		super(result.toString());
		this.setResult(result);
	}
	
	public ResultMsg getResult() {
		return result;
	}

	public void setResult(ResultMsg result) {
		this.result = result;
	}
	
}
