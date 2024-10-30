package tr.edu.ogu.ceng.product.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import tr.edu.ogu.ceng.product.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService = new UserService();
   
	 	
	public UserService getUserService() {
		return userService;
	}
    
    // Buraya endpointler ekleyebilirsiniz
}