package com.rayhan.blogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.rayhan.blogger.entity.BloggerPost;
import com.rayhan.blogger.entity.UserEntity;
import com.rayhan.blogger.repository.AuthResponseRepository;
import com.rayhan.blogger.service.BloggerPostService;


@RestController
public class BloggerController {
	

	
	@Autowired
	private BloggerPostService bloggerPostService;
	
	@Autowired
	private AuthResponseRepository authResponseRepository;
	
	
	
	
	@PostMapping("user/saveBloggerPost")
	public String saveEmployee(@RequestBody BloggerPost bloggerPost,@RequestHeader("Authorization") String token) {
		// save employee to database
		//System.out.println(token);
		String s  = token.replace("Bearer ", "");
		System.out.println(s);
		int userId = authResponseRepository.findUserId(s);
		System.out.println(userId);
		bloggerPost.setbUserId(userId);
		bloggerPost.setToken(s);
		bloggerPostService.saveBloggerPost(bloggerPost);
		return "Blogger Post su";
	}
	
	@GetMapping("user/authUser")
	public String get(@RequestBody BloggerPost bloggerPost) {
		// save employee to database
		/*System.out.println(userEntity.getId());*/
	//	authResponse.getId();
		bloggerPostService.saveBloggerPost(bloggerPost);
		return "Blogger Post su";
	}

}
