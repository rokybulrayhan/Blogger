package com.rayhan.blogger.controller;



public class AuthRequest {
    public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String login;
    public AuthRequest(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
    public AuthRequest() {
		
	}
	private String password;
}
