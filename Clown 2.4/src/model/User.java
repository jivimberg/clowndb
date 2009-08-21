package model;

import java.util.Date;

import org.jdom.Element;

import enums.UserType;

public class User {

	private String userName;
	private String password;
	private UserType type;
	
	public User(String userName, String password, UserType type) {
		this.userName = userName;
		this.password = password;
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
	
	public Element toXML(){
		Element element = new Element("User");
		Date date = new Date();
		element.setAttribute("date", date.toString());
		element.setAttribute("userName", userName);
		element.setAttribute("password", password);
		element.setAttribute("type", type.toString());
		return element;
	}
	
	public String toString(){
		return userName;
	}
}
