package com.rayhan.blogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rayhan.blogger.entity.BloggerComment;
import com.rayhan.blogger.repository.BloggerCommentRepository;
import com.rayhan.blogger.service.BloggerCommentService;

@RestController
public class BloggerCommentController {
	@Autowired
	private BloggerCommentRepository bloggerCommentRepository;
	
	@Autowired
	private BloggerCommentService  bloggerCommentService;
	
	@PostMapping("user/comment/{id}")
	public String saveBloggerComment(@PathVariable(name="id") int id,@RequestBody BloggerComment bloggerComment,@RequestHeader("Authorization") String token) {
		String s  = token.replace("Bearer ", "");
		System.out.println(id);
		bloggerComment.setBloggerPostId(id);
		bloggerComment.setToken(s);
		System.out.println(bloggerComment);
		bloggerCommentService.saveBloggerComment(bloggerComment);		
		return "Blogger comment";
	}
	

}
