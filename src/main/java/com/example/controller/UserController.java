package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.css.UserCSS;
import com.example.model.User;

@RestController
public class UserController {

	@Autowired
	UserCSS usercss;
	
	@RequestMapping("index")
	public String user()
	{
		return "index.jsp";
	}
	@RequestMapping("addUser")
	public String user(User user)
	{
		usercss.save(user);
		return "index.jsp";
	}
	@RequestMapping("getUser")
	public ModelAndView getuser(@RequestParm int id)
	{
		ModelAndView mav = new ModelAndView("showUser.jsp");
		User user = usercss.findById(id).orElse(new User());

		mav.addObject(user);
		return mav;
	}
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParm int id)
	{
		ModelAndView mav = new ModelAndView("deleteUser.jsp");
		User user = usercss.findById(id).orElse(new User());
        Usercss.deleteById(id);
		mav.addObject(user);
		return mav;
	}
    @RequestMapping("updateUser")
	public ModelAndView updateUser(User user)
	{
		ModelAndView mav = new ModelAndView("updateUser.jsp");
	    user = usercss.findById(user.getId()).orElse(new User());
        Usercss.deleteById(user.getIdid);
		mav.addObject(user);
		return mav;
	}

}
