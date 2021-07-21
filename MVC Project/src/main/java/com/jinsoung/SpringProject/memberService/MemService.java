package com.jinsoung.SpringProject.memberService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jinsoung.SpringProject.myInfo;
import com.jinsoung.SpringProject.memberDao.Dao;
// MemService Ŭ������ @Service ������̼��� �޾��־��� ������
// �ش� Ŭ������ �̿��ؼ� ��ü�� �����ϱ� ���� ����
// MemService '���۷�����' = new MemService();
// �̷��� ���ϰ� MemService '���۷�����' �̷��Ը� �ۼ����ְ�
// ��ܿ� @Autowired�� �ۼ��Ѵٸ�. �ڵ����� ��ü�� ���ԵǾ� ����Ҽ� �ְ� �ȴ�.
@Service
public class MemService {
	
	private Dao dao;
	private myInfo myinfo;
	
	@Autowired
	public MemService(Dao dao, myInfo myinfo) {
		this.dao = dao;
		this.myinfo = myinfo;
	}
	
	private int result = 0;
	public void MemServiceInsert(String NAME, int NUM, int AGE) {
		
		try {
			result = dao.Insert(NAME, NUM, AGE);
			
			if(result == 1) {
				System.out.println("DB �Է� �Ϸ�");
			}else {
				System.out.println("�Է� ����");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public myInfo MemServiceSelect(String selfName) {
		try {
			myinfo = dao.Read(selfName);
			if(myinfo!=null) {
				System.out.println("�������� ����");
			}else {
				System.out.println("�������� ����");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return myinfo;
	}
	
	public myInfo MemServiceUpdateNum(int NUM, String NAME) {
		try {
			int result = 0;
			result = dao.Update(NUM,NAME);
			if(result == 1) {
				System.out.println("������Ʈ �Ϸ�");
				myinfo = dao.Read(NAME);
			}else {
				System.out.println("������Ʈ ����");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return myinfo;
	}
	
	public void MemServiceDeleteNum(String NAME) {
		try {
			int result = 0;
			result = dao.Drop(NAME);
			if(result ==1 ) {
				System.out.println("���� �Ϸ�");
			}else {
				System.out.println("���� ����");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public myInfo MemServiceSearch(String NAME, int NUM) {
			String inputName = NAME;
			int inputNum = NUM;
			
			myinfo = dao.MemServiceSearch(NAME, NUM);
			
			if(myinfo.getNAME()!=null && myinfo.getNUM()!=0) {
				System.out.println("�α��� ����");
				return myinfo;
			}else if(myinfo.getNAME()!=null || myinfo.getNUM()!=0) {
				System.out.println("�й��Ǵ� �̸��� �߸��Է��ϼ̽��ϴ�.");
				return null;
			}else {
				return null;
			}
			
	}
}
