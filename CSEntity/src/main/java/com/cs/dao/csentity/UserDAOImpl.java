package com.cs.dao.csentity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cs.model.csentity.User;

@Repository
public class UserDAOImpl {
	
	private static final Logger	LOG	= LoggerFactory.getLogger(UserDAOImpl.class);
	@PersistenceContext
	private EntityManager		entityManager;

	public User findAccountByUid(String userId) {
		final String SQL = " SELECT * FROM user u WHERE u.userId = :userId ";
		LOG.debug(" SQL :"+SQL + "  value:"+userId);
		User user = (User) entityManager.createNativeQuery(SQL , User.class).setParameter("userId", userId).getSingleResult();
		return user;
	}

	public User getUserByAccount(String account) {
		return this.entityManager.createQuery("SELECT u FROM User u WHERE u.account = :account", User.class).setParameter("account", account).getSingleResult();
	}

	public List<User> getAllAccounts() {
		return this.entityManager.createNamedQuery("User.findAll", User.class).getResultList();
	}
}
