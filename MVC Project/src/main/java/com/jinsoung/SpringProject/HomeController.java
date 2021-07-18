package com.jinsoung.SpringProject;

import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jinsoung.SpringProject.memberService.MemService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	// MemService��ü�� newŰ����� �������� �ʾƵ�, �ش� ��ü�� Service ������̼��� �޾ƢZ�� ������, ��ü�� �ڵ����� ���Եǰ� �ȴ�.
	@Autowired
	private MemService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@ModelAttribute("serverTime")
	// ModelAttribute()�ȿ� value���� �ۼ��ϸ�, � �޼��尡 ����Ǵ�����
	// �ش� ������̼��� �ִ� �޼���� ������ ����ȴ�.
	// ���� ����� jsp�� �� ����Ҽ� �ְ� �ȴ�.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

//	// ���� HttpServletRequest�� �̿��� ���
//	@RequestMapping(value = "/hi", method = RequestMethod.POST)
//	public String FirstRequest(Model model, HttpServletRequest request) {
//		// �޼����� �Ķ���Ϳ� HttpServletRequest��ü�� �����ؼ�, getParameter�� 
//		// ����ڰ� ���� name���� �޾ƿ��� ����̴�.
//		String name = request.getParameter("name");
//		String number = request.getParameter("number");
//		String age = request.getParameter("age");
//		String onePhone = request.getParameter("Phone1");
//		String twoPhone = request.getParameter("Phone2");
//		String threePhone = request.getParameter("Phone3");
//		
//		model.addAttribute("name", name);
//		model.addAttribute("number", number);
//		model.addAttribute("age", age);
//		model.addAttribute("myPhone",onePhone+" "+twoPhone+" "+threePhone);
//		
//		
//		return "hi";
//	}
//
//	// HttpServletRequest�� �̿����� �ʴ� ���
//	// @RequestParam ������̼��� Ȱ���ؼ� ����� ��û���� �޾ƿ��� ���
//	@RequestMapping(value = "/hi", method = RequestMethod.POST)
//	public String FirstRequest(Model model, 
//			@RequestParam(value = "name", required = true, defaultValue = "������") String name,
//			// ����ڰ� ��û�� name���� value�� �־��ְ� 
//			// �� value�� �޾Ƴ� ������ �ڿ� �������ָ� �ٷ� ���� �� �ִ�.
//			// value���� �Ѱ����, value�� �����ؼ� �ۼ��� �� �ִµ�
//			// required��� �Ӽ��� �ִ�.
//			// �ش� �Ӽ����� true��� ����ڷκ��� � ���� �Ѿ���� �ʴ´ٸ� ������ �߻���Ų��.
//			// �׷��� false��� � ���� �Ѿ���� �ʾƵ� ������ �߻���Ű�� �ʴ´�.
//			// true�ϰ�� � ���� �Ѿ���� ������, defaultValue �Ӽ����� default���� ������ �� �� �ִ�.
//			@RequestParam("number") String number,
//			@RequestParam("age") String age,
//			@RequestParam("Phone1") String onePhone,
//			@RequestParam("Phone2") String twoPhone,
//			@RequestParam("Phone3") String threePhone) {
//		
//
//		
//		// model�� Ư�� �����͸� �־ view�� ������ �����, 
//		// ���� HttpServletRequest�� �̿��� ����� �����ϴ�.
//		model.addAttribute("name", name);
//		model.addAttribute("number", number);
//		model.addAttribute("age", age);
//		model.addAttribute("myPhone",onePhone+" "+twoPhone+" "+threePhone);
//		
//		
//		return "hi";
//	}
//	
//	
//	// ���� ���̻��Ǵ� �������, Command ��ü�� ����ϴ� ����� �ִ�.
//	// ����ڿ��� �޾ƿ� ������ Getter/Setter�� ������� Ŭ������ �̿��ϴ� ���̴�.
//	// �ش� ����� view������ ����ϴ� ����� ���� �ٸ���.
//	// �ش� �������� �޾ƿ� ������ name, number, age, Phone1, Phone2, Phone3�� �ִµ�
//	// ��׸� getset���� class�� myInfo.class�̴�.
//	
//	// ������ ����� HttpServletRequest�� �̿����� �ʰ�
//	// �Ʊ� Getter/setter���� ��ü�� ������ش�.
//	@RequestMapping(value = "/hi", method = RequestMethod.POST)
//	public String FirstRequest(myInfo myinfo /* getset ��ü ���, �̶� Setter���� �۵��ϸ�
//	                                          ������� ���� �ȴ�.. */) {
//		
//		
//		// ���� �޾ƿ� �������� �ٸ� ��ü�� ���Խ�Ű�ų� �ϴ� Ȱ���� �ʿ��ϴٸ�,
//		// ������ getter setter�� ����ߴ� ���ó�� �׳� get�ؼ� ������� ����ϸ� ��.
//		myinfo.getName(); 
//		myinfo.getNumber();
//		myinfo.getAge();
//		myinfo.getPhone1();
//		myinfo.getPhone2();
//		myinfo.getPhone3();
//		
//		return "hi";
//		
//	}

	@RequestMapping(value = "/hi", method = RequestMethod.POST)
	public String FirstRequest(myInfo myinfo /* getset ��ü ���, �̶� Setter���� �۵��ϸ� ������� ���� �ȴ�.*/) {

		service.MemServiceInsert(myinfo.getNAME(), myinfo.getNUM(), myinfo.getAGE());
		return "hi";

	}

	@RequestMapping(value = "/myinfo", method = RequestMethod.GET)
	public String SecondRequest(Model model, myInfo myinfo) {
		
		// return���� myInfoDto�� ������, �޾ƿ� ���ϰ��� myinfoDto��ü�� ����
		myinfo = service.MemServiceSelect(myinfo.getNAME());
		// ������ ���� model�� Ȱ���ؼ� jsp�� ����
		model.addAttribute("selfNAME",myinfo.getNAME());
		model.addAttribute("selfNUM",myinfo.getNUM());
		model.addAttribute("selfAGE",myinfo.getAGE());
		return "AllInfo";
	}

	@RequestMapping(value = "/updateData", method = RequestMethod.POST)
	public ModelAndView ThirdRequest(myInfo myinfo) {
		
		
		myinfo = service.MemServiceUpdateNum(myinfo.getNUM(),myinfo.getNAME());
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("updateNAME",myinfo.getNAME());
		mav.addObject("updateNUM",myinfo.getNUM());
		mav.addObject("updateAGE",myinfo.getAGE());
		mav.setViewName("updateOk");
		
		return mav;
	}
	
	@RequestMapping(value = "/deleteData", method = RequestMethod.POST)
	public ModelAndView fourRequest(myInfo myinfo) {
		
		service.MemServiceDeleteNum(myinfo.getNAME());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("removeOK");
		
		return mav;
	}
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView fiveRequest(HttpSession session,myInfo myinfo) {
		
		// ���� ��ü�� �̸��� �й��� ���ϴ� ����� �ʿ��ϴ�
		myInfo myinfo2 = service.MemServiceSearch(myinfo.getNAME());
		
		(myInfo)session.getAttribute("info");
				
		
		return mav;
	}
	
}
