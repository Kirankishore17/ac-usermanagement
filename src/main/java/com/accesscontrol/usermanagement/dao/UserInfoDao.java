package com.accesscontrol.usermanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accesscontrol.usermanagement.exception.ServiceException;
import com.accesscontrol.usermanagement.model.UserInfo;
import com.accesscontrol.usermanagement.repository.UserInfoRepo;

@Repository(value = "UserInfoRepo")
public class UserInfoDao {

	@Autowired
	private UserInfoRepo userInfoRepo;

	public String saveUserInfo(UserInfo userInfo) throws ServiceException {
		try {
			userInfoRepo.save(userInfo);
			return "New User Info successfully added";
		} catch (Exception e) {
			throw new ServiceException(e.getMessage().substring(0, e.getMessage().length() > 150?150:e.getMessage().length()));
		}
	}

	public List<UserInfo> getAllUserInfo() throws ServiceException {
		try {
			return userInfoRepo.findAll();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage().substring(0, e.getMessage().length() > 150?150:e.getMessage().length()));
		}
	}

}
