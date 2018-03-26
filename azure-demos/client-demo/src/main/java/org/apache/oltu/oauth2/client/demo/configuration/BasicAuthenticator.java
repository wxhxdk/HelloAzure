package org.apache.oltu.oauth2.client.demo.configuration;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class BasicAuthenticator extends Authenticator {
	private String user = "";
	private String password = "";
	public BasicAuthenticator(String user, String password) {
	    this.user = user;
	    this.password = password;
	}
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(user, password.toCharArray());
	}
}
