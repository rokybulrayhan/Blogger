package com.rayhan.blogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.rayhan.blogger.entity.BloggerPost;
import com.rayhan.blogger.repository.AuthResponseRepository;
import com.rayhan.blogger.service.BloggerPostService;


@RestController
public class BloggerController {
	

	
	@Autowired
	private BloggerPostService bloggerPostService;
	
	@Autowired
	private AuthResponseRepository authResponseRepository;
	
	@PostMapping("user/addPost")
	public String saveEmployee(@RequestBody BloggerPost bloggerPost,@RequestHeader("Authorization") String token) {
		String s  = token.replace("Bearer ", "");
		int userId = authResponseRepository.findUserId(s);
		bloggerPost.setbUserId(userId);
		bloggerPost.setToken(s);
		bloggerPostService.saveBloggerPost(bloggerPost);
		return "admin approved first";
	}
	

}
