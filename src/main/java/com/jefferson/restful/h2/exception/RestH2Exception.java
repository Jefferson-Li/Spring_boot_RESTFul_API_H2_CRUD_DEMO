package com.jefferson.restful.h2.exception;

public class RestH2Exception extends Exception {

	private static final long serialVersionUID = 1L;

	private String ResponseCode;

	private String ResponseMessage;

	public RestH2Exception() {
	}

	public RestH2Exception(String responseCode, String responseMessage) {
		ResponseCode = responseCode;
		ResponseMessage = responseMessage;
	}

	public String getResponseCode() {
		return ResponseCode;
	}

	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}

	public String getResponseMessage() {
		return ResponseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		ResponseMessage = responseMessage;
	}


}
