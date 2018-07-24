package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.OtherInfo;
import beans.PersonalData;
import database.mapper.OtherInfoMapper;

public class OtherInfoDAO {
	private SqlSessionFactory sqlSessionFactory;

	public OtherInfoDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<OtherInfo> selectAll(PersonalData data) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			OtherInfoMapper mapper = session.getMapper(OtherInfoMapper.class);
			List<OtherInfo> list = mapper.selectAll(data);

			return list;
		} finally {
			session.close();
		}
	}

	public void update(OtherInfo contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			OtherInfoMapper mapper = session.getMapper(OtherInfoMapper.class);
			mapper.update(contact);

			session.commit();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(OtherInfo contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			OtherInfoMapper mapper = session.getMapper(OtherInfoMapper.class);
			mapper.delete(contact);

			session.commit();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void insert(OtherInfo contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			OtherInfoMapper mapper = session.getMapper(OtherInfoMapper.class);
			mapper.insert(contact);

			session.commit();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
}
