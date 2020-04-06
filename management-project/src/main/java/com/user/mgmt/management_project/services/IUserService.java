package com.user.mgmt.management_project.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface IUserService {
	  Optional<User> fetchUserById(final long id);
	  User editUsers(long id,User user);
	  void deleteUser(long id);
	  User addUser(@Valid User user);
}
