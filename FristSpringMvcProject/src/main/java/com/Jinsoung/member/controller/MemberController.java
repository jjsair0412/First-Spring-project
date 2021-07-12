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

	// MemberService에 @Service를 해주었기 때문에, @Autowired키워드만 작성해준다면 자동으로 주입되게 된다.
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
	
	//request가 사용자가 입력한 값을 가지고있다.
	public String memLogin(Model model, @RequestParam("memId") String memId, 
			                     @RequestParam(value = "memPw", required = false, defaultValue = "1234") String memPw) {
		// @RequestParma을 활용해 바로 받아올 수 있다.
		// required라는 속성이 있다.
		// true는 , 반드시 값이 넘어와야 한다. 값이 넘어오지 않으면 예외가 발생한다.
		// false는 값이 넘어오지 않아도 예외가 발생하지 않는다.
		// false일 경우, 값이 넘어오지 않는다면 default값을 정해주는 defaultValue를 설정할 수 도 있다.
		
		
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