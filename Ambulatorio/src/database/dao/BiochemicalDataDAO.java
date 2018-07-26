package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.BiochemicalData;
import beans.PersonalData;
import database.mapper.BiochemicalDataMapper;

public class BiochemicalDataDAO {
	private SqlSessionFactory sqlSessionFactory;

	public BiochemicalDataDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<BiochemicalData> selectAll(PersonalData data) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			BiochemicalDataMapper mapper = session.getMapper(BiochemicalDataMapper.class);
			List<BiochemicalData> list = mapper.selectAll(data);

			return list;
		} finally {
			session.close();
		}
	}

	public void update(BiochemicalData contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			BiochemicalDataMapper mapper = session.getMapper(BiochemicalDataMapper.class);
			mapper.update(contact);

			session.commit();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(BiochemicalData contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			BiochemicalDataMapper mapper = session.getMapper(BiochemicalDataMapper.class);
			mapper.delete(contact);

			session.commit();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void insert(BiochemicalData contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			BiochemicalDataMapper mapper = session.getMapper(BiochemicalDataMapper.class);
			mapper.insert(contact);

			session.commit();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
