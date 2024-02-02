package com.example.mavenTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mavenTest.DAO.MemberDAO;
import com.example.mavenTest.DTO.memberDTO;

@Service
public class MemberService {

	private final MemberDAO memberdao;
	
	@Autowired 
	public MemberService(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	// 회원가입 저장 메세드
	public void insert(memberDTO memberdto) {
		memberdao.insert(memberdto);
	}
	
}
