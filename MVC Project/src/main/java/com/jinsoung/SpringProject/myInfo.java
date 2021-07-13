package com.jinsoung.SpringProject;

import org.springframework.stereotype.Service;

public class myInfo {
	// 받아온 name과 일치하는 이름의 멤버변수들을 만들고 해당 변수들에게 각각
	// getter/setter를 만들어준다.
	private String name;
	private String number;
	private String age;
	private String Phone1;
	private String Phone2;
	private String Phone3;
	public String getPhone1() {
		return Phone1;
	}
	public void setPhone1(String phone1) {
		Phone1 = phone1;
	}
	public String getPhone2() {
		return Phone2;
	}
	public void setPhone2(String phone2) {
		Phone2 = phone2;
	}
	public String getPhone3() {
		return Phone3;
	}
	public void setPhone3(String phone3) {
		Phone3 = phone3;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
