package com.demo.bookstrory.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.bookstrory.domain.security.Authority;
import com.demo.bookstrory.domain.security.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements 	UserDetails, Serializable{
   private static final long serialVersionUID = 893893L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="Id", nullable=false, updatable = false)
   private Long id;
   
   private String username;
   private String password;
   private String firstName;
   private String lastName;
   private String email;
   private String phone;
   private boolean enabled = true;
   
   @OneToMany(mappedBy =  "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
   @JsonIgnore
   private Set<UserRole> userRoles= new HashSet<>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUserName() {
	return username;
}

public void setUserName(String userName) {
	this.username = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public Set<UserRole> getUserRoles() {
	return userRoles;
}

public void setUserRoles(Set<UserRole> userRoles) {
	this.userRoles = userRoles;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	Set<GrantedAuthority> auth = new HashSet<>();
	userRoles.forEach(ur -> auth.add(new Authority(ur.getRole().getName())));
	return null;
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
    
   
   
   

}
