package com.accesscontrol.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesscontrol.usermanagement.dao.UserInfoDao;
import com.accesscontrol.usermanagement.exception.ServiceException;
import com.accesscontrol.usermanagement.model.UserInfo;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	public String addUserInfoService(UserInfo userInfo) throws ServiceException {
		return userInfoDao.saveUserInfo(userInfo);
	}
}
