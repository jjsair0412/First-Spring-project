package com.jinsoung.SpringProject.memberService;

import com.jinsoung.SpringProject.myInfo;
import com.jinsoung.SpringProject.memberDao.Dao;
import com.jinsoung.SpringProject.memberDao.myInfoDto;

public class MemService {
	Dao dao = new Dao();
	private myInfoDto myinfoDto = new myInfoDto();
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
	
	public void MemServiceSelect(String selfName) {
		try {
			myinfoDto = dao.Read(selfName);
				
			if(myinfoDto!=null) {
				System.out.println("가져오기 성공");
			}else {
				System.out.println("가져오기 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
