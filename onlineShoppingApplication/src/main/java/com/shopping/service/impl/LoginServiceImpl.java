package com.shopping.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entities.User;
import com.shopping.exception.RecordNotFoundException;
import com.shopping.exception.UserAlreadyExistsException;
import com.shopping.exception.WrongCredentialsException;
import com.shopping.repository.LoginRepository;
import com.shopping.repository.UserRepository;
import com.shopping.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;
	UserRepository userRepository;

	private static String getErrorMessage(int userId) {
		return "User with id : " + userId + " not found";
	}

	@Override
	public User addUser(User user) {

		if (Boolean.TRUE.equals(userRepository.existsByUserName(user.getUserName()))) {
			throw new UserAlreadyExistsException("User with username : " + user.getUserName() + " already exists");
		}
		return userRepository.save(user);
	}

	@Override
	public User removeUser(User user) {
		if (!userRepository.findById(user.getUserId()).isPresent()) {
			throw new RecordNotFoundException(getErrorMessage(user.getUserId()));
		}
		userRepository.deleteById(user.getUserId());
		return user;
	}

	@Override
	public User validateUser(User user) {
		User validatedUser=loginRepository.validateUser(user.getUserName(),user.getPassword(),user.getRole());
		if(validatedUser == null) {
			throw new WrongCredentialsException();
		}
		else {
			validatedUser.setIsLoggedIn(true);
			userRepository.save(validatedUser);
			return validatedUser;
		}
		
	}

	@Override
	public User logOut(User user) {
		Optional<User> userDb = userRepository.findByUserName(user.getUserName());
		if (!userDb.isPresent()) {
			throw new RecordNotFoundException(getErrorMessage(user.getUserId()));
		}
		userDb.get().setIsLoggedIn(false);
		userRepository.save(userDb.get());
		return userDb.get();
	}

}