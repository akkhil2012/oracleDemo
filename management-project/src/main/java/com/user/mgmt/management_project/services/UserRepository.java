package com.user.mgmt.management_project.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	@Transactional(timeout = 8)
	 List<User> findAll();
	
}