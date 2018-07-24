package database;

import java.util.List;

import beans.Utente;
import database.dao.UtentiDAO;

public class UtentiBeanHelper {
	private Utente selectedUtente;

	public List<Utente> getElencoUtenti() {

		UtentiDAO dao = new UtentiDAO();
		return dao.selectAll();
	}

	public Utente getSelectedUtente() {
		if (selectedUtente == null)
			selectedUtente = new Utente();
		return selectedUtente;
	}

	public void setSelectedUtente(Utente selectedUtente) {
		this.selectedUtente = selectedUtente;
	}
	public void insertUtente() {
		UtentiDAO dao = new UtentiDAO();
		dao.insert(selectedUtente);
	}
	public void modificaUtente() {
		UtentiDAO dao = new UtentiDAO();
		dao.update(selectedUtente);
	}
	public void eliminaUtente() {
		UtentiDAO dao = new UtentiDAO();
		dao.elimina(selectedUtente);
	}
	public int getNumAdmins() {
		UtentiDAO dao = new UtentiDAO();
		return dao.getAdmins().size();
	}
	public boolean isOnlyAdmin() {
		return getNumAdmins()==1 && selectedUtente.getAdmin()!=null && selectedUtente.getAdmin().equals("Y");
	}
}
