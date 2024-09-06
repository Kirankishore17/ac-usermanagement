package com.accesscontrol.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesscontrol.usermanagement.model.UserInfo;


public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{

}
