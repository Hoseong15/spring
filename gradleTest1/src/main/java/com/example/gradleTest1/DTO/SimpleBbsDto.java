package com.example.gradleTest1.DTO;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SimpleBbsDto {
	
	private int id;
	
	@NotBlank(message="작성자가 비어있습니다. 입력하세요")
	private String writer;
	
	@NotBlank(message="제목이 비어있습니다. 입력하세요")
	private String title;
	
	@NotBlank(message="내용이 비어있습니다. 입력하세요")
	private String content;
	
}
