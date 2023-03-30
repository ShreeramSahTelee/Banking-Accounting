package com.axis.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.axis.models.ERole;
import com.axis.models.Role;
import com.axis.models.User;
import com.axis.payload.request.LoginRequest;
import com.axis.payload.request.SignupRequest;
import com.axis.payload.response.JwtResponse;
import com.axis.payload.response.MessageResponse;
import com.axis.repository.RoleRepository;
import com.axis.repository.UserRepository;
import com.axis.security.jwt.JwtUtils;
import com.axis.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository customerRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getCustomerId(), loginRequest.getCustomerPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    
	return ResponseEntity.ok(new JwtResponse(jwt,
			            	userDetails.getCustomerId(),
		                    userDetails.getUsername(),
		                  	userDetails.getCustomerEmail(),
		                  	roles));

  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (customerRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (customerRepository.existsByEmail(signUpRequest.getCustomerEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }
    
    User user = new User();
    
    user.setUsername(signUpRequest.getUsername());
    user.setCustomerEmail(signUpRequest.getCustomerEmail());
    user.setCustomerPassword(encoder.encode(signUpRequest.getCustomerPassword()));
    user.setAccountNumber(generateAccountNumber());
    user.setBalance(100);
    
    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
    
    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    }
    user.setRoles(roles);
    customerRepository.save(user);
    
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

private String generateAccountNumber() {
		  
	    Random random = new Random();
	    StringBuilder accountNumber = new StringBuilder();
	    for (int i = 0; i < 12; i++) {
	        accountNumber.append(random.nextInt(10));
	    }
	    return accountNumber.toString();
	}
}
