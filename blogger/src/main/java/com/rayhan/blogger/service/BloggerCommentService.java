package com.rayhan.blogger.service;

import java.util.List;

import com.rayhan.blogger.entity.BloggerComment;

public interface BloggerCommentService {
	List<BloggerComment> getAllBloggerComment();
	//List<BloggerComment> getCurrenyBloggerAll();
	void saveBloggerComment(BloggerComment bloggerComment);
	BloggerComment getBloggerCommentId(long id);
	void deleteBloggerCommentById(long id);

}
