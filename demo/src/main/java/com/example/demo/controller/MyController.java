package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Show;
import com.example.demo.entity.User;
import com.example.demo.service.AuditoriumService;

@RestController
@RequestMapping("/auditorium")
public class MyController {
	
	@Autowired
	private AuditoriumService auditoriumservice;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		
		auditoriumservice.saveUser(user);
		
		return "success";
	}
	@GetMapping("/getAllUser")
	public List<User> getalluser()
	{
		return auditoriumservice.getAllUser();
	}
	
	@PostMapping("/createShow")
	public String createShow(@RequestBody Show show)
	{
		auditoriumservice.createShow(show);
		return "Show Ceated Successfully";
	}
	@GetMapping("/displayAllShow")
	public List<Show> displayAllShow()
	{
		return auditoriumservice.displayAllShow();
	}
    //added
	

}
