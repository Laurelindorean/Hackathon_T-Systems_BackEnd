/**
 * 
 */
package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.IRoleDAO;
import com.dao.IUserDAO;
import com.dto.User;
import com.dto.auth.JwtResponse;
import com.dto.auth.LoginRequest;
import com.dto.auth.SignupRequest;
import com.security.jwt.JwtTokenProvider;
import com.security.service.UserDetailsImpl;

/**
 * @author Palmira
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthenticationManager authenticationManager;
	private IUserDAO userDAO;
	private IRoleDAO roleDAO;
	private PasswordEncoder encoder;
	private JwtTokenProvider jwtUtils;

	public AuthController(AuthenticationManager authenticationManager, IUserDAO userDAO, IRoleDAO roleDAO,
			PasswordEncoder encoder, JwtTokenProvider jwtUtils) {
		super();
		this.authenticationManager = authenticationManager;
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
		this.encoder = encoder;
		this.jwtUtils = jwtUtils;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		if (this.userDAO.findByUsername(signUpRequest.getUsername()) != null) {
			return ResponseEntity.badRequest().body("Error: Username is already taken!");
		}
		// Create new user's account
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(this.encoder.encode(signUpRequest.getPassword()));
		user.setRole(this.roleDAO.findByName("ROLE_user").orElseThrow(() -> new RuntimeException("Not found")));
		this.userDAO.save(user);
		return ResponseEntity.ok("User created!");
	}

}
