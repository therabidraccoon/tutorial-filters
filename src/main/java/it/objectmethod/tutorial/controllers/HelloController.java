package it.objectmethod.tutorial.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.tutorial.controllers.beans.LoggedUsers;

@RestController
public class HelloController {
	
	@Autowired
	private LoggedUsers loggedUsers;
	
	@RequestMapping("/login")
	public Long login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("EFFETTUO LOGIN");
		Random rand = new Random();
		Long token = rand.nextLong();
		
		loggedUsers.getLoggerUsersMap().put(token, username);
		
		return token;
	}

	@RequestMapping("/hello1")
	public String getHelloPrimo() {
		System.out.println("HELLO 1");
		return "HELLO!!";
	}
	
	@RequestMapping("/hello2")
	public String getHelloSecondo() {
		System.out.println("HELLO 2");
		return "HELLO!!";
	}
	
	@RequestMapping("/hello3")
	public String getHelloTerzo() {
		System.out.println("HELLO 3");
		return "HELLO!!";
	}
}
