package com.jinsoung.SpringProject.memberService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jinsoung.SpringProject.myInfo;
import com.jinsoung.SpringProject.memberDao.Dao;
// MemService 클래스에 @Service 어노테이션을 달아주었기 때문에
// 해당 클래스를 이용해서 객체를 생성하기 위해 굳이
// MemService '레퍼런스명' = new MemService();
// 이렇게 안하고 MemService '레퍼런스명' 이렇게만 작성해주고
// 상단에 @Autowired만 작성한다면. 자동으로 객체가 주입되어 사용할수 있게 된다.
@Service
public class MemService {
	@Autowired
	Dao dao;
	
	@Autowired
	private myInfo myinfo;
	
	private int result = 0;
	public void MemServiceInsert(String NAME, int NUM, int AGE) {
		
		try {
			result = dao.Insert(NAME, NUM, AGE);
			
			if(result == 1) {
				System.out.println("DB 입력 완료");
			}else {
				System.out.println("입력 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public myInfo MemServiceSelect(String selfName) {
		try {
			myinfo = dao.Read(selfName);
			if(myinfo!=null) {
				System.out.println("가져오기 성공");
			}else {
				System.out.println("가져오기 실패");
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
				System.out.println("업데이트 완료");
				myinfo = dao.Read(NAME);
			}else {
				System.out.println("업데이트 실패");
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
				System.out.println("삭제 완료");
			}else {
				System.out.println("삭제 실패");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void MemServiceSearch(String NAME, int NUM) {
		
		
		
	}
}
