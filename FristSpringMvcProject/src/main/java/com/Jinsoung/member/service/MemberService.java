package com.Jinsoung.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Jinsoung.member.*;
import com.Jinsoung.member.dao.*;


// ��Ʈ�ѷ��� ������ ������ �ϴ� �����, �� 3������ �ִ�.
// 1. ���� �ڹ��� ��Ĵ�� newŰ���带 ����� ��ü�� �����Ѵ���, ���������ڷ� �ش� ��ü�� �޼��带 ��������¹��.
// 2. Spring�� �������, �����̳ʿ� bean�� �����ؼ�, @Autowired�� ����� �ڵ������� ���ִ� ���.
// 3. ������ ��ü�� @Service ������̼��� �ۼ��ؼ�, � ��Ʈ�ѷ��� newŰ���带 ��������ʰ� MemberService service��� �ʱ�ȭ��
// �����ְ� �ʱ�ȭ�� ���� @Autowired �±׸� �ۼ��� ���ָ� bean�� �������� �ʾ������� �ڵ����� ���ԵǴ� ���.
// �ش� �����ڵ�� 3��° �������, MemberService�� MemberController.java�� �ڵ����� ���Խ����ְ� �ִ�.
// 3��° ����� @Service, @Component, @Repository ������ ������̼��� �����ϱ⶧����, ���� �ϳ��� ���ָ� �ȴ�.
// Repository�� Resource()�� ����Ҷ�, Ư���� �̸��� �������� ���� �ִ�.

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