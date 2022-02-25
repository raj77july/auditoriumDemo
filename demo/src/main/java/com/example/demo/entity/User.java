package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.JoinColumn;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * public String getRole() { return role; } public void setRole(String role) {
	 * this.role = role; }
	 */
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", password="
				+ password + ", email=" + email + ", role=" + role + "]";
	}
	private String name;
	@Column(unique=true)
	private String mobileNumber;
	private String password;
	@Column(unique=true)
	private String email;
	//private String role;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> role;
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}

}


