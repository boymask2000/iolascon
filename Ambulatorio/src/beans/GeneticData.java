package beans;

public class GeneticData {
	private int id;
	private int n;
	private String gene;
	private String hgvs_genomic;
	private String hgvs_protein;
	private String type_of_variant;
	private String refSeq_id;
	private String hom_het;
	private String chr;
	private int position;
	private String ref_allede;
	private String alt_allede;
	private int maf_1000G;
	private int maf_EVS;
	private int maf_ExAC;
	private String acmg_path_score;
	private String dna_Storage;
	private String other;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String getGene() {
		return gene;
	}
	public void setGene(String gene) {
		this.gene = gene;
	}
	public String getHgvs_genomic() {
		return hgvs_genomic;
	}
	public void setHgvs_genomic(String hgvs_genomic) {
		this.hgvs_genomic = hgvs_genomic;
	}
	public String getHgvs_protein() {
		return hgvs_protein;
	}
	public void setHgvs_protein(String hgvs_protein) {
		this.hgvs_protein = hgvs_protein;
	}
	public String getType_of_variant() {
		return type_of_variant;
	}
	public void setType_of_variant(String type_of_variant) {
		this.type_of_variant = type_of_variant;
	}
	public String getRefSeq_id() {
		return refSeq_id;
	}
	public void setRefSeq_id(String refSeq_id) {
		this.refSeq_id = refSeq_id;
	}
	public String getHom_het() {
		return hom_het;
	}
	public void setHom_het(String hom_het) {
		this.hom_het = hom_het;
	}
	public String getChr() {
		return chr;
	}
	public void setChr(String chr) {
		this.chr = chr;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getRef_allede() {
		return ref_allede;
	}
	public void setRef_allede(String ref_allede) {
		this.ref_allede = ref_allede;
	}
	public String getAlt_allede() {
		return alt_allede;
	}
	public void setAlt_allede(String alt_allede) {
		this.alt_allede = alt_allede;
	}
	public int getMaf_1000G() {
		return maf_1000G;
	}
	public void setMaf_1000G(int maf_1000g) {
		maf_1000G = maf_1000g;
	}
	public int getMaf_EVS() {
		return maf_EVS;
	}
	public void setMaf_EVS(int maf_EVS) {
		this.maf_EVS = maf_EVS;
	}
	public int getMaf_ExAC() {
		return maf_ExAC;
	}
	public void setMaf_ExAC(int maf_ExAC) {
		this.maf_ExAC = maf_ExAC;
	}
	public String getAcmg_path_score() {
		return acmg_path_score;
	}
	public void setAcmg_path_score(String acmg_path_score) {
		this.acmg_path_score = acmg_path_score;
	}
	public String getDna_Storage() {
		return dna_Storage;
	}
	public void setDna_Storage(String dna_Storage) {
		this.dna_Storage = dna_Storage;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
}
