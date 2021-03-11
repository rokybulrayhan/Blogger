/*package com.rayhan.blogger.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rayhan.blogger.entity.RoleEntity;
import com.rayhan.blogger.entity.UserEntity;
import com.rayhan.blogger.repository.RoleEntityRepository;
import com.rayhan.blogger.repository.UserEntityRepository;
import com.rayhan.blogger.service.UserService;

public class AdminController2 {
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleEntityRepository roleEntityRepository;
	
	@GetMapping("/register/listAllBlogger")
	public List<UserEntity> personalDetails(){
		return userService.getAllUser();
	}
	
	@PostMapping("/saveBlogger")
	public String saveEmployee(@RequestBody UserEntity user) {
		userService.saveBlogger(user);
		return "redirect:/";
	}
	@PostMapping("/admin/addNewAdminoo")
    public String adminAdd(@RequestBody @Valid RegistrationRequest registrationRequest) {
		System.out.println("KKKKKKKKKKKK");
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        RoleEntity userRole = roleEntityRepository.findByName("ROLE_ADMIN");
        u.setRoleEntity(userRole);   	
        userService.saveUser(u);      
        return "New Admin Added";
    }
	
	@GetMapping("/findBloggerByIduu/{id}")
	public  Optional<UserEntity> findAllOrder(@PathVariable(value = "id") int id) {
		return userEntityRepository.findById(id);
	}
	

	@DeleteMapping("/deleteBlogger/{id}")
	public void delete(@PathVariable(value = "id") int id) {
		userEntityRepository.deleteById(id);
	}

}
*/
