package com.rayhan.blogger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayhan.blogger.entity.BloggerComment;
import com.rayhan.blogger.repository.BloggerCommentRepository;

@Service
public class BloggerCommentServiceImpl implements BloggerCommentService{
	@Autowired
	private BloggerCommentRepository bloggerCommentRepository;

	@Override
	public List<BloggerComment> getAllBloggerComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBloggerComment(BloggerComment bloggerComment) {
		bloggerCommentRepository.save(bloggerComment);
		
	}

	@Override
	public BloggerComment getBloggerCommentId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBloggerCommentById(long id) {
		// TODO Auto-generated method stub
		
	}

	
}
