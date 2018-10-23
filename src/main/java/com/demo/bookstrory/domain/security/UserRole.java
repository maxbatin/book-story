package com.demo.bookstrory.domain.security;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole implements Serializable{
	private static final long serialVersionUID = 4984984L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRoleId;
	
	public UserRole() {
		
	}
	public UserRole (User user, Role role) {
		this.user = user;
		this.role = role;
	}
	@ManyToOne (fetch = FetchType.EAGER)
	private User user;
	private Role role;
	

}
