package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Whatsnow_en database table.
 * 
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
						@NamedQuery(name = "User.singIn", query = "SELECT u FROM User u WHERE u.login=:login AND u.password=:password"),
						@NamedQuery(name = "User.changeType", query = "SELECT u FROM User u WHERE u.ID=:id")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String login;
	private String password;
	private String type;
	


	public User() {
	}


	public User(String login, String password, String type) {
		super();
		this.login = login;
		this.password = password;
		this.type = type;
	}


	public User(int iD, String login, String password, String type) {
		super();
		ID = iD;
		this.login = login;
		this.password = password;
		this.type = type;
	}
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}