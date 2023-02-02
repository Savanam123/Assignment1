package com.jocata.mapping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Transactional
@Table(name="Emp_Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="Add_id")
	private Integer addId;
	
	@Column(name="add_City")
	private String  city;
	
	@Column(name="add_Type")
	private String addType;

	public Address(String city, String addType) {
		super();
		this.city = city;
		this.addType = addType;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddType() {
		return addType;
	}

	public void setAddType(String addType) {
		this.addType = addType;
	}

	public Integer getAddId() {
		return addId;
	}

	public void setAddId(Integer addId) {
		this.addId = addId;
	}
	
	

}
