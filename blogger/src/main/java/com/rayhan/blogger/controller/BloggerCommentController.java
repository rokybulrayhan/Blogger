package com.rayhan.blogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.rayhan.blogger.entity.BloggerPost;
import com.rayhan.blogger.repository.BloggerCommentRepository;

@RestController
public class BloggerCommentController {
	@Autowired
	private BloggerCommentRepository bloggerCommentRepository;
	
	@PostMapping("user/saveBloggerComment")
	public String saveEmployee(@RequestBody BloggerController bloggerController,@RequestHeader("Authorization") String token) {
	/*	String s  = token.replace("Bearer ", "");
		System.out.println(s);
		int userId = authResponseRepository.findUserId(s);
		System.out.println(userId);
		bloggerPost.setbUserId(userId);
		bloggerPost.setToken(s);
		bloggerPostService.saveBloggerPost(bloggerPost);
		*/
		return "Blogger Post su";
	}

}
