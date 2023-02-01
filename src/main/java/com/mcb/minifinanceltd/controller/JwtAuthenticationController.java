package com.mcb.minifinanceltd.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.minifinanceltd.config.JwtTokenUtil;
import com.mcb.minifinanceltd.entity.JwtRequest;
import com.mcb.minifinanceltd.entity.JwtResponse;
import com.mcb.minifinanceltd.entity.Users;
import com.mcb.minifinanceltd.repository.MCBusers;

import io.jsonwebtoken.JwtException;

@RestController
@RequestMapping("/api/v1/auth")
//@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MCBusers busers;

//	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@PostMapping("/authenticate")
	public  ResponseEntity<Map<String, Object>> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws JwtException {

		//System.out.println(this.SaveUser());
		//System.out.println(">>>>>>>>>>> Controller <<<<<<<<<<<<<<"+authenticationRequest.toString());

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = this.jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = this.jwtTokenUtil.generateToken(userDetails);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("token", token);
		map.put("userRole", userDetails.getAuthorities());
		
		
		
		return ResponseEntity.ok(map);
	}

	private void authenticate(String username, String password) throws BadCredentialsException {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new UsernameNotFoundException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", e);
		}
	}


	@PostMapping("/create-user")
	public String SaveUser() {
		
		Users users = new Users(101, "user", this.passwordEncoder.encode("user"), "ROLE_NORMAL");
		Users users1 = new Users(102, "admin", this.passwordEncoder.encode("admin"), "ROLE_ADMIN");
		busers.save(users);
		busers.save(users1);
		return "saved";
	}
	
	
}
