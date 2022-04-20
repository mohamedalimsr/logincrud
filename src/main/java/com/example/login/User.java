package com.example.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(nullable = false, unique = true, length = 45)
private String email;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Column(nullable = false, length = 64)
private String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Column(name = "first_name", nullable = false, length = 20)
private String firstName;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
@Column(name = "last_name", nullable = false, length = 20)
private String lastName ;
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}}
