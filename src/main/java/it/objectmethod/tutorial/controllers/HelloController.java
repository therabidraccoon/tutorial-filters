package it.objectmethod.tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.tutorial.controllers.beans.User;
import it.objectmethod.tutorial.controllers.service.JWTService;

@RestController
public class HelloController {

//	@Autowired
//	private LoggedUsers loggedUsers;

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
	public String getHelloPrimo(@RequestHeader("auth-token") String authToken) {
		System.out.println("HELLO 1 -" + authToken);
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

	@GetMapping("/test")
	public ResponseEntity<User> getUser(@RequestHeader("auth-token") String authToken) {
		ResponseEntity<User> loggedUser = null;
		User user = jwtSrv.getUserByToken(authToken);
		if (user != null) {
			loggedUser = new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			loggedUser = new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		return loggedUser;
	}
}
