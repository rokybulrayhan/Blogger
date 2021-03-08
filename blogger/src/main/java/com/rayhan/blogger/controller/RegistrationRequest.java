package com.rayhan.blogger.controller;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationRequest {
	

	@NotEmpty
    @Column(unique = true)
    private String login;

	@NotEmpty
    private String password;
	
	@NotEmpty
    private String roleId;

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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public RegistrationRequest(@NotEmpty String login, @NotEmpty String password, @NotEmpty String roleId) {
		super();
		this.login = login;
		this.password = password;
		this.roleId = roleId;
	}
	public RegistrationRequest() {

	}
	

	 /* public String getLogin() {
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
		public RegistrationRequest() {
			
		}
		public RegistrationRequest(@NotEmpty String login, @NotEmpty String password) {
			super();
			this.login = login;
			this.password = password;
		}
		*/
}
