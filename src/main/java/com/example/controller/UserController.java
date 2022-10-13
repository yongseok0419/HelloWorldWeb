package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.vo.UserVo;

@Controller
public class UserController {
	
	@RequestMapping("/test")
	public String main(Model model) {
		model.addAttribute("username","이용석");
		model.addAttribute("userage", "32");
		model.addAttribute("address","경기도 의정부시 범골로 137");
		return "main";	// /WEB-INF/views/" + main + ".jsp";
	}
	
	@RequestMapping(value = "/userinfo", method=RequestMethod.GET)
	public ModelAndView info() { //메서드이름은 전혀중요하지않음
		ModelAndView mav = new ModelAndView();
		mav.addObject("userid", "example");
		mav.addObject("passwd", "12345678");
		mav.setViewName("info");	// /WEB-INF/views/ + info + .jsp
		return mav;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String register(HttpServletRequest request, Model model) {
		model.addAttribute("userid", request.getParameter("userid"));	// key, 넘어온 userid
		model.addAttribute("passwd", request.getParameter("passwd"));
		model.addAttribute("username", request.getParameter("username"));
		model.addAttribute("userage", Integer.parseInt(request.getParameter("userage")));
		model.addAttribute("gender", request.getParameter("gender"));
		return "register";		// ViewResolver가 /WEB-INF/views/ + register + .jsp 를 붙쳐서 찾는다.
	}
	
	@RequestMapping(value = "/register1", method=RequestMethod.GET)
	public String register1(@RequestParam("userid") String userid,
									  @RequestParam("passwd") String passwd,
									  @RequestParam("username") String username,
									  @RequestParam("userage") int age,
									  @RequestParam("gender") String gender
			, Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("passwd", passwd);
		model.addAttribute("username", username);
		model.addAttribute("userage", age);
		model.addAttribute("gender", gender);
		return "register";		// ViewResolver가 /WEB-INF/views/ + register + .jsp 를 붙쳐서 찾는다.
	}
	
	@RequestMapping(value = "/register2", method=RequestMethod.GET)
	public String register2(@RequestParam("userid") String userid,
									  @RequestParam("passwd") String passwd,
									  @RequestParam("username") String username,
									  @RequestParam("userage") int age,
									  @RequestParam("gender") String gender
			, Model model) {
		UserVo user = new UserVo(userid, passwd, username, age, gender);
		model.addAttribute("myuser",user);
		return "register";		// ViewResolver가 /WEB-INF/views/ + register + .jsp 를 붙쳐서 찾는다.
	}
	
	@RequestMapping(value = "/register3", method=RequestMethod.GET)
	public String register3(UserVo user, Model model) {
		model.addAttribute("user", user);
		return "register";		// ViewResolver가 /WEB-INF/views/ + register + .jsp 를 붙쳐서 찾는다.
	}
	
	@RequestMapping(value = "/register4/{userid}/{passwd}/{username}/{userage}/{gender}", method=RequestMethod.GET)
	public String register4(
			@PathVariable String userid, @PathVariable String passwd,
			@PathVariable String username, @PathVariable String userage,
			@PathVariable String gender, Model model) {
		UserVo user = new UserVo(userid, passwd, username, Integer.parseInt(userage), gender);
		model.addAttribute("user", user);
		System.out.println(user.toString());
		return "register";		// ViewResolver가 /WEB-INF/views/ + register + .jsp 를 붙쳐서 찾는다.
	}
}
