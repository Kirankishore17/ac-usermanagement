package com.accesscontrol.usermanagement.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class UserInfo {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "phone")
	private String phone;
	@Column(name = "department")
	private String department;
	@Column(name = "role")
	private String role;
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@OneToOne
	@JoinColumn(name = "user_login_info_id")
	private UserLoginInfo userLoginInfo;
	
}
