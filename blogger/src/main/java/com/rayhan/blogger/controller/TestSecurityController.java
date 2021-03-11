package com.rayhan.blogger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.rayhan.blogger.entity.BloggerPost;
import com.rayhan.blogger.entity.RoleEntity;
import com.rayhan.blogger.entity.UserEntity;
import com.rayhan.blogger.repository.BloggerPostRepository;
import com.rayhan.blogger.repository.RoleEntityRepository;
import com.rayhan.blogger.repository.UserEntityRepository;
import com.rayhan.blogger.service.UserService;

@RestController
public class TestSecurityController {
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleEntityRepository roleEntityRepository;
	
	@Autowired
	private BloggerPostRepository bloggerPostRepository;

    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("/user/get")
    public String getUser() {
        return "Hi user";
    }
    @PostMapping("/admin/addNewAdmin")
    public String adminAdd(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        RoleEntity userRole = roleEntityRepository.findByName("ROLE_ADMIN");
        u.setRoleEntity(userRole);   	
        userService.saveUser(u);      
        return "New Admin Added";
    }
    @PutMapping("/admin/userApproval")
    public UserEntity userApproval(@RequestBody UserEntity user) {
    	UserEntity udateApproval = new UserEntity();
        Optional<UserEntity> u ;
    	u = userEntityRepository.findById(user.getId()); 
    	udateApproval.setId(user.getId());
    	udateApproval.setLogin(u.get().getLogin());
    	udateApproval.setPassword(u.get().getPassword());
    	udateApproval.setApproval(user.getApproval());
    	udateApproval.setRoleEntity(u.get().getRoleEntity());

    	//System.out.println(u.get().getLogin());
		return userEntityRepository.save(udateApproval);
	}
   
    @GetMapping("/listAllBlogger")
	public List<UserEntity> personalDetails(){
		return userService.getAllUser();
	}
    @GetMapping("admin/findBloggerById/{id}")
	public  Optional<UserEntity> findAllOrder(@PathVariable(value = "id") int id) {
		return userEntityRepository.findById(id);
	}
    //_____________________//
 
	@GetMapping("/user/viewallApprovalPosts")
    public List<BloggerPost> getAllPost(){
    	int i;
    	List<BloggerPost> userViewPost = new ArrayList<>() ;
    	for(i=0;i<bloggerPostRepository.findAll().size();i++) {
    		if(bloggerPostRepository.findAll().get(i).getApprovalPost()==1) {
    			userViewPost.add(bloggerPostRepository.findAll().get(i));
    		}
    	} 
    	
		return userViewPost;
	}
	 @PutMapping("/admin/userPostApproval")
	    public BloggerPost userPostApproval(@RequestBody BloggerPost bloggerPost) {
		    BloggerPost bloggerPostApproval = new BloggerPost();
	        Optional<BloggerPost> b ;
	    	b = bloggerPostRepository.findById(bloggerPost.getId()); 
	    	bloggerPostApproval.setId(bloggerPost.getId());
	    	bloggerPostApproval.setApprovalPost(bloggerPost.getApprovalPost());
	    	bloggerPostApproval.setBlogComment(b.get().getBlogComment());
	    	bloggerPostApproval.setbUserId(b.get().getbUserId());
	    	bloggerPostApproval.setToken(b.get().getToken());
	    	bloggerPostApproval.setBloggerPost(b.get().getBloggerPost());
	    	
			return bloggerPostRepository.save(bloggerPostApproval);
	}
   /* @GetMapping("/singlePost/{id}")
    public Optional<BloggerPost> getUserPost(@PathVariable(value = "id") int id){
    	System.out.println(id); 
		return bloggerPostRepository.findById(id);
	}
	*/
    
    @DeleteMapping("admin/deletePost/{id}")
	public  void adminPostDelete(@PathVariable(value = "id") int id) {
   		 bloggerPostRepository.deleteById((long) id);
   	    	
   	}
    @DeleteMapping("user/deleteOwnPost/{id}")
	public  void userDeleteOwnPost (@PathVariable(value = "id") int id, @RequestHeader("Authorization") String token) {
    	String s  = token.replace("Bearer ", "");
    	String y = bloggerPostRepository.findById((long) id).get().getToken();
    	//System.out.println(s.length()); 
    	//System.out.println(y.length()); 
    	if(y==s) {
    		//System.out.println("hhhhhhhhhhhhhhhhhhhhh");
    		 bloggerPostRepository.deleteById((long) id);
    	}
   		
   	    	
   	}
   	
    
   
    
}
