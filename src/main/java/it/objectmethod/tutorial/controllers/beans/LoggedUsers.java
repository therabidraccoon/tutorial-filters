package it.objectmethod.tutorial.controllers.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LoggedUsers {

	private Map<Long, String> loggerUsersMap;

	public Map<Long, String> getLoggerUsersMap() {
		if(this.loggerUsersMap == null) {
			this.loggerUsersMap = new HashMap<Long, String>();
		}
		return loggerUsersMap;
	}
	
}
