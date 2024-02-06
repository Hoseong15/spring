package com.example.gradleTest1.control;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gradleTest1.DTO.MemberDto;

@Controller
public class validationController {

	// 유효성 검사 2 - form 입력 양식 페이지
	@GetMapping("/valid2")
	public String input(Model model) {
		model.addAttribute("memberDto", new MemberDto() );
		return "signup";
	}
	
	@GetMapping("/submit")
	public String input(@Valid MemberDto memberDto, Model model, BindingResult bind) {
		String page = "signupResult";
		
		if(bind.hasErrors()) {
			page = "signup";
		}
		
		
		return page;
	}
}
