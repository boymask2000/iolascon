package database.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import database.mapper.BiochemicalDataMapper;
import database.mapper.GeneticDataMapper;
import database.mapper.HematologicDataMapper;
import database.mapper.IndirectTestsMapper;
import database.mapper.IronBalanceMapper;
import database.mapper.OtherInfoMapper;
import database.mapper.PersonalDataMapper;
import database.mapper.QueryMapper;
import database.mapper.SurgicalInterventionMapper;
import database.mapper.UtentiMapper;


/**
 * MyBatis Connection Factory, which reads the configuration data from a XML file.

 */
public class MyBatisConnectionFactory {

	private static SqlSessionFactory sqlSessionFactory;

	static {

		try {

			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);

			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

				sqlSessionFactory.getConfiguration().addMapper(PersonalDataMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(SurgicalInterventionMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(HematologicDataMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(BiochemicalDataMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(IronBalanceMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(IndirectTestsMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(GeneticDataMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(OtherInfoMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(UtentiMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(QueryMapper.class);
			}
			
		}

		catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
		catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {

		return sqlSessionFactory;
	}

}
