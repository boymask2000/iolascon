package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.IronBalance;
import beans.PersonalData;


public interface IronBalanceMapper {
	final String SELECT_ALL = "SELECT * FROM iron_balance WHERE N = #{n}";
	final String DELETE_BY_ID = "DELETE FROM iron_balance WHERE ID = #{id}";
	final String UPDATE = "UPDATE iron_balance SET"
		
		
			+ " date = #{date},"
			+ " serum_iron = #{serum_iron},"
			+ " ferritin = #{ferritin},"
			+ " transferrin = #{transferrin},"
			+ " is_transferrin = #{is_transferrin},"
			+ " sfTFR = #{sfTFR},"
			+ " hepcidin_serum = #{hepcidin_serum},"
			+ " liver_NMR_T2 = #{liver_NMR_T2},"
			+ " heart_NMR_T2 = #{heart_NMR_T2},"
			+ " chelation_History = #{chelation_History},"
			+ " chelator = #{chelator},"
			+ " dosage_of_chelator = #{dosage_of_chelator},"
			+ " other = #{other}"
			
			+ " WHERE ID = #{id}";

	
	final String DELETE = "DELETE FROM iron_balance WHERE ID = #{id}";
	
	final String INSERT = "INSERT INTO iron_balance (N," 
						+ " date ," 
			+" serum_iron ," 
			+" ferritin ," 
			+" transferrin," 
			+" is_transferrin ," 
			+" sfTFR ," 
			+" hepcidin_serum," 
			+" liver_NMR_T2, " 
			+" heart_NMR_T2," 
			+" chelation_History," 
			+" chelator," 
			+" dosage_of_chelator," 
			+" other" 
			+" ) "
			+ ""
			+ "VALUES (#{n}, #{date}, #{serum_iron},"+
	" #{ferritin}, #{transferrin}, #{is_transferrin}, #{sfTFR}, #{hepcidin_serum}, #{liver_NMR_T2}, #{heart_NMR_T2}, #{chelation_History},"
	+ " #{chelator}, #{dosage_of_chelator}, #{other})";
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="date", column="date"),
		@Result(property="serum_iron", column="serum_iron"),
		@Result(property="ferritin", column="ferritin"),
		@Result(property="transferrin", column="transferrin"),
		@Result(property="is_transferrin", column="is_transferrin"),
		@Result(property="sfTFR", column="sfTFR"),
		@Result(property="hepcidin_serum", column="hepcidin_serum"),
		@Result(property="liver_NMR_T2", column="liver_NMR_T2"),
		@Result(property="heart_NMR_T2", column="heart_NMR_T2"),
		@Result(property="chelation_History", column="chelation_History"),
		@Result(property="chelator", column="chelator"),
		@Result(property="dosage_of_chelator", column="dosage_of_chelator"),
		@Result(property="other", column="other"),
		
	})
	public List<IronBalance> selectAll(PersonalData data);
	
	@Update(UPDATE)
	public void update(IronBalance contact);
	
	@Insert(INSERT)
	public void insert(IronBalance contact);
	
	@Delete(DELETE_BY_ID)
	public void delete(IronBalance contact);
}
