package com.rayhan.blogger.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "blogger_all_post")
public class BloggerPost {

	@Id 
	@GeneratedValue
	private Long id;
	
	@Column(name="blogger_post" ,nullable=false)
	private String bloggerPost;
	private int bUserId;
	private String token;

	
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBloggerPost() {
		return bloggerPost;
	}

	public void setBloggerPost(String bloggerPost) {
		this.bloggerPost = bloggerPost;
	}

	public int getbUserId() {
		return bUserId;
	}

	public void setbUserId(int bUserId) {
		this.bUserId = bUserId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<BloggerComment> getBlogComment() {
		return blogComment;
	}

	public void setBlogComment(List<BloggerComment> blogComment) {
		this.blogComment = blogComment;
	}
	



	public BloggerPost(Long id, String bloggerPost, int bUserId, String token, List<BloggerComment> blogComment) {
		super();
		this.id = id;
		this.bloggerPost = bloggerPost;
		this.bUserId = bUserId;
		this.token = token;
		this.blogComment = blogComment;
	}
	public BloggerPost() {
		
	}


	@OneToMany(targetEntity = BloggerComment.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="post_fk",referencedColumnName = "id")
    private List<BloggerComment> blogComment;
    
    
	

}
