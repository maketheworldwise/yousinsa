package com.flab.yousinsa.user.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flab.yousinsa.user.domain.dtos.request.SignUpRequestDto;
import com.flab.yousinsa.user.domain.dtos.response.SignUpResponseDto;
import com.flab.yousinsa.user.service.contract.UserSignUpService;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final UserSignUpService userService;

	public UserController(UserSignUpService userService) {
		this.userService = userService;
	}

	@PostMapping("api/v1/users")
	public ResponseEntity<SignUpResponseDto> signUpUser(@RequestBody SignUpRequestDto signUpRequest) {
		SignUpResponseDto signUpResponse = userService.trySignUpUser(signUpRequest);
		return ResponseEntity.ok(signUpResponse);
	}
}
