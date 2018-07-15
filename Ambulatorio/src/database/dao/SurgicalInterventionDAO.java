package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.PersonalData;
import beans.SurgicalIntervention;
import database.mapper.SurgicalInterventionMapper;

public class SurgicalInterventionDAO {
	private SqlSessionFactory sqlSessionFactory;

	public SurgicalInterventionDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<SurgicalIntervention> selectAll(PersonalData data) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			SurgicalInterventionMapper mapper = session.getMapper(SurgicalInterventionMapper.class);
			List<SurgicalIntervention> list = mapper.selectAll(data);

			return list;
		} finally {
			session.close();
		}
	}
	public void update(SurgicalIntervention contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			SurgicalInterventionMapper mapper = session.getMapper(SurgicalInterventionMapper.class);
			mapper.update(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void insert(SurgicalIntervention contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			SurgicalInterventionMapper mapper = session.getMapper(SurgicalInterventionMapper.class);
			mapper.insert(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
