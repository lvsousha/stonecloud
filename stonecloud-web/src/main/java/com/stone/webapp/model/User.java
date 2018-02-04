package com.stone.webapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * 银行卡
 */
@Entity
@Table
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String userName;						//用户名
	private String password;						//密码
	private String nickName;						//昵称
	private List<BankCard> bankCards;				//银行卡
	private UserDetail userDetail;					//明细
	private Date createDate;						//创建日期
	private Date updateDate;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column//更新日期
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public List<BankCard> getBankCards() {
		return bankCards;
	}
	public void setBankCards(List<BankCard> bankCards) {
		this.bankCards = bankCards;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(updatable=false)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@OneToOne(mappedBy = "user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
}
