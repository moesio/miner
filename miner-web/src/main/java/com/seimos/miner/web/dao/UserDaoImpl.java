package com.seimos.miner.web.dao;

import org.springframework.stereotype.Repository;

import br.com.seimos.commons.dao.GenericDaoImpl;

import com.seimos.miner.web.dao.UserDao;
import com.seimos.miner.web.domain.User;

/**
 * @author Moesio Medeiros
 * @date Wed Jun 06 10:42:54 BRT 2012
 */
@Repository("user")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
}