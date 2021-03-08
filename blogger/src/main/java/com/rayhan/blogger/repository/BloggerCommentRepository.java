package com.rayhan.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayhan.blogger.entity.BloggerComment;

public interface BloggerCommentRepository  extends JpaRepository<BloggerComment, Integer>  {

}
