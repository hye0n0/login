package com.example.demo.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO implements UserDetails{
	private String userid;
	private String userpw;
	private String tel;
	private String addr;
	List<String> auth;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		for(String at : auth) {
			list.add(new SimpleGrantedAuthority(at));
		}
		return list;
//		return auth.stream()addr.map(auth-> new SimpleGrantedAuthority(auth)).collect(Collector.toList());
	}
	@Override
	public String getPassword() {

		return userpw;
	}
	@Override
	public String getUsername() {

		return userid;
	}
	@Override
	public boolean isAccountNonExpired() {

		return true;
	}
	@Override
	public boolean isAccountNonLocked() {

		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	@Override
	public boolean isEnabled() {
		
		return true;
	}
}
