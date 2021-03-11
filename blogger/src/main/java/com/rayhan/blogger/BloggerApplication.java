package com.rayhan.blogger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.rayhan.blogger.entity.RoleEntity;
import com.rayhan.blogger.repository.RoleEntityRepository;

@SpringBootApplication
public class BloggerApplication {
	
    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @PostConstruct
    public void initUsers() {
       List<RoleEntity> users = Stream.of(
                new RoleEntity(1, "ROLE_ADMIN"),
                new RoleEntity(2, "ROLE_USER")
              
        ).collect(Collectors.toList());
       roleEntityRepository.saveAll(users);
        
    }

    public static void main(String[] args) {
    	SpringApplication.run(BloggerApplication.class, args);
    }

}
