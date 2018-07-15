package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.HematologicData;
import beans.PersonalData;
import database.mapper.HematologicDataMapper;

public class HematologicDataDAO {
	private SqlSessionFactory sqlSessionFactory;

	public HematologicDataDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<HematologicData> selectAll(PersonalData data) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			HematologicDataMapper mapper = session.getMapper(HematologicDataMapper.class);
			List<HematologicData> list = mapper.selectAll(data);

			return list;
		} finally {
			session.close();
		}
	}
	public void update(HematologicData contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			HematologicDataMapper mapper = session.getMapper(HematologicDataMapper.class);
			mapper.update(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void insert(HematologicData contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			HematologicDataMapper mapper = session.getMapper(HematologicDataMapper.class);
			mapper.insert(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
