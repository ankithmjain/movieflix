package com.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.model.User;
import com.movieflix.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {

		User existing = userRepository.findByEmail(user.getEmail());
		if (existing != null) {
			return null;
		}
		// Handle Exception
		return userRepository.create(user);
	}

	@Override
	public List<User> findAll() {

		List<User> users = userRepository.findAll();
		if (users == null) {
			return null;
		}
		return users;
	}

	@Override
	public User update(String id, User user) {
		User existing = userRepository.findById(id);
		if (existing == null) {
			return null;
		}

		return userRepository.update(user);
	}

	@Override
	public void delete(String id) {

		User existing = userRepository.findById(id);
		if (existing == null) {
			// Handle Exception
		}

		userRepository.delete(existing);

	}

	@Override
	public User findById(String id) {

		User user = userRepository.findById(id);
		if (user == null) {
			return null;
		}

		return user;
	}

}
