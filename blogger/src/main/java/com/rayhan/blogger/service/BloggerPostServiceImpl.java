package com.rayhan.blogger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayhan.blogger.entity.BloggerPost;
import com.rayhan.blogger.repository.BloggerPostRepository;


@Service
public class BloggerPostServiceImpl implements BloggerPostService {
	
	@Autowired
	BloggerPostRepository bloggerPostRepository;

	@Override
	public List<BloggerPost> getAllBloggerPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BloggerPost> getCurrenyBloggerAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBloggerPost(BloggerPost bloggerPost) {
		
		bloggerPostRepository.save(bloggerPost);
	}

	@Override
	public BloggerPost getBloggerPostId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBloggerPostById(long id) {
		// TODO Auto-generated method stub
		
	}



}
