package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.config.JwtTokenUtil;
import com.test.model.BasicResponse;
import com.test.model.JwtResponse;
import com.test.model.LoginRequest;
import com.test.model.TokenValidationRequest;
import com.test.service.UserService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userDetailsService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> doLogin(@RequestBody LoginRequest authenticationRequest) throws Exception {
		if (userDetailsService.loadUserByUsername(authenticationRequest.getUsername()) == null) {
			return ResponseEntity.badRequest().body(new BasicResponse(false, "Username does not exist"));
		}
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails, authenticationRequest.getTime());

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "/verifytoken", method = RequestMethod.POST)
	public ResponseEntity<?> verifyToken(@RequestBody TokenValidationRequest tokenValidationRequest) throws Exception {
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(tokenValidationRequest.getUsername());
        
        if (userDetails != null) {
            try {
				System.out.println("token expire:");
				System.out.println(jwtTokenUtil.getExpirationDateFromToken(tokenValidationRequest.getToken()));
                if (jwtTokenUtil.validateToken(tokenValidationRequest.getToken(), userDetails)) {
                    return ResponseEntity.ok(new BasicResponse(true, "Valid"));
                }
            } catch (Exception e) {
                return ResponseEntity.ok(new BasicResponse(false, "Expired"));
            }
        }

		return ResponseEntity.ok(new BasicResponse(false, "Expired"));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}