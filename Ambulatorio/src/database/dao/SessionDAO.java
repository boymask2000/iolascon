package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.Session;
import database.mapper.SessionMapper;

public class SessionDAO extends BasicDAO{
	private SqlSessionFactory sqlSessionFactory;

	public SessionDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<Session> selectAll() {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			SessionMapper mapper = session.getMapper(SessionMapper.class);
			List<Session> list = mapper.selectAll();

			return list;
		} finally {
			session.close();
		}
	}
	public void update(Session contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			SessionMapper mapper = session.getMapper(SessionMapper.class);
			mapper.update(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void insert(Session contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			SessionMapper mapper = session.getMapper(SessionMapper.class);
			mapper.insert(contact);
		
			session.commit();
			
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
