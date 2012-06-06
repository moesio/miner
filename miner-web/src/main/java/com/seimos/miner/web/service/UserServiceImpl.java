package com.seimos.miner.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seimos.commons.service.GenericServiceImpl;

import com.seimos.miner.web.dao.UserDao;
import com.seimos.miner.web.service.UserService;
import com.seimos.miner.web.domain.User;

/**
 * @author Moesio Medeiros
 * @date Wed Jun 06 10:42:54 BRT 2012
 */
@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<User, UserDao> implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDao getDao() {
		return userDao;
	}

}