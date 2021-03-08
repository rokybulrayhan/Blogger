package com.rayhan.blogger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blogger_all_activity")
public class BloggerComment {
	@Id 
	@GeneratedValue
	private Long id;	
	@Column(name="blogger_comment" ,nullable=false)
	private String bloggerComment;
	private int bloggerUserId;
	private int bloggerPostId;
	private String token;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBloggerComment() {
		return bloggerComment;
	}
	public void setBloggerComment(String bloggerComment) {
		this.bloggerComment = bloggerComment;
	}
	public int getBloggerUserId() {
		return bloggerUserId;
	}
	public void setBloggerUserId(int bloggerUserId) {
		this.bloggerUserId = bloggerUserId;
	}
	public int getBloggerPostId() {
		return bloggerPostId;
	}
	public void setBloggerPostId(int bloggerPostId) {
		this.bloggerPostId = bloggerPostId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public BloggerComment(Long id, String bloggerComment, int bloggerUserId, int bloggerPostId, String token) {
		super();
		this.id = id;
		this.bloggerComment = bloggerComment;
		this.bloggerUserId = bloggerUserId;
		this.bloggerPostId = bloggerPostId;
		this.token = token;
	}
	public BloggerComment() {
		
	}
	

}
