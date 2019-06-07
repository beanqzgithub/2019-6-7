package com.woniuxy.bean;

import java.io.Serializable;
import java.util.Date;

//bean包中的类，实现序列化接口
public class User implements Serializable{
	private Integer id;
	private String name;
	private Date birthday;
	private double money;
	
	public User() {
		super();
	}
	public User(Integer id, String name, Date birthday, double money) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.money = money;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + ", money=" + money + "]";
	}
}
