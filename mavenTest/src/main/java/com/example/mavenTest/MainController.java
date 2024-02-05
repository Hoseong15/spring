package com.example.mavenTest;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mavenTest.DTO.memberDTO;
import com.example.mavenTest.service.MemberService;

@Controller
public class MainController {
	private final MemberService memberService;
	
	public MainController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("prt","member");
		
		return mv;
	}
	
	@GetMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("signup");
		return mv;
	}
	
	@GetMapping("/signin")
	public ModelAndView signin() {
		ModelAndView mv = new ModelAndView("signin");
		return mv;
	}
	
	@PostMapping("/signin")
	public ModelAndView signin( @RequestParam Map<String, String> param , HttpSession session ) {
		
		ModelAndView mv = new ModelAndView("index");
		System.out.println(param.get("email"));
		String name = memberService.login(param);
		//mv.addObject("user", name);
		
		if(name != null) {
			session.setAttribute("user", name);
		}else {
			mv.setViewName("signin");
			mv.addObject("fail", "a");
		}
			
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView update() {
		ModelAndView mv = new ModelAndView("update");
		return mv;
	}
	@PostMapping("/update")
	public ModelAndView update(@RequestParam Map<String, String> pm) {
		ModelAndView mv = new ModelAndView("signin");
		memberService.update(pm);
		return mv;
	}
	
	@PostMapping("/signup/Enroll")
	public ModelAndView signEnroll( @ModelAttribute memberDTO memberdto ) {
		ModelAndView mv = new ModelAndView("index");
		System.out.println(memberdto.getEmail());
		memberService.insert(memberdto);
		return mv;
	}
	
//	public ModelAndView signEnroll(
//			@RequestParam("email") String email,
//			@RequestParam("pin") String pw,
//			@RequestParam("name") String name,
//			@RequestParam("tel") String tel ) {
//		
//		ModelAndView mv = new ModelAndView("index");
//		System.out.println(email);
//		
//		return mv;
//	}
	
}
