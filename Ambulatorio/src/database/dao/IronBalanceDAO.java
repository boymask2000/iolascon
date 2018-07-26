package database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.IronBalance;
import beans.PersonalData;
import database.mapper.IronBalanceMapper;

public class IronBalanceDAO {
	private SqlSessionFactory sqlSessionFactory;

	public IronBalanceDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<IronBalance> selectAll(PersonalData data) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			IronBalanceMapper mapper = session.getMapper(IronBalanceMapper.class);
			List<IronBalance> list = mapper.selectAll(data);

			return list;
		} finally {
			session.close();
		}
	}
	public void update(IronBalance contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			IronBalanceMapper mapper = session.getMapper(IronBalanceMapper.class);
			mapper.update(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void insert(IronBalance contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			IronBalanceMapper mapper = session.getMapper(IronBalanceMapper.class);
			mapper.insert(contact);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(IronBalance ironBalance) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			IronBalanceMapper mapper = session.getMapper(IronBalanceMapper.class);
			mapper.delete(ironBalance);
			
			session.commit();
		}catch(Throwable t) {
			t.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
