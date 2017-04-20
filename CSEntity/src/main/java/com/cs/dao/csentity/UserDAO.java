package com.cs.dao.csentity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cs.model.csentity.User;

public interface UserDAO extends JpaRepository<User, Long> {
	@Query(value = " SELECT count(u.userId) FROM user u WHERE u.userId = ?1 ", nativeQuery = true)
	public int findUidCount(String userId);

	@Query(value = " SELECT u FROM User u WHERE u.account = ?1 ")
	public User findAccount(String account);

	public User findAccountByUid(String userId);

	public User getUserByAccount(String account);

	public List<User> getAllAccounts();

	@Modifying
	@Query(value = " UPDATE user u SET u.userName = ?2 WHERE u.account = ?1 ", nativeQuery = true)
	public int updataUserName(String account, String userName);
}
