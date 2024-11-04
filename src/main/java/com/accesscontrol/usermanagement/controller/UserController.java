package com.accesscontrol.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accesscontrol.usermanagement.exception.ServiceException;
import com.accesscontrol.usermanagement.model.UserInfo;
import com.accesscontrol.usermanagement.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*/*")
@Slf4j
public class UserController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping(path = "/home")
	public String HomeController() {
		log.info("Home/ping API called");
		return "Home Page";
	}

	@PostMapping(path = "/user")
	public ResponseEntity<String> createUserInfo(@RequestBody UserInfo userInfo) throws ServiceException, Exception {
		String message = userInfoService.createUserInfo(userInfo);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
		return new ResponseEntity<String>(message, headers, HttpStatus.CREATED);
	}

	@GetMapping(path = "/user/all")
	public ResponseEntity<List> getAllUserInfo() throws ServiceException, Exception {
		List<UserInfo> userInfoList = userInfoService.getAllUserInfo();
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
		return new ResponseEntity<List>(userInfoList, headers, HttpStatus.OK);
	}

}
