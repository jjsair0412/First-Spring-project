package com.jinsoung.SpringProject;

import java.awt.List;

import org.springframework.stereotype.Service;
@Service
public class myInfo {
	// 받아온 name과 일치하는 이름의 멤버변수들을 만들고 해당 변수들에게 각각
	// getter/setter를 만들어준다.
	private String NAME;
	private int NUM;
	private int AGE;
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public int getNUM() {
		return NUM;
	}
	public void setNUM(int NUM) {
		this.NUM = NUM;
	}
	public int getAGE() {
		return AGE;
	}
	public void setAGE(int AGE) {
		this.AGE = AGE;
	}
	
}
