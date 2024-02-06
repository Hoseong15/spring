package com.example.gradleTest1.DTO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		// 검증 할 객체의 클래스확인
		return ContentDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ContentDTO dto = (ContentDTO)target;
		
		String writer = dto.getWriter();
		if(writer == null || writer.trim().isEmpty()) {
			errors.rejectValue("writer", "No input", "작성자 입력하세요");
		}
		String content = dto.getContent();
		if(content == null || content.trim().isEmpty()) {
			errors.rejectValue("content", "No input Content","내용을 입력하세요");
		}
			
		
	}

	
	
	
}
