package com.jefferson.restful.h2.dao.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RED_TEA")
public class RedTeaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RED_TEA_ID")
	private Long redTeaId;

	@Column(name = "ITEM_NO")
	private String itemNo;

	@Column(name = "RED_TEA_NO")
	private String redTeaNo;

	@Column(name = "RED_TEA_NAME")
	private String redTeaName;

	@Column(name = "RED_TEA_PRICE")
	private Integer redTeaPrice;

	@Column(name = "RED_TEA_SUGAR")
	private Integer redTeaSugar;

	@Column(name = "RED_TEA_ICE")
	private Integer redTeaIce;

	@Column(name = "RED_TEA_NUMS")
	private Integer redTeaNums;

	@Column(name = "CREATE_TIME")
	private LocalDateTime createTime;

	@Column(name = "UPD_DATE_TIME")
	private LocalDateTime updDateTime;

	public RedTeaEntity() {
	}

	public RedTeaEntity(Long redTeaId, String itemNo, String redTeaNo, String redTeaName, Integer redTeaPrice,
			Integer redTeaSugar, Integer redTeaIce, Integer redTeaNums, LocalDateTime createTime,
			LocalDateTime updDateTime) {
		this.redTeaId = redTeaId;
		this.itemNo = itemNo;
		this.redTeaNo = redTeaNo;
		this.redTeaName = redTeaName;
		this.redTeaPrice = redTeaPrice;
		this.redTeaSugar = redTeaSugar;
		this.redTeaIce = redTeaIce;
		this.redTeaNums = redTeaNums;
		this.createTime = createTime;
		this.updDateTime = updDateTime;
	}

	public Long getRedTeaId() {
		return redTeaId;
	}

	public void setRedTeaId(Long redTeaId) {
		this.redTeaId = redTeaId;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getRedTeaNo() {
		return redTeaNo;
	}

	public void setRedTeaNo(String redTeaNo) {
		this.redTeaNo = redTeaNo;
	}

	public String getRedTeaName() {
		return redTeaName;
	}

	public void setRedTeaName(String redTeaName) {
		this.redTeaName = redTeaName;
	}

	public Integer getRedTeaPrice() {
		return redTeaPrice;
	}

	public void setRedTeaPrice(Integer redTeaPrice) {
		this.redTeaPrice = redTeaPrice;
	}

	public Integer getRedTeaSugar() {
		return redTeaSugar;
	}

	public void setRedTeaSugar(Integer redTeaSugar) {
		this.redTeaSugar = redTeaSugar;
	}

	public Integer getRedTeaIce() {
		return redTeaIce;
	}

	public void setRedTeaIce(Integer redTeaIce) {
		this.redTeaIce = redTeaIce;
	}

	public Integer getRedTeaNums() {
		return redTeaNums;
	}

	public void setRedTeaNums(Integer redTeaNums) {
		this.redTeaNums = redTeaNums;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdDateTime() {
		return updDateTime;
	}

	public void setUpdDateTime(LocalDateTime updDateTime) {
		this.updDateTime = updDateTime;
	}

}
