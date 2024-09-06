package com.accesscontrol.usermanagement.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserLoginInfo {
	
	@Id
	private Integer id;
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	@Column(name = "salt", nullable = false)
	private String salt;
	@Column(name = "password_updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	

}
