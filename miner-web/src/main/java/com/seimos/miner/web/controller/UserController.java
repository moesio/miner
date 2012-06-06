package com.seimos.miner.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.seimos.commons.controller.GenericCrudController;

import com.seimos.miner.web.domain.User;
import com.seimos.miner.web.service.UserService;

/**
 * This controller will response a call about module of User type. It's will
 * controller operations by retrieve, create, update and remove.
 * 
 * @author Moesio Medeiros
 * @date Wed Jun 06 10:42:54 BRT 2012
 * 
 */
@Controller
@RequestMapping(value = "/User")
public class UserController extends GenericCrudController<User> {

	@Autowired
	public UserController(UserService service) {
		super(service);
	}

}
