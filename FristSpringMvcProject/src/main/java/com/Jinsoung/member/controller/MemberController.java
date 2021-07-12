package com.Jinsoung.member.controller;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Jinsoung.member.*;
import com.Jinsoung.member.service.*;

@Controller
public class MemberController {

	// MemberService�� @Service�� ���־��� ������, @AutowiredŰ���常 �ۼ����شٸ� �ڵ����� ���Եǰ� �ȴ�.
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/memJoin", method=RequestMethod.POST)
	public String memJoin(Model model, HttpServletRequest request) {
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memPhone3 = request.getParameter("memPhone3");
		
		service.memberRegister(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
		
		model.addAttribute("memId", memId);
		model.addAttribute("memPw", memPw);
		model.addAttribute("memMail", memMail);
		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		return "memJoinOk";
	}
	
	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
	
	//request�� ����ڰ� �Է��� ���� �������ִ�.
	public String memLogin(Model model, @RequestParam("memId") String memId, 
			                     @RequestParam(value = "memPw", required = false, defaultValue = "1234") String memPw) {
		// @RequestParma�� Ȱ���� �ٷ� �޾ƿ� �� �ִ�.
		// required��� �Ӽ��� �ִ�.
		// true�� , �ݵ�� ���� �Ѿ�;� �Ѵ�. ���� �Ѿ���� ������ ���ܰ� �߻��Ѵ�.
		// false�� ���� �Ѿ���� �ʾƵ� ���ܰ� �߻����� �ʴ´�.
		// false�� ���, ���� �Ѿ���� �ʴ´ٸ� default���� �����ִ� defaultValue�� ������ �� �� �ִ�.
		
		
		Member member = service.memberSearch(memId, memPw);
		
		try {
			model.addAttribute("memId", member.getMemId());
			model.addAttribute("memPw", member.getMemPw());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "memLoginOk";
	}
	
}