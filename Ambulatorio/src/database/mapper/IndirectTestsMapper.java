package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import beans.IndirectTests;
import beans.PersonalData;

public interface IndirectTestsMapper {
	final String SELECT_ALL = "SELECT * FROM indirect_tests WHERE N = #{n}";
	final String SELECT_BY_ID = "SELECT * FROM indirect_tests WHERE ID = #{id}";
	final String UPDATE = "UPDATE indirect_tests SET"
			+ " N = #{n},"
			+ " date = #{date},"
			+ " ema_binding_test_patients = #{ema_binding_test_patients},"
			+ " ema_binding_test_normal_ctr_value = #{ema_binding_test_normal_ctr_value},"
			+ " ektacytometry_omin = #{ektacytometry_omin},"
			+ " ektacytometry_o = #{ektacytometry_o},"
			+ " ektacytometry_di_max = #{ektacytometry_di_max},"
			+ " pB_smear_description = #{pb_smear_description},"
			+ " bone_marrow_description = #{bone_marrow_description},"
			+ " cation_flux = #{cation_flux},"
			+ " other = #{other},"
			+ " ektacytometry_chart = #{ektacytometry_chart},"
			+ " peripehral_blood_smear = #{peripehral_blood_smear},"
			+ " bone_marrow = #{bone_marrow}"
			
			+ " WHERE ID = #{id}";

	
	final String DELETE = "DELETE FROM indirect_tests WHERE CONTACT_ID = #{id}";
	
	
	final String INSERT = "INSERT INTO indirect_tests"
			+ " (N," 
			+" date ," 
			+" ema_binding_test_patients ," 
			+" ema_binding_test_normal_ctr_value ," 
			+" ektacytometry_omin," 
			+" ektacytometry_o ," 
			+" ektacytometry_di_max ," 
			+" pB_smear_description," 
			+" bone_marrow_description," 
			+" cation_flux," 
			+" other," 
			+" ektacytometry_chart," 
			+" peripehral_blood_smear," 
			+" bone_marrow" 
			
			+" ) "
			+ ""
			+ "VALUES ( #{n}, #{date}, #{ema_binding_test_patients}, #{ema_binding_test_normal_ctr_value}, #{ektacytometry_omin},"
			+ " #{ektacytometry_o}, #{ektacytometry_di_max}, " + 
			"	#{pb_smear_description}, #{bone_marrow_description},#{cation_flux}, #{other}, "
			+ "#{ektacytometry_chart}, #{peripehral_blood_smear}, #{bone_marrow})";
			
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="date", column="date"),
		@Result(property="ema_binding_test_patients", column="ema_binding_test_patients"),
		@Result(property="ema_binding_test_normal_ctr_value", column="ema_binding_test_normal_ctr_value"),
		@Result(property="ektacytometry_omin", column="ektacytometry_omin"),
		@Result(property="ektacytometry_o", column="ektacytometry_o"),
		@Result(property="ektacytometry_di_max", column="ektacytometry_di_max"),
		@Result(property="pb_smear_description", column="pB_smear_description"),
		@Result(property="cation_flux", column="cation_flux"),
		
		@Result(property="other", column="other"),
		@Result(property="ektacytometry_chart", column="ektacytometry_chart", jdbcType=JdbcType.BLOB),
		@Result(property="peripehral_blood_smear", column="peripehral_blood_smear", jdbcType=JdbcType.BLOB),
		@Result(property="bone_marrow", column="bone_marrow", jdbcType=JdbcType.BLOB),
		
	})
	public List<IndirectTests> selectAll(PersonalData data);
	
	@Update(UPDATE)
	public void update(IndirectTests contact);
	
	@Insert(INSERT)
	public void insert(IndirectTests contact);
}
