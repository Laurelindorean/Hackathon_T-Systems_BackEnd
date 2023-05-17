/**
 * 
 */
package com.dto.auth;

/**
 * @author Palmira
 *
 */
public class JwtResponse {
	
	private String token;
	private String type;
	private String username;
	
	/**
	 * @param token
	 * @param type
	 * @param username
	 */
	public JwtResponse(String token, String username) {
		super();
		this.token = token;
		this.type = "Bearer";
		this.username = username;
	}
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
