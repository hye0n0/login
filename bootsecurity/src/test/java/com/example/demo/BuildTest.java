package com.example.demo;

import org.junit.jupiter.api.Test;

public class BuildTest {
	
	@Test
	public void test() {
		MemberVO vo = MemberVO.builder().username("choi").build();
	}
}
