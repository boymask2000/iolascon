package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.Query;


public interface QueryMapper {
	final String SELECT_ALL = "SELECT * FROM queries ";
	final String SELECT_BY_ID = "SELECT * FROM queries WHERE ID = #{id}";
	
	final String UPDATE = "UPDATE queries SET"
		
		
			+ " xml = #{xml},"
			+ " owner = #{owner},"
			+ " description = #{description},"
			
			
			+ " WHERE id = #{id}";

	
	final String DELETE = "DELETE FROM queries WHERE ID = #{id}";
	
	final String INSERT = "INSERT INTO queries (" 
						+ " xml ," 
			+" owner ," 
			+" description " 
	 
			+" ) "
			+ ""
			+ "VALUES (#{xml}, #{owner}, #{description})";
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="xml", column="xml"),
		@Result(property="owner", column="owner"),
		@Result(property="description", column="description"),
		
	})
	public List<Query> selectAll();
	
	@Update(UPDATE)
	public void update(Query contact);
	
	@Insert(INSERT)
	public void insert(Query contact);
}
