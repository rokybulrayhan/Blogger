package com.rayhan.blogger.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rayhan.blogger.entity.BloggerPost;

public interface BloggerPostRepository extends JpaRepository<BloggerPost, Long> {
	
	
	@Query(value="SELECT  id FROM login_activity WHERE login_activity.token=:s",nativeQuery = true)    
	int findUserId(String s);	

}
