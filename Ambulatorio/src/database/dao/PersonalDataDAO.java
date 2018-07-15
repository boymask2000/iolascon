package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.PersonalData;
import database.mapper.PersonalDataMapper;

public class PersonalDataDAO {
	private SqlSessionFactory sqlSessionFactory;

	public PersonalDataDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<PersonalData> selectAll() {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			PersonalDataMapper mapper = session.getMapper(PersonalDataMapper.class);
			List<PersonalData> list = mapper.selectAll();

			return list;
		} finally {
			session.close();
		}
	}
	public void update(PersonalData contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			PersonalDataMapper mapper = session.getMapper(PersonalDataMapper.class);
			mapper.update(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void insert(PersonalData contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			PersonalDataMapper mapper = session.getMapper(PersonalDataMapper.class);
			mapper.insert(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
