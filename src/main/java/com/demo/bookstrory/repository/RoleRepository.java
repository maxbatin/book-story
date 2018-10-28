package com.demo.bookstrory.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.bookstrory.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	

}
