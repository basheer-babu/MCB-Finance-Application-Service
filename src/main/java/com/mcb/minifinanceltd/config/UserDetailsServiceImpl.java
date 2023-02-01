package com.mcb.minifinanceltd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mcb.minifinanceltd.repository.MCBusers;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private MCBusers mcBusers;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return this.mcBusers.findByUsername(username);
	}

}
