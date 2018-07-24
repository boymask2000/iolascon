package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.OtherInfo;
import beans.PersonalData;


public interface OtherInfoMapper {
	final String SELECT_ALL = "SELECT * FROM other_info WHERE N = #{n}";
	final String DELETE_BY_ID = "DELETE FROM other_info WHERE ID = #{id}";
	final String SELECT_BY_ID = "SELECT * FROM other_info WHERE ID = #{id}";
	final String UPDATE = "UPDATE other_info SET"
		
			+ " info = #{info}"
		
			+ " WHERE ID = #{id}";

	
	final String DELETE = "DELETE FROM other_info WHERE ID = #{id}";
	
	final String INSERT = "INSERT INTO other_info (N," 
						+ " info " 
		
			+" ) "
			+ ""
			+ "VALUES (#{n}, #{info})";
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="info", column="info")
		
	})
	public List<OtherInfo> selectAll(PersonalData data);
	
	@Update(UPDATE)
	public void update(OtherInfo contact);
	
	@Delete(DELETE_BY_ID)
	public void delete(OtherInfo contact);
	
	@Insert(INSERT)
	public void insert(OtherInfo contact);
}
