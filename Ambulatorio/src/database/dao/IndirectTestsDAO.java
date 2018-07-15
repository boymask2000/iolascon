package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.IndirectTests;
import beans.PersonalData;
import database.mapper.IndirectTestsMapper;

public class IndirectTestsDAO {
	private SqlSessionFactory sqlSessionFactory;

	public IndirectTestsDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<IndirectTests> selectAll(PersonalData data) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			IndirectTestsMapper mapper = session.getMapper(IndirectTestsMapper.class);
			List<IndirectTests> list = mapper.selectAll(data);

			return list;
		} finally {
			session.close();
		}
	}
	public void update(IndirectTests contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			IndirectTestsMapper mapper = session.getMapper(IndirectTestsMapper.class);
			mapper.update(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void insert(IndirectTests contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			IndirectTestsMapper mapper = session.getMapper(IndirectTestsMapper.class);
			mapper.insert(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
