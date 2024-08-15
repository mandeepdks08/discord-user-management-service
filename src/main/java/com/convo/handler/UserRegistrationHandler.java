package com.convo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.convo.datamodel.User;
import com.convo.repository.UserRepository;
import com.convo.restmodel.UserRegisterRequest;
import com.convo.util.RandomIdGenerator;

@Component
public class UserRegistrationHandler {

	@Autowired
	private UserRepository userRepo;

	public void register(UserRegisterRequest request) {
		validateRegistrationRequest(request);
		String userId = RandomIdGenerator.generateRandomId(10);
		System.out.println(userId);
		User user = User.builder().userId(userId).name(request.getName()).email(request.getEmail())
				.phone(request.getPhone()).build();
		userRepo.save(user);
	}

	private void validateRegistrationRequest(UserRegisterRequest request) {

	}

}