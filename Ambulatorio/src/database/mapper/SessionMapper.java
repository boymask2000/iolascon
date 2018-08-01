package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.Session;

public interface SessionMapper {
	final String SELECT_ALL = "SELECT * FROM audit order by start_date desc";
	final String SELECT_BY_ID = "SELECT * FROM audit WHERE ID = #{id}";
	final String UPDATE = "UPDATE audit SET"
		
			+ " user = #{user},"
			+ " start_date = #{startDate},"
			+ " end_date = #{endDate} "
		
			+ " WHERE ID = #{id}";
	
	final String DELETE = "DELETE FROM audit WHERE ID = #{id}";
	final String INSERT = "INSERT INTO audit (user ," 
						+ " start_date ," 
						+" end_date ) "
			+ ""
			+ "VALUES (#{user}, #{startDate},#{endDate})";
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="user", column="user"),
		@Result(property="startDate", column="start_date"),
		@Result(property="endDate", column="end_date")
	})
	public List<Session> selectAll();
	
	@Update(UPDATE)
	public void update(Session contact);
	
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(Session contact);
}
