package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.PersonalData;
import beans.SurgicalIntervention;


public interface SurgicalInterventionMapper {
	final String SELECT_ALL = "SELECT * FROM surgical_intervention WHERE N = #{n}";
	final String SELECT_BY_ID = "SELECT * FROM surgical_intervention WHERE ID = #{id}";
	final String UPDATE = "UPDATE surgical_intervention SET"
		
		
			+ " splenectomy_YN = #{splenectomy_YN},"
			+ " splenectomy_DATE = #{splenectomy_DATE},"
			+ " splenectomy_age = #{splenectomy_age},"
			+ " gallstones = #{gallstones},"
			+ " cholecystectomy_YN = #{cholecystectomy_YN},"
			+ " cholecystectomy_DATE = #{cholecystectomy_DATE},"
			+ " cholecystectomy_age = #{cholecystectomy_age},"
			+ " hepatomegaly = #{hepatomegaly},"
			
	+ " WHERE ID = #{id}";

	
	final String DELETE = "DELETE FROM surgical_intervention WHERE CONTACT_ID = #{id}";
	
	final String INSERT = "INSERT INTO surgical_intervention (N," 
						+ " splenectomy_YN ," 
			+" splenectomy_DATE ," 
			+" splenectomy_age ," 
			+" gallstones," 
			+" cholecystectomy_YN ," 
			+" cholecystectomy_DATE ," 
			+" cholecystectomy_age," 
			+" hepatomegaly " 
			+" ) "
			+ ""
			+ "VALUES (#{n}, #{splenectomy_YN}, #{splenectomy_DATE},"+
	" #{splenectomy_age}, #{gallstones}, #{cholecystectomy_YN}, #{cholecystectomy_DATE}, #{cholecystectomy_age}, #{hepatomegaly})";
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="splenectomy_YN", column="splenectomy_YN"),
		@Result(property="splenectomy_DATE", column="splenectomy_DATE"),
		@Result(property="splenectomy_age", column="splenectomy_age"),
		@Result(property="gallstones", column="gallstones"),
		@Result(property="cholecystectomy_YN", column="cholecystectomy_YN"),
		@Result(property="cholecystectomy_DATE", column="cholecystectomy_DATE"),
		@Result(property="cholecystectomy_age", column="cholecystectomy_age"),
		@Result(property="hepatomegaly", column="hepatomegaly"),
		
	})
	public List<SurgicalIntervention> selectAll(PersonalData data);
	
	@Update(UPDATE)
	public void update(SurgicalIntervention contact);
	
	@Insert(INSERT)
	public void insert(SurgicalIntervention contact);
}
