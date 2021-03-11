package com.rayhan.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rayhan.blogger.controller.AuthResponse;


public interface AuthResponseRepository  extends JpaRepository<AuthResponse, Integer> {
	
	
	@Query(value="SELECT  user_id FROM login_activity WHERE login_activity.token=:s",nativeQuery = true)    
	int findUserId(String s);
	//int findUserId(@Param("id") int id);

}
