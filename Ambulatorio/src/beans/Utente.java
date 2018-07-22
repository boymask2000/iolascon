/**
 * 
 */
package beans;

import database.dao.UtentiDAO;

/**
 * @author giovanni
 *
 */

public class Utente {

	private int id;
	private String user;
	private String password;
	private String email;
	private String attivo;
	private String admin;
	private String note;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAttivo() {
		return attivo;
	}

	public void setAttivo(String attivo) {
		this.attivo = attivo;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String logout() {
		user = null;
		password = null;
		return "login";
	}

	public String checkLogin() {
		if (user == null)
			JsfUtil.redirect("login");
		return "";
	}

	public String login() {
		UtentiDAO dao = new UtentiDAO();
		Utente u = dao.search(this);

		if (u != null) {
			
			message = "Successfully logged-in.";
			if (u == null || u.getAdmin()==null || !u.getAdmin().equals("Y"))
				return "main";
			else
				return "admin";
		} else {
			user = null;
			message = "Wrong credentials.";
			return "login";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
