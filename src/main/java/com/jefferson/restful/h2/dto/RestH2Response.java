package com.jefferson.restful.h2.dto;

import java.util.List;

import com.jefferson.restful.h2.entity.RestH2Entity;

public class RestH2Response {

	private String ResponseCode;

	private String ResponseMessage;

	private List<RestH2Entity> data;

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

	public List<RestH2Entity> getData() {
		return data;
	}

	public void setData(List<RestH2Entity> data) {
		this.data = data;
	}

}
