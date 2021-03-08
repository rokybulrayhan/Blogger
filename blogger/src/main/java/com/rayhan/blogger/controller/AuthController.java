package com.rayhan.blogger.controller;

import com.rayhan.blogger.config.jwt.JwtProvider;
import com.rayhan.blogger.entity.RoleEntity;
import com.rayhan.blogger.entity.UserEntity;
import com.rayhan.blogger.repository.AuthResponseRepository;
import com.rayhan.blogger.repository.RoleEntityRepository;
import com.rayhan.blogger.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private RoleEntityRepository roleEntityRepository;
    
    @Autowired
    private AuthResponseRepository authResponseRepository;
   

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
    	//System.out.println(registrationRequest);
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        String s = registrationRequest.getRoleId();
        int x = Integer.valueOf(s);
      
        if(  x==1) {
            	System.out.println(registrationRequest.getRoleId());
        	 RoleEntity userRole = roleEntityRepository.findByName("ROLE_ADMIN");
             u.setRoleEntity(userRole);   	
        }
        else if(x== 2) {
        	System.out.println(registrationRequest.getRoleId());
       	    RoleEntity userRole = roleEntityRepository.findByName("ROLE_USER");
            u.setRoleEntity(userRole);   	
         }
       
        userService.saveUser(u);
       
        return "OK";
    }

    @PostMapping("/auth")
    public String auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        System.out.println(userEntity.getId());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        //return new AuthResponse(token);
        AuthResponse Ap= new AuthResponse(token, userEntity.getId());
        authResponseRepository.save(Ap);
        return "["+Ap.getToken()+"]";
    }
    @GetMapping("/home")
	public String Home() {
		return "my name is";
	}
}
