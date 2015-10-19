package com.java.springtest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import net.com.java.spring.dao.UserDAO;
import net.com.java.spring.model.User;


@Controller
public class HomeController {

	 @Autowired
	    private UserDAO userDao;
	     
	    @RequestMapping(value="/")
	    public ModelAndView home() {
	        List<User> listUsers = userDao.list();
	        ModelAndView model = new ModelAndView("hello");
	        model.addObject("userList", listUsers);
	        return model;
	    }
}
