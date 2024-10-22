package com.accesscontrol.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accesscontrol.usermanagement.model.UserInfo;


public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{
	
	@Query(value = "select * from User_Info order by id asc limit 100", nativeQuery = true)
	public List<UserInfo> getAllUserInfo();


}
