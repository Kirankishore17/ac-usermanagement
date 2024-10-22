package com.accesscontrol.usermanagement.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * This data model is used to store User's password and related info. 
 * @see UserInfo
 */
@Data
@Table
@Entity
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
