package com.example.gradleTest1.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gradleTest1.DTO.ContentDTO;
import com.example.gradleTest1.DTO.ContentValidator;

@Controller
public class valController {

	@GetMapping("/inputForm")
	public String input(Model model) {
		model.addAttribute("contentDTO", new ContentDTO() );
		return "contentForm";
	}
	
	@GetMapping("/create")
	public String input(ContentDTO contentDTO, Model model, BindingResult result) {
		String page = "contentDone";
		
		ContentValidator validator = new ContentValidator();
		validator.validate(contentDTO, result);
		if(result.hasErrors()) { // writer 또는 content에 값을 입력하지않은경우 error값 있음
			page = "contentForm";
		}
		
		return page;
	}
	
	
}
