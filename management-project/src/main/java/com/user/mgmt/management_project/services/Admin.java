package com.user.mgmt.management_project.services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {

    public Admin(Long id, String firstName,  Long userID, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
	//	this.userStatus = userStatus;
		this.userID = userID;
		this.lastName = lastName;
		this.email = email;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="user_status")
    private String userStatus;
    
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


}
