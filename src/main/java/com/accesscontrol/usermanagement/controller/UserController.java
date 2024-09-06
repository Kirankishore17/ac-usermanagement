package com.accesscontrol.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accesscontrol.usermanagement.exception.ServiceException;
import com.accesscontrol.usermanagement.model.UserInfo;
import com.accesscontrol.usermanagement.service.UserInfoService;

@RestController
public class UserController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping(path = "/home")
	public String HomeController() {
		return "Home Page";
	}

	@PostMapping(path = "/user")
	public ResponseEntity<String> addUserInfoController(@RequestBody UserInfo userInfo) throws ServiceException {
		String message = userInfoService.addUserInfoService(userInfo);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
		return new ResponseEntity<String>(message, headers, HttpStatus.CREATED);
	}
 
}
