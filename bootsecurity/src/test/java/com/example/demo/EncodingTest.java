package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingTest {

	@Test
	public void test() {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder(10);
		String pw = pe.encode("1234");
		System.out.println(pw);
		
		// 패스워드 파라미터 암호화 == DB 패스워드 직접 비교 안됨. matches 메서드 이용
		boolean result = pe.matches("1234", pw);
		System.out.println(result);
		
	}
}
