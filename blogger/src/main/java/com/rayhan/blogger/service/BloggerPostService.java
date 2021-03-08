package com.rayhan.blogger.service;

import java.util.List;

import com.rayhan.blogger.entity.BloggerPost;

public interface BloggerPostService {
	List<BloggerPost> getAllBloggerPost();
	List<BloggerPost> getCurrenyBloggerAllPost();
	void saveBloggerPost(BloggerPost bloggerPost);
	BloggerPost getBloggerPostId(long id);
	void deleteBloggerPostById(long id);

}
