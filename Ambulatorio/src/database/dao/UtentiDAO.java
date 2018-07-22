package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.Utente;
import database.mapper.UtentiMapper;

public class UtentiDAO {
	private SqlSessionFactory sqlSessionFactory;

	public UtentiDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<Utente> selectAll() {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			UtentiMapper mapper = session.getMapper(UtentiMapper.class);
			List<Utente> list = mapper.selectAll();

			return list;
		} finally {
			session.close();
		}
	}
	public List<Utente> getAdmins() {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			UtentiMapper mapper = session.getMapper(UtentiMapper.class);
			List<Utente> list = mapper.getAdmins();

			return list;
		} finally {
			session.close();
		}
	}

	public void update(Utente contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			UtentiMapper mapper = session.getMapper(UtentiMapper.class);
			mapper.update(contact);

			session.commit();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Utente search(Utente contact) {
		Utente u = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {

			UtentiMapper mapper = session.getMapper(UtentiMapper.class);
			u = mapper.search(contact);

			session.commit();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
		return u;
	}

	public void insert(Utente contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			UtentiMapper mapper = session.getMapper(UtentiMapper.class);
			mapper.insert(contact);

			session.commit();

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void elimina(Utente contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			UtentiMapper mapper = session.getMapper(UtentiMapper.class);
			mapper.delete(contact);

			session.commit();

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
