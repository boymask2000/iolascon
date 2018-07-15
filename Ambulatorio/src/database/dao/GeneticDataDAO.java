package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.GeneticData;
import beans.PersonalData;
import database.mapper.GeneticDataMapper;

public class GeneticDataDAO {
	private SqlSessionFactory sqlSessionFactory;

	public GeneticDataDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<GeneticData> selectAll(PersonalData data) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			GeneticDataMapper mapper = session.getMapper(GeneticDataMapper.class);
			List<GeneticData> list = mapper.selectAll(data);

			return list;
		} finally {
			session.close();
		}
	}
	public void update(GeneticData contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			GeneticDataMapper mapper = session.getMapper(GeneticDataMapper.class);
			mapper.update(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void insert(GeneticData contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			GeneticDataMapper mapper = session.getMapper(GeneticDataMapper.class);
			mapper.insert(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
