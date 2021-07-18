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

	// MemService객체를 new키워드로 생성하지 않아도, 해당 객체에 Service 어노테이션을 달아줫기 때문에, 객체가 자동으로 주입되게 된다.
	@Autowired
	private MemService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@ModelAttribute("serverTime")
	// ModelAttribute()안에 value값을 작성하면, 어떤 메서드가 실행되던간에
	// 해당 어노테이션이 있는 메서드는 무조건 실행된다.
	// 따라서 어디의 jsp던 다 사용할수 있게 된다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

//	// 기존 HttpServletRequest를 이용한 방법
//	@RequestMapping(value = "/hi", method = RequestMethod.POST)
//	public String FirstRequest(Model model, HttpServletRequest request) {
//		// 메서드의 파라미터에 HttpServletRequest객체를 선언해서, getParameter로 
//		// 사용자가 보낸 name값을 받아오는 방법이다.
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
//	// HttpServletRequest를 이용하지 않는 방법
//	// @RequestParam 어노테이션을 활용해서 사용자 요청값을 받아오는 방법
//	@RequestMapping(value = "/hi", method = RequestMethod.POST)
//	public String FirstRequest(Model model, 
//			@RequestParam(value = "name", required = true, defaultValue = "주진성") String name,
//			// 사용자가 요청한 name값을 value로 넣어주고 
//			// 그 value를 받아낼 변수를 뒤에 선언해주면 바로 받을 수 있다.
//			// value값이 한개라면, value를 생략해서 작성할 수 있는데
//			// required라는 속성이 있다.
//			// 해당 속성값이 true라면 사용자로부터 어떤 값이 넘어오지 않는다면 에러를 발생시킨다.
//			// 그러나 false라면 어떤 값이 넘어오지 않아도 에러를 발생시키지 않는다.
//			// true일경우 어떤 값이 넘어오지 않을때, defaultValue 속성으로 default값을 설정해 줄 수 있다.
//			@RequestParam("number") String number,
//			@RequestParam("age") String age,
//			@RequestParam("Phone1") String onePhone,
//			@RequestParam("Phone2") String twoPhone,
//			@RequestParam("Phone3") String threePhone) {
//		
//
//		
//		// model에 특정 데이터를 넣어서 view로 보내는 방법은, 
//		// 기존 HttpServletRequest를 이용한 방법과 동일하다.
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
//	// 가장 많이사용되는 방법으로, Command 객체를 사용하는 방법이 있다.
//	// 사용자에게 받아올 값들을 Getter/Setter를 만들어준 클래스를 이용하는 것이다.
//	// 해당 방법은 view에서도 사용하는 방법이 조금 다르다.
//	// 해당 예제에선 받아올 값들이 name, number, age, Phone1, Phone2, Phone3이 있는데
//	// 얘네를 getset해준 class는 myInfo.class이다.
//	
//	// 기존의 방법은 HttpServletRequest를 이용하지 않고
//	// 아까 Getter/setter해준 객체를 만들어준다.
//	@RequestMapping(value = "/hi", method = RequestMethod.POST)
//	public String FirstRequest(myInfo myinfo /* getset 객체 명시, 이때 Setter들이 작동하며
//	                                          변수들로 들어가게 된다.. */) {
//		
//		
//		// 만약 받아온 변수들을 다른 객체에 주입시키거나 하는 활동이 필요하다면,
//		// 기존에 getter setter를 사용했던 방법처럼 그냥 get해서 가지고와 사용하면 댐.
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
	public String FirstRequest(myInfo myinfo /* getset 객체 명시, 이때 Setter들이 작동하며 변수들로 들어가게 된다.*/) {

		service.MemServiceInsert(myinfo.getNAME(), myinfo.getNUM(), myinfo.getAGE());
		return "hi";

	}

	@RequestMapping(value = "/myinfo", method = RequestMethod.GET)
	public String SecondRequest(Model model, myInfo myinfo) {
		
		// return값이 myInfoDto기 때문에, 받아온 리턴값을 myinfoDto객체에 저장
		myinfo = service.MemServiceSelect(myinfo.getNAME());
		// 저장한 값을 model을 활용해서 jsp로 전송
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
		
		// 서비스 객체에 이름과 학번을 비교하는 기능이 필요하다
		myInfo myinfo2 = service.MemServiceSearch(myinfo.getNAME());
		
		(myInfo)session.getAttribute("info");
				
		
		return mav;
	}
	
}
