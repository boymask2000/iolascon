package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.Query;
import database.mapper.QueryMapper;

public class QueryDAO {
	private SqlSessionFactory sqlSessionFactory;

	public QueryDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<Query> selectAll() {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			QueryMapper mapper = session.getMapper(QueryMapper.class);
			List<Query> list = mapper.selectAll();

			return list;
		} finally {
			session.close();
		}
	}
	public void update(Query contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			QueryMapper mapper = session.getMapper(QueryMapper.class);
			mapper.update(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void insert(Query contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			QueryMapper mapper = session.getMapper(QueryMapper.class);
			mapper.insert(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
