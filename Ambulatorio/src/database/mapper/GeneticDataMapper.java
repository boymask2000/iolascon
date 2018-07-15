package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.GeneticData;
import beans.PersonalData;

public interface GeneticDataMapper {
	final String SELECT_ALL = "SELECT * FROM genetic_data WHERE N = #{n}";
	final String SELECT_BY_ID = "SELECT * FROM genetic_data WHERE ID = #{id}";
	final String UPDATE = "UPDATE genetic_data SET"
		
			+ " gENE = #{gENE},"
			+ " hGVS = #{hGVS},"
			+ " type_of_variant = #{type_of_variant},"
			+ " refSeq_id = #{refSeq_id},"
			+ " hOM_HET = #{hOM_HET},"
			+ " chr = #{chr},"
			+ " position = #{position},"
			+ " ref_allede = #{ref_allede},"
			+ " alt_allede = #{alt_allede},"
			+ " mAF_1000G = #{mAF_1000G},"
			+ " mAF_EVS = #{mAF_EVS},"
			+ " mAF_ExAC = #{mAF_ExAC},"
			+ " aCMG_path_score = #{aCMG_path_score},"
			+ " dNA_Storage = #{dNA_Storage},"
			+ " other = #{other}"

	+ " WHERE ID = #{id}";
	
	final String DELETE = "DELETE FROM genetic_data WHERE CONTACT_ID = #{id}";
	
	
	final String INSERT = "INSERT INTO genetic_data"
			+ " (N," 
			+" gENE ," 
			+" hGVS ," 
			+" type_of_variant ," 
			+" refSeq_id," 
			+" hOM_HET ," 
			+" chr ," 
			+" position," 
			+" ref_allede," 
			+" alt_allede," 
			+" mAF_1000G," 
			+" mAF_EVS," 
			+" mAF_ExAC," 
			+" aCMG_path_score," 
			+" dNA_Storage," 
			+" other" 
			+" ) "
			+ ""
			+ "VALUES ( #{n}, #{gENE}, #{hGVS}, #{type_of_variant}, #{refSeq_id}, #{hOM_HET}, #{chr}, " + 
			"	#{position}, #{ref_allede}, #{alt_allede}, #{mAF_1000G}, #{mAF_EVS}, #{mAF_ExAC}, #{aCMG_path_score}, #{dNA_Storage}," + 
			"	#{other})";
			
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="gENE", column="gENE"),
		@Result(property="hGVS", column="hGVS"),
		@Result(property="type_of_variant", column="type_of_variant"),
		@Result(property="refSeq_id", column="refSeq_id"),
		@Result(property="hOM_HET", column="hOM_HET"),
		@Result(property="chr", column="chr"),
		@Result(property="position", column="position"),
		@Result(property="ref_allede", column="ref_allede"),
		
		@Result(property="alt_allede", column="alt_allede"),
		@Result(property="mAF_1000G", column="mAF_1000G"),
		@Result(property="mAF_EVS", column="mAF_EVS"),
		@Result(property="mAF_ExAC", column="mAF_ExAC"),
		@Result(property="aCMG_path_score", column="aCMG_path_score"),
		@Result(property="dNA_Storage", column="dNA_Storage"),
		@Result(property="other", column="other")
		
	})
	public List<GeneticData> selectAll(PersonalData data);
	
	@Update(UPDATE)
	public void update(GeneticData contact);
	
	@Insert(INSERT)
	public void insert(GeneticData contact);
}
