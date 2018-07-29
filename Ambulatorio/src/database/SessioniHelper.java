package database;

import java.util.List;

import beans.Session;
import beans.Utente;
import database.dao.SessionDAO;
import database.dao.UtentiDAO;

public class SessioniHelper {
	private Session session;

	public List<Session> getElencoSessioni() {

		SessionDAO dao = new SessionDAO();
		return dao.selectAll();
	}

	public void insertSessione(Session s) {
		this.session=s;
		SessionDAO dao = new SessionDAO();
		dao.insert(session);
	}

	public void updateSession(Session s) {
		SessionDAO dao = new SessionDAO();
		dao.update(s);
	}

	public void deleteSession() {
		SessionDAO dao = new SessionDAO();
		// dao.elimina(session);
	}

}
