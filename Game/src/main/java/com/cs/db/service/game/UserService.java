package com.cs.db.service.game;

import java.util.List;

import com.cs.model.csentity.User;

public interface UserService {
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public int findUidCount(String userId);

	public User addOrUpdateUser(User user);

	public User findAccount(String account);

	public void delUser(User user);

	public User findAccountByUid(String userId);

	public User getUserByAccount(String account);

	public List<User> getAllAccounts();

	public int updataUserName(String account, String userName);
}
