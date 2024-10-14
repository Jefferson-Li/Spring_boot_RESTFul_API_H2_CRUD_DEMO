package com.jefferson.restful.h2.dao.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_ID")
	private Long itemId;

	@Column(name = "SHOP_NO")
	private String shopNo;

	@Column(name = "ITEM_NO")
	private String itemNo;

	@Column(name = "ITEM_NAME")
	private String itemName;

	@Column(name = "ITEM_PRICE")
	private Integer itemPrice;

	@Column(name = "ITEM_NUMS")
	private Integer itemNums;

	@Column(name = "ITEM_DETAIL")
	private String itemDetail;

	@Column(name = "CREATE_TIME")
	private LocalDateTime createTime;

	@Column(name = "UPD_DATE_TIME")
	private LocalDateTime updDateTime;

	public ItemEntity() {
	}

	public ItemEntity(Long itemId, String shopNo, String itemNo, String itemName, Integer itemPrice, Integer itemNums,
			LocalDateTime createTime, LocalDateTime updDateTime) {
		this.itemId = itemId;
		this.shopNo = shopNo;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemNums = itemNums;
		this.createTime = createTime;
		this.updDateTime = updDateTime;
	}



}
