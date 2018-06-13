package com.stone.webapp.model;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)			//不包含有null值的字段,即字段值为null的转换为json字符串时会被省略
@TableName("USERS")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -980002658052499530L;
	private int id;	
	private String name;
	private String password;
	private String email;
	@JsonProperty("phone")
	private String phone;
	private Date created;
	private Date updated;
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	@JsonProperty("phone")					//设置该字段转换为json后的字段名
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public Date getCreated() {
//		return created;
//	}
//	public void setCreated(Date created) {
//		this.created = created;
//	}
//	public Date getUpdated() {
//		return updated;
//	}
//	public void setUpdated(Date updated) {
//		this.updated = updated;
//	}
	
}
