package com.movieflix.repository;

import java.util.List;

import com.movieflix.model.User;

public interface UserRepository {

	public User create(User user);

	public List<User> findAll();

	public User findById(String id);

	public User update(User user);

	public void delete(User id);

	public User findByEmail(String email);

}
