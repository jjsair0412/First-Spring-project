package com.Jinsoung.frstpjt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Controller ������̼��� ����, �ش� Ŭ������ Controller�� ����
@Controller
public class FirstController_Login {
	
	// ������� ��û�� login�� ������, �ش� �޼������
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	// �����͸� ��ȯ���ֱ� ���� �Ķ���Ͱ��� model�� ����
	public String login(Model model) {
		
		// model�� Ư�� �����͸� �߰��Ѵ�.
		model.addAttribute("loginKey", "You success!");
		
		// login.jsp�� ����ȴ�. servlet-context.xml���� ������ ����ó��
		// view�� �̸��� return������ �������ش�.
		return "login";
	}
	
	
	
}
