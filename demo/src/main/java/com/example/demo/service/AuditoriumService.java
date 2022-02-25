package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShowRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Show;
import com.example.demo.entity.User;

@Service
public class AuditoriumService {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private ShowRepository showrepo;

	public User saveUser(User user) {
		System.out.print(user);
		return userrepo.save(user);

	}

	public List<User> getAllUser() {
		return userrepo.findAll();

	}

	public Show createShow(Show show) {

		return showrepo.save(show);
	}
	public List<Show> displayAllShow() {

		return showrepo.findAll();
	}
}
