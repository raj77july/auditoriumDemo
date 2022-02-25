package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.ShowRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.Show;
import com.example.demo.entity.User;
import com.example.demo.service.AuditoriumService;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {


	
	@Autowired
	private AuditoriumService service;

	@MockBean
	private UserRepository repository;
	@MockBean
	private ShowRepository showrepo;
	
	

	@Test
	public void getAllUser() {
		List<User> users=new ArrayList<User>();
		List<Role> roles=new ArrayList<Role>();
		Role role=new Role();
		role.setRole("USER");
		role.setRole_id(1);
		roles.add(role);
	  User user=new User();
	  user.setUser_id(1);
	  user.setName("Raj");
	  user.setEmail("r@gmail.com");
	  user.setMobileNumber("1212121212");
	  user.setPassword("usernew");
	  user.setRole(roles);
	  users.add(user);
	  
		
		when(repository.findAll()).thenReturn(users);
		assertEquals(1, service.getAllUser().size());
	}

	@Test
	public void displayAllshow()
	{
		Show show =new Show();
		show.setNumberOfSeat(30);
		show.setShow_id(1);
		show.setShow_name("Ramayan");
		List<Show> showlist=new ArrayList<>();
		showlist.add(show);
		when(showrepo.findAll()).thenReturn(showlist);
		assertEquals(1, service.displayAllShow().size());
	}
	
	@Test
	public void saveUserTest() {
		
		List<Role> roles=new ArrayList<Role>();
		Role role=new Role();
		role.setRole("ADMIN");
		role.setRole_id(3);
		roles.add(role);
	  User user=new User();
	  user.setUser_id(3);
	  user.setName("Raj");
	  user.setEmail("rajjaiswal@gmail.com");
	  user.setMobileNumber("1212121212");
	  user.setPassword("usernew");
	  user.setRole(roles);
	 
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.saveUser(user));
	}
	
	@Test
	public void createShowTest() {
		
		Show show =new Show();
		show.setNumberOfSeat(30);
		show.setShow_id(1);
		show.setShow_name("Ramayan");
			
			when(showrepo.save(show)).thenReturn(show);
			assertEquals(show, service.createShow(show));
		
	}

	
}
