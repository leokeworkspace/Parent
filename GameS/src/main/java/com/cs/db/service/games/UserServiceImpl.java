package com.cs.db.service.games;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.dao.csentity.UserDAO;
import com.cs.model.csentity.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	private static final Logger	LOG	= LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserDAO				userDAO;

	@Override
	public int findUidCount(String userId) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			count = userDAO.findUidCount(userId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public User addOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public User findAccount(String account) {
		return userDAO.findAccount(account);
	}

	@Override
	public void delUser(User user) {
		// TODO Auto-generated method stub
		userDAO.delete(user);
	}

	@Override
	public User findAccountByUid(String userId) {
		return userDAO.findAccountByUid(userId);
	}

	@Override
	public User getUserByAccount(String account) {
		return userDAO.getUserByAccount(account);
	}

	@Override
	public List<User> getAllAccounts() {
		return userDAO.getAllAccounts();
	}

	@Override
	public int updataUserName(String account, String userName) {
		return userDAO.updataUserName(account, userName);
	}
}
