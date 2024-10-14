package com.jefferson.restful.h2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestH2Request {

	@JsonProperty("ShopId")
	private Long shopid;

	@JsonProperty("ShopName")
	private String shopName;

	@JsonProperty("ShopNo")
	private Integer shopNo;

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getShopNo() {
		return shopNo;
	}

	public void setShopNo(Integer shopNo) {
		this.shopNo = shopNo;
	}

}
