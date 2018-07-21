/**
 * 
 */
package beans;

/**
 * @author giovanni
 *
 */

public class Utente {

	private int id;
	private String utenza;
	private String password;
	private String email;
	private String attivo;
	private String admin;
	private String note;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUtenza() {
		return utenza;
	}
	public void setUtenza(String utenza) {
		this.utenza = utenza;
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

}
