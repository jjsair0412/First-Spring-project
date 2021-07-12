package com.Jinsoung.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Jinsoung.member.*;
import com.Jinsoung.member.dao.*;


// 컨트롤러의 의존성 주입을 하는 방법은, 총 3가지가 있다.
// 1. 기존 자바의 방식대로 new키워드를 사용해 객체를 생성한다음, 참조연산자로 해당 객체의 메서드를 가지고오는방법.
// 2. Spring의 방식으로, 컨테이너에 bean을 생성해서, @Autowired를 사용해 자동주입을 해주는 방법.
// 3. 주입할 객체에 @Service 어노테이션을 작성해서, 어떤 컨트롤러에 new키워드를 사용하지않고 MemberService service라고 초기화만
// 시켜주고 초기화된 곳에 @Autowired 태그를 작성만 해주면 bean을 생성하지 않았음에도 자동으로 주입되는 방법.
// 해당 예제코드는 3번째 방법으로, MemberService를 MemberController.java에 자동으로 주입시켜주고 있다.
// 3번째 방법은 @Service, @Component, @Repository 세가지 어노테이션이 동일하기때문에, 셋중 하나만 써주면 된다.
// Repository나 Resource()를 사용할때, 특정한 이름을 지정해줄 수도 있다.

@Service
// @Component
//@Repository("memService")
public class MemberService implements IMemberService {

	@Autowired
	MemberDao dao;
	
	@Override
	public void memberRegister(String memId, String memPw, String memMail,
			String memPhone1, String memPhone2, String memPhone3) {
		System.out.println("memberRegister()");
		System.out.println("memId : " + memId);
		System.out.println("memPw : " + memPw);
		System.out.println("memMail : " + memMail);
		System.out.println("memPhone : " + memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		dao.memberInsert(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
	}

	@Override
	public Member memberSearch(String memId, String memPw) {
		System.out.println("memberSearch()");
		System.out.println("memId : " + memId);
		System.out.println("memPw : " + memPw);
		
		Member member = dao.memberSelect(memId, memPw);
		
		return member;
	}

	@Override
	public void memberModify() {
		
	}

	@Override
	public void memberRemove() {
		
	}

}