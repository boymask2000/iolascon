package database;

import java.util.List;

import beans.Session;
import beans.Utente;
import database.dao.SessionDAO;
import database.dao.UtentiDAO;

public class SessioniHelper {


	public static List<Session> getElencoSessioni() {

		SessionDAO dao = new SessionDAO();
		return dao.selectAll();
	}

	public static void insertSessione(Session s) {
	
		SessionDAO dao = new SessionDAO();
		dao.insert(s);
	}

	public static void updateSession(Session s) {
		SessionDAO dao = new SessionDAO();
		dao.update(s);
	}

	public static void deleteSession() {
		SessionDAO dao = new SessionDAO();
		// dao.elimina(session);
	}

}
