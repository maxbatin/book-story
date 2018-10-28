package com.demo.bookstrory.service;

import java.util.Set;

import com.demo.bookstrory.domain.User;
import com.demo.bookstrory.domain.security.UserRole;

public interface UserService {
	User createUser(User user, Set<UserRole> userRoles);

}
