package com.user.mgmt.management_project.utils;

import java.io.Serializable;

import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.user.mgmt.management_project.services.User;

@Component
public interface IUserState {

	
	public void onApproval(User user);
	

	public void onSentForApproval(User user);

	
	
}
