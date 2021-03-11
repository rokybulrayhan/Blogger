package com.rayhan.blogger.service;

import com.rayhan.blogger.entity.RoleEntity;
import com.rayhan.blogger.entity.UserEntity;
import com.rayhan.blogger.repository.RoleEntityRepository;
import com.rayhan.blogger.repository.UserEntityRepository;

import jdk.internal.org.jline.utils.Log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private RoleEntityRepository roleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity saveUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

	public List<UserEntity> getAllUser() {
		//System.out.println("Helllllllllllllllo");
		return userEntityRepository.findAll();
	}
	
	public void saveBlogger(UserEntity user) {
		this.userEntityRepository.save(user);
		
	}
	
	public UserEntity getUserId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteBloggerById(long id) {
		
		
	}
	/*
	 spring.datasource.url=jdbc:mysql://127.0.0.1:3306/spnew
spring.datasource.username=root
spring.datasource.password=
server.port = 8182


spring.jpa.show-sql=true
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
spring.jpa.hibernate.ddl-auto = update
	 */
}
