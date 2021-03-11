package com.rayhan.blogger.controller;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rayhan.blogger.entity.BloggerPost;

import lombok.Data;

@Entity
@Table(name = "login_activity")
public class AuthResponse {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    @Column
	private String token;
    @Column
	private Integer userId;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public AuthResponse(String token, Integer userId) {
		this.token = token;
		this.userId = userId;
	}
	public AuthResponse() {
		
	}
	

	

	
}
