package com.accesscontrol.usermanagement.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	@Column(name = "salt", nullable = false)
	private String salt;
//	@Column(name = "password_updated_at", nullable = false)
//	@UpdateTimestamp
//	private LocalDateTime updatedAt;
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    UserLoginInfo that = (UserLoginInfo) obj;
	    return this.passwordHash.equals(that.getPasswordHash()) && this.salt.equals(that.getSalt());
	}

	@Override
	public int hashCode() {
	    return Objects.hash(this.passwordHash);
	}

}
