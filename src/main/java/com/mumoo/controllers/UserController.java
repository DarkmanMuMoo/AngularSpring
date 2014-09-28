package com.mumoo.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mumoo.dao.UserDao;
import com.mumoo.exceptions.BadParamException;
import com.mumoo.exceptions.ErrorException;
import com.mumoo.models.PagingResultSet;
import com.mumoo.models.UserPojo;
import com.mumoo.models.ModifiedResult;
import com.mumoo.utility.PagingUtil;

@Controller
@RequestMapping("service/user")
public class UserController {

	@Autowired
	public UserDao userDao;

	private final static Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	PagingResultSet getAll(
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "perPage", required = false, defaultValue = "15") int perPage)
			throws ErrorException {

		PagingResultSet resultSet = new PagingResultSet();
		List<UserPojo> userList = null;
		
		int totalAmount = 0;
		try {
			totalAmount = userDao.getCountTotalUser();
			int offSet= PagingUtil.getOffSet(page,perPage,totalAmount);
			userList = userDao.findAll(offSet, perPage);
			resultSet.setResults(userList);
			resultSet.setTotalAmount(totalAmount);

			return resultSet;
		} catch (DataAccessException e) {
			log.error("SqlError", e);      
			throw new ErrorException("SqlError");
		} catch (Exception e) {
			log.error("Somthing Wrong", e);
			throw new ErrorException("Somthing Wrong");
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	UserPojo getUser(@PathVariable String id) throws BadParamException {
		try {
			return userDao.findById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BadParamException("invalid ID");
		}

	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody
	ModifiedResult updateUser(@RequestBody UserPojo user) throws BadParamException, ErrorException {
		boolean result = false;
		
		try {
			userDao.update(user);
			result=true;
		} catch (DataAccessException e) {
			throw new ErrorException("Unable to Update");
		}
		
		return  new ModifiedResult(result, user);
			
	}
}
