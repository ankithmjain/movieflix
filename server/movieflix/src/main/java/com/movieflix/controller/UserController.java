package com.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieflix.model.User;
import com.movieflix.service.UserService;

/**
 * The Class CustomerController.
 */
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class UserController {

	/** The customer service. */
	@Autowired
	private UserService userService;

	/**
	 * Creates the.
	 *
	 * @param user
	 *            the customer
	 * @return the customer
	 */
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public User create(@RequestBody User user) {

		return userService.create(user);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return userService.findAll();
	}

	// For multiple parameter like value="/{id}/{city}" you can write like
	// @PathVariable("id") String id, @PathVariable("city") String City

	/**
	 * Find by id.
	 *
	 * @param Id
	 *            the id
	 * @return the customer
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") String Id) {
		return userService.findById(Id);
	}

	/**
	 * Update.
	 *
	 * @param id
	 *            the id
	 * @param user
	 *            the customer
	 * @return the customer
	 */
	@RequestMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.PUT)
	public User update(@PathVariable("id") String id, @RequestBody User user) {

		return userService.update(id, user);
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		userService.delete(id);
	}

}
