package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.BiochemicalData;
import beans.PersonalData;


public interface BiochemicalDataMapper {
	final String SELECT_ALL = "SELECT * FROM biochemical_data WHERE N = #{n}";
	final String DELETE_BY_ID = "DELETE FROM biochemical_data WHERE ID = #{id}";
	
	final String UPDATE = "UPDATE biochemical_data SET"
		
		
			+ " date = #{date},"
			+ " Tot_bilirubin = #{tot_bilirubin},"
			+ " Indirect_Bilirubin = #{indirect_bilirubin},"
			+ " LDH = #{ldh},"
			+ " AST = #{ast},"
			+ " ALT = #{alt},"
			+ " EPO = #{epo},"
			+ " Na = #{na},"
			+ " k = #{k},"
			+ " CA = #{ca},"
			+ " DAT_YN = #{dat_yn},"
			+ " DAT_DATE = #{dat_date},"
			+ " DAT_micromol = #{dat_micromol},"
			+ " DAT_vn1 = #{dat_vn1},"
			+ " DAT_millisec = #{dat_millisec},"
			+ " DAT_vn2 = #{dat_vn2},"
			+ " other = #{other}"
			
	+ " WHERE ID = #{id}";

	
	final String DELETE = "DELETE FROM biochemical_data WHERE CONTACT_ID = #{id}";
	
	final String INSERT = "INSERT INTO biochemical_data (N," 
						+ " date ," 
			+" Tot_bilirubin ," 
			+" Indirect_Bilirubin ," 
			+" LDH," 
			+" AST ," 
			+" ALT ," 
			+" EPO," 
			+" Na ," 
			+" k ," 
			+" ca ," 
			+" DAT_YN ," 
			+" DAT_DATE ," 
			+" DAT_micromol ," 
			+" DAT_vn1 ," 
			+" DAT_millisec ," 
			+" DAT_vn2 ," 
			+" other " 
			+" ) "
			+ ""
			+ "VALUES (#{n}, #{date}, #{tot_bilirubin},"+
	" #{indirect_bilirubin}, #{ldh}, #{ast}, #{alt}, #{epo}, #{na},"
	+ " #{k}, #{ca}, #{dat_yn}, #{dat_date}, #{dat_micromol}, #{dat_vn1}, #{dat_millisec}, #{dat_vn2}, #{other})";
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="date", column="date"),
		@Result(property="tot_bilirubin", column="tot_bilirubin"),
		@Result(property="indirect_bilirubin", column="indirect_bilirubin"),
		@Result(property="ldh", column="ldh"),
		@Result(property="ast", column="ast"),
		@Result(property="alt", column="alt"),
		@Result(property="epo", column="epo"),
		@Result(property="na", column="na"),
		@Result(property="k", column="k"),
		@Result(property="ca", column="ca"),
		@Result(property="dat_yn", column="dat_yn"),
		@Result(property="dat_date", column="dat_date"),
		@Result(property="dat_micromol", column="dat_micromol"),
		@Result(property="dat_vn1", column="dat_vn1"),
		@Result(property="dat_millisec", column="dat_millisec"),
		@Result(property="dat_vn2", column="dat_vn2"),
		@Result(property="other", column="other"),
		
		
	})
	public List<BiochemicalData> selectAll(PersonalData data);
	
	@Update(UPDATE)
	public void update(BiochemicalData contact);
	
	@Insert(INSERT)
	public void insert(BiochemicalData contact);
	
	@Delete(DELETE_BY_ID)
	public void delete(BiochemicalData contact);
}
