package com.rayhan.blogger.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column(unique = true)
    private String login;

    @Column
    private String password;
    
    @Column
    private int approval;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public UserEntity(Integer id, String login, String password, Integer approval, RoleEntity roleEntity) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.approval = approval;
		this.roleEntity = roleEntity;
	}

	public Integer getApproval() {
		return approval;
	}

	public void setApproval(Integer approval) {
		this.approval = approval;
	}

	public UserEntity() {
		
	}


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

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;
}
