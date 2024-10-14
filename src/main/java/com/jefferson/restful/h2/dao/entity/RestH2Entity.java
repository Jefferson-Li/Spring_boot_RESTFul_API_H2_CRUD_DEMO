package com.jefferson.restful.h2.dao.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REST_H2")
public class RestH2Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SHOP_ID")
	private Long shopId;

	@Column(name = "SHOP_NO")
	private String shopNo;

	@Column(name = "SHOP_NAME")
	private String shopName;

	@Column(name = "SHOP_DETAIL")
	private String shopDetail;

	@Column(name = "SHOP_CREATETIME")
	private LocalDateTime shopCreateTime;

	@Column(name = "SHOP_UPDATETIME")
	private LocalDateTime shopUpdateTime;

	public RestH2Entity() {
	}

	public RestH2Entity(Long shopId, String shopNo, String shopName, LocalDateTime shopCreateTime,
			LocalDateTime shopUpdateTime) {
		this.shopId = shopId;
		this.shopNo = shopNo;
		this.shopName = shopName;
		// this.shopDetail = shopDetail;
		this.shopCreateTime = shopCreateTime;
		this.shopUpdateTime = shopUpdateTime;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDetail() {
		return shopDetail;
	}

	public void setShopDetail(String shopDetail) {
		this.shopDetail = shopDetail;
	}

	public LocalDateTime getShopCreateTime() {
		return shopCreateTime;
	}

	public void setShopCreateTime(LocalDateTime shopCreateTime) {
		this.shopCreateTime = shopCreateTime;
	}

	public LocalDateTime getShopUpdateTime() {
		return shopUpdateTime;
	}

	public void setShopUpdateTime(LocalDateTime shopUpdateTime) {
		this.shopUpdateTime = shopUpdateTime;
	}

}
