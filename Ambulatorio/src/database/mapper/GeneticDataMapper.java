package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
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
	final String DELETE_BY_ID = "DELETE FROM genetic_data WHERE ID = #{id}";
	final String UPDATE = "UPDATE genetic_data SET"
		
			+ " gENE = #{gene},"
			+ " hgvs_genomic = #{hgvs_genomic},"
			+ " hgvs_protein = #{hgvs_protein},"
			+ " type_of_variant = #{type_of_variant},"
			+ " refSeq_id = #{refSeq_id},"
			+ " hOM_HET = #{hom_het},"
			+ " chr = #{chr},"
			+ " position = #{position},"
			+ " ref_allede = #{ref_allede},"
			+ " alt_allede = #{alt_allede},"
			+ " mAF_1000G = #{maf_1000G},"
			+ " mAF_EVS = #{maf_EVS},"
			+ " mAF_ExAC = #{maf_ExAC},"
			+ " aCMG_path_score = #{acmg_path_score},"
			+ " dNA_Storage = #{dna_Storage},"
			+ " other = #{other}"

	+ " WHERE ID = #{id}";
	
	final String INSERT = "INSERT INTO genetic_data"
			+ " (N," 
			+" gENE ," 
			+" hgvs_genomic ," 
			+" hgvs_protein ," 
			+" type_of_variant ," 
			+" refSeq_id," 
			+" hom_het ," 
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
			+ "VALUES ( #{n}, #{gene}, #{hgvs_genomic},#{hgvs_protein}, #{type_of_variant}, #{refSeq_id}, #{hom_het}, #{chr}, " + 
			"	#{position}, #{ref_allede}, #{alt_allede}, #{maf_1000G}, #{maf_EVS}, #{maf_ExAC}, #{acmg_path_score}, #{dna_Storage}," + 
			"	#{other})";
			
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="n", column="N"),
		@Result(property="gene", column="gENE"),
		@Result(property="hgvs_genomic", column="hgvs_genomic"),
		@Result(property="hgvs_protein", column="hgvs_protein"),
		@Result(property="type_of_variant", column="type_of_variant"),
		@Result(property="refSeq_id", column="refSeq_id"),
		@Result(property="hom_HET", column="hom_het"),
		@Result(property="chr", column="chr"),
		@Result(property="position", column="position"),
		@Result(property="ref_allede", column="ref_allede"),
		
		@Result(property="alt_allede", column="alt_allede"),
		@Result(property="maf_1000G", column="mAF_1000G"),
		@Result(property="maf_EVS", column="mAF_EVS"),
		@Result(property="maf_ExAC", column="mAF_ExAC"),
		@Result(property="acmg_path_score", column="aCMG_path_score"),
		@Result(property="dna_Storage", column="dNA_Storage"),
		@Result(property="other", column="other")
		
	})
	public List<GeneticData> selectAll(PersonalData data);
	
	@Update(UPDATE)
	public void update(GeneticData contact);
	
	@Insert(INSERT)
	public void insert(GeneticData contact);

	@Delete(DELETE_BY_ID)
	public void delete(GeneticData contact);
}
