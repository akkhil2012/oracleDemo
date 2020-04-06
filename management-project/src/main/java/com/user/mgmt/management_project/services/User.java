package com.user.mgmt.management_project.services;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.beans.factory.annotation.Autowired;

import com.user.mgmt.management_project.utils.ApprovalInProcessState;
import com.user.mgmt.management_project.utils.IUserState;

import javax.persistence.Column;

import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	/*@Autowired
	private IUserState userState;*/
	
	
	public int getVersion() {
		return version;
	}




	public void setVersion(int version) {
		this.version = version;
	}


	private int version;
	
	public User() {
		//userState = new ApprovalInProcessState(this);
	  }
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    
    
    
    
    
    public long getUserID() {
		return userID;
	}




	public void setUserID(long userID) {
		this.userID = userID;
	}

	/*
	 * Use static method to avoid calling constructor with too many parametrer
	 */

	static User createUserWithAllParameters(User updateUser) {
		return new User(updateUser.getId(),updateUser.getFirstName(),updateUser.getUserID(),updateUser.getLastName(),
				updateUser.getEmail());
	}


	public User(Long id, String firstName, long userID, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.userID = userID;
		this.lastName = lastName;
		this.email = email;
		//this.userState = new ApprovalInProcessState(this); // instantiate User with default State
	}




	/*public IUserState getUserState() {
		return userState;
	}




	public void setUserState(IUserState userState) {
		this.userState = userState;
	}*/


	@Column(name="user_id")
    private long userID;

	@Column(name="last_name")
    private String lastName;
    
    @Column(name="email", nullable=false, length=200)
    private String email;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email   + "]";
    }
}


