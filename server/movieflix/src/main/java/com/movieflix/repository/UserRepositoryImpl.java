package com.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movieflix.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User create(User user) {

		em.persist(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> users = em.createNamedQuery("User.findAll", User.class);

		return users.getResultList();
	}

	@Override
	public User findById(String id) {
		User user = em.find(User.class, id);

		return user;
	}

	@Override
	public User update(User user) {

		em.merge(user);
		return user;
	}

	@Override
	public void delete(User user) {

		em.remove(user);

	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("cEmail", email);

		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			System.out.println("I am findByEmail If statement");
			return users.get(0);
		}
		System.out.println("No findByEmail");
		// Handle Exception
		return null;
	}

}
