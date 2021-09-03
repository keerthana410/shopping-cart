package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entities.User;
import com.shopping.exception.BadRequestException;
import com.shopping.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			throw new BadRequestException();
		}
		User addUser = loginService.addUser(user);
		return ResponseEntity.ok("User successfully registered with id : " + addUser.getUserId());
	}

	@DeleteMapping("/unregister")
	public ResponseEntity<String> removeUser(@RequestBody User user) {
		User removeUser = loginService.removeUser(user);
		return ResponseEntity.ok("User succesfully removed with id : " + removeUser.getUserId());
	}

	@PutMapping("/login")
	public ResponseEntity<String> validateUser(@RequestBody User user, BindingResult result) {
		if (result.hasErrors())
			throw new BadRequestException();
		loginService.validateUser(user);
		return ResponseEntity.ok("User succesfully logged In");
	}

	@PutMapping("/logout")
	public ResponseEntity<String> logOut(@RequestBody User user, BindingResult result) {
		if (result.hasErrors())
			throw new BadRequestException();
		loginService.logOut(user);
		return ResponseEntity.ok("User succesfully logged Out");
	}

}
