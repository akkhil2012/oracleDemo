package com.user.mgmt.management_project.utils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.user.mgmt.management_project.services.User;

@ComponentScan({"com.user.*"})
public class ApprovalInDoneState implements IUserState {

	@Autowired
	private User user;
	
	@Column(name="STATUS_TYPE")
    private String approved;
	
	public ApprovalInDoneState() {
		
	}
	
	public ApprovalInDoneState(User user) {
		this.user = user;
	}

	@Override
	public void onApproval(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSentForApproval(User user) {
		// TODO Auto-generated method stub
		
	}

	


	
}
