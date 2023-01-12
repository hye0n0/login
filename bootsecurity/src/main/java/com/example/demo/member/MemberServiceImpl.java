package com.example.demo.member;

import java.util.Arrays;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class MemberServiceImpl implements MemberService, UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username을 mapper단건조회
		//throws
		MemberVO vo = MemberVO.builder().userid("choi")
				.userpw("{bcrypt}$2a$04$q2lVd7PUoOlUh.nRcUZZwuMJ1/6FhHbIL.QQ0r8Ngd3EKtS61N4sS")
				.auth(Arrays.asList("USER","ADMIN"))
				.build();
		return vo;
	}

	@Override
	public MemberVO getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO updateMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO insertMember() {
		// TODO Auto-generated method stub
		return null;
	}


}
