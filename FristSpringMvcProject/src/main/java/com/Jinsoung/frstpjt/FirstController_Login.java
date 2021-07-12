package com.Jinsoung.frstpjt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Controller 어노테이션을 만들어서, 해당 클래스를 Controller로 만듦
@Controller
public class FirstController_Login {
	
	// 사용자의 요청이 login이 들어오면, 해당 메서드실행
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	// 데이터를 반환해주기 위해 파라미터값을 model로 지정
	public String login(Model model) {
		
		// model에 특정 데이터를 추가한다.
		model.addAttribute("loginKey", "You success!");
		
		// login.jsp가 실행된다. servlet-context.xml에서 설정한 내용처럼
		// view의 이름을 return값으로 설정해준다.
		return "login";
	}
	
	
	
}
