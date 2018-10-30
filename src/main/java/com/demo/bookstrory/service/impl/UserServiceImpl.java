package com.demo.bookstrory.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bookstrory.domain.User;
import com.demo.bookstrory.domain.security.UserRole;
import com.demo.bookstrory.repository.RoleRepository;
import com.demo.bookstrory.repository.UserRepository;
import com.demo.bookstrory.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOG 	= LoggerFactory.getLogger(UserService.class)	;
	@Autowired
	private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());	
		if (localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done", user.getUserName());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}

}
