package com.greatlearning.collegefest.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.collegefest.entity.User;
import com.greatlearning.collegefest.repository.UserRepository;
import com.greatlearning.collegefest.security.MyUserDetails;

public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return new MyUserDetails(user);
	}

}
