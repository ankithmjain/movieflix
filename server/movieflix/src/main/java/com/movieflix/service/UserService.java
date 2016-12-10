package com.movieflix.service;

import java.util.List;

import com.movieflix.model.User;

public interface UserService {

	public User create(User user);

	public List<User> findAll();

	public User findById(String id);

	public User update(String id, User user);

	public void delete(String productId);

}
