package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.PersonalData;

public interface PersonalDataMapper {
	final String SELECT_ALL = "SELECT * FROM personal_data";
	final String SELECT_BY_ID = "SELECT * FROM personal_data WHERE ID = #{id}";
	final String UPDATE = "UPDATE personal_data SET"
		
			+ " NAME = #{name},"
			+ " SURNAME = #{surname},"
			+ " Familial_degree = #{familial_degree},"
			+ " Consanguinity = #{consanguinity},"
			+ " Withdrawal = #{withdrawal},"
			+ " Acceptance = #{acceptance},"
			+ " code_Ethnicity = #{codeEthnicity},"
			+ " gender = #{gender},"
			+ " dob = #{dob},"
			+ " place_of_residence = #{place_of_residence},"
			+ " reference_doctor = #{reference_doctor},"
			+ " initial_clinical = #{initial_clinical},"
			+ " age_at_diagnosis = #{age_at_diagnosis},"
			+ " onset_symptoms = #{onset_symptoms},"
			+ " photo = #{photo},"
			+ " age_onset_symptoms = #{age_onset_symptoms}"
			+ " WHERE ID = #{id}";;
	

	
	
	
	final String DELETE = "DELETE FROM personal_data WHERE CONTACT_ID = #{id}";
	final String INSERT = "INSERT INTO personal_data (NAME ," 
						+ " SURNAME ," 
			+" Familial_degree ," 
			+" Consanguinity ," 
			+" Withdrawal," 
			+" Acceptance ," 
			+" code_Ethnicity ," 
			+" gender," 
			+" dob ," 
			+" place_of_residence," 
			+" reference_doctor," 
			+" initial_clinical ," 
			+" age_at_diagnosis ," 
			+" photo ," 
			+" onset_symptoms ," 
			+" age_onset_symptoms ) "
			+ ""
			+ "VALUES (#{name}, #{surname}, #{familial_degree},"+
	" #{consanguinity}, #{withdrawal}, #{acceptance}, #{codeEthnicity}, #{gender}, #{dob}, #{place_of_residence}, #{reference_doctor},"+
		"#{initial_clinical}, #{age_at_diagnosis}, #{photo}, #{onset_symptoms}, #{age_onset_symptoms})";
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="name", column="name"),
		@Result(property="surname", column="SURNAME"),
		@Result(property="familial_degree", column="Familial_degree"),
		@Result(property="consanguinity", column="Consanguinity"),
		@Result(property="withdrawal", column="Withdrawal"),
		@Result(property="acceptance", column="Acceptance"),
		@Result(property="codeEthnicity", column="code_Ethnicity"),
		@Result(property="gender", column="gender"),
		@Result(property="dob", column="dob"),
		@Result(property="place_of_residence", column="place_of_residence"),
		@Result(property="reference_doctor", column="reference_doctor"),
		@Result(property="initial_clinical", column="initial_clinical"),
		@Result(property="age_at_diagnosis", column="age_at_diagnosis"),
		@Result(property="onset_symptoms", column="onset_symptoms"),
		@Result(property="age_onset_symptoms", column="age_onset_symptoms")
	})
	public List<PersonalData> selectAll();
	
	@Update(UPDATE)
	public void update(PersonalData contact);
	
	@Insert(INSERT)
	public void insert(PersonalData contact);
}
