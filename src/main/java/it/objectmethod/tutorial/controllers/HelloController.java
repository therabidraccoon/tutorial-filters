package it.objectmethod.tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.tutorial.controllers.beans.LoggedUsers;
import it.objectmethod.tutorial.controllers.beans.User;
import it.objectmethod.tutorial.controllers.service.JWTService;

@RestController
public class HelloController {

	@Autowired
	private LoggedUsers loggedUsers;

	@Autowired
	private JWTService jwtSrv;

//	@RequestMapping("/login")
//	public Long login(@RequestParam("username") String username, @RequestParam("password") String password) {
//		System.out.println("EFFETTUO LOGIN");
//		Random rand = new Random();
//		Long token = rand.nextLong();
//		
//		loggedUsers.getLoggerUsersMap().put(token, username);
//		
//		return token;
//	}

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("EFFETTUO LOGIN");
		User user = new User();
		user.setId(123L);
		user.setUsername(username);
		user.setPassword(password);

		String token = jwtSrv.createJWTToken(user);

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
