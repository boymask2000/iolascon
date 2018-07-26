package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.HematologicData;
import beans.PersonalData;

public interface HematologicDataMapper {
	final String SELECT_ALL = "SELECT * FROM Hematologic_data WHERE N = #{n}";
	final String DELETE_BY_ID = "DELETE FROM Hematologic_data WHERE ID = #{id}";
	final String UPDATE = "UPDATE Hematologic_data SET"
		
			+ " date = #{date},"
			+ " rcb = #{rcb},"
			+ " hb = #{hb},"
			+ " ht = #{ht},"
			+ " mch = #{mch},"
			+ " mcv = #{mcv},"
			+ " mchc = #{mchc},"
			+ " rdw = #{rdw},"
			+ " retics = #{retics},"
			+ " retics_abs = #{retics_abs},"
			+ " wbc = #{wbc},"
			+ " plt = #{plt},"
			+ " mpv = #{mpv},"
			+ " pdw = #{pdw},"
			+ " hba2 = #{hba2},"
			+ " hbf = #{hbf},"
			+ " trasf_need = #{trasf_need},"
			+ " trasf_dep = #{trasf_dep},"
			+ " N_life_trasf = #{n_life_trasf},"
			+ " g6pd_def = #{g6pd_def}"
			
	+ " WHERE ID = #{id}";

	
	final String DELETE = "DELETE FROM Hematologic_data WHERE CONTACT_ID = #{id}";
	
	
	final String INSERT = "INSERT INTO Hematologic_data"
			+ " (N," 
			+" date ," 
			+" rcb ," 
			+" hb ," 
			+" ht," 
			+" mcv ," 
			+" mch ," 
			+" mchc," 
			+" rdw," 
			+" retics," 
			+" retics_abs," 
			+" wbc," 
			+" plt," 
			+" mpv," 
			+" pdw," 
			+" hba2," 
			+" hbf," 
			+" trasf_need," 
			+" trasf_dep," 
			+" N_life_trasf," 
			+" g6pd_def " 
			+" ) "
			+ ""
			+ "VALUES ( #{n}, #{date}, #{rcb}, #{hb}, #{ht}, #{mcv}, #{mch}, " + 
			"	#{mchc}, #{rdw}, #{retics}, #{retics_abs}, #{wbc}, #{plt}, #{mpv}, #{pdw}, #{hba2}," + 
			"	#{hbf}, #{trasf_need}, #{trasf_dep}, #{n_life_trasf}, #{g6pd_def})";
			
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="date", column="date"),
		@Result(property="rcb", column="rcb"),
		@Result(property="hb", column="hb"),
		@Result(property="ht", column="ht"),
		@Result(property="mcv", column="mcv"),
		@Result(property="mch", column="mch"),
		@Result(property="mchc", column="mchc"),
		@Result(property="rdw", column="rdw"),
		
		@Result(property="retics", column="retics"),
		@Result(property="retics_abs", column="retics_abs"),
		@Result(property="wbc", column="wbc"),
		@Result(property="plt", column="plt"),
		@Result(property="mpv", column="mpv"),
		@Result(property="pdw", column="pdw"),
		@Result(property="hba2", column="hba2"),
		@Result(property="hbf", column="hbf"),
		@Result(property="trasf_need", column="trasf_need"),
		@Result(property="trasf_dep", column="trasf_dep"),
		@Result(property="n_life_trasf", column="n_life_trasf"),
		@Result(property="g6pd_def", column="g6pd_def"),
		
	})
	public List<HematologicData> selectAll(PersonalData data);
	
	@Update(UPDATE)
	public void update(HematologicData contact);
	
	@Insert(INSERT)
	public void insert(HematologicData contact);

	@Delete(DELETE_BY_ID)
	public void delete(HematologicData contact);
}
