package com.accesscontrol.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesscontrol.usermanagement.dao.UserInfoDao;
import com.accesscontrol.usermanagement.exception.ServiceException;
import com.accesscontrol.usermanagement.model.UserInfo;
import com.accesscontrol.usermanagement.model.UserLoginInfo;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	private String hashPassword(String password, String salt) throws ServiceException {
		if (password != null && salt != null)
		return String.join(password, salt);
		else
			throw new ServiceException("Password/salt cannot be null");
	}

	public String createUserInfo(UserInfo userInfo) throws ServiceException {
		UserLoginInfo loginInfo = new UserLoginInfo();
		if (userInfo.getUserLoginInfo() != null) {
			loginInfo.setPasswordHash(hashPassword(userInfo.getUserLoginInfo().getPasswordHash(), userInfo.getUserLoginInfo().getSalt()));
			return userInfoDao.saveUserInfo(userInfo);
		} else {
			throw new ServiceException("Password/salt cannot be null");
		}

	}

	public List<UserInfo> getAllUserInfo() throws ServiceException {
		return userInfoDao.getAllUserInfo();
	}
}
