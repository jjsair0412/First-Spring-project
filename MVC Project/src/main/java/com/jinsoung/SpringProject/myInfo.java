package com.jinsoung.SpringProject;

import java.awt.List;

import org.springframework.stereotype.Service;

public class myInfo {
	// �޾ƿ� name�� ��ġ�ϴ� �̸��� ����������� ����� �ش� �����鿡�� ����
	// getter/setter�� ������ش�.
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
