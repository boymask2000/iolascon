package beans;

public class GeneticData {
	private int id;
	private int n;
	private String gENE;
	private String hgvs_genomic;
	private String hgvs_protein;
	private String type_of_variant;
	private String refSeq_id;
	private String hOM_HET;
	private String chr;
	private int position;
	private String ref_allede;
	private String alt_allede;
	private int mAF_1000G;
	private int mAF_EVS;
	private int mAF_ExAC;
	private String aCMG_path_score;
	private String dNA_Storage;
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
	public String getgENE() {
		return gENE;
	}
	public void setgENE(String gENE) {
		this.gENE = gENE;
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
	public String gethOM_HET() {
		return hOM_HET;
	}
	public void sethOM_HET(String hOM_HET) {
		this.hOM_HET = hOM_HET;
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
	public int getmAF_1000G() {
		return mAF_1000G;
	}
	public void setmAF_1000G(int mAF_1000G) {
		this.mAF_1000G = mAF_1000G;
	}
	public int getmAF_EVS() {
		return mAF_EVS;
	}
	public void setmAF_EVS(int mAF_EVS) {
		this.mAF_EVS = mAF_EVS;
	}
	public int getmAF_ExAC() {
		return mAF_ExAC;
	}
	public void setmAF_ExAC(int mAF_ExAC) {
		this.mAF_ExAC = mAF_ExAC;
	}
	public String getaCMG_path_score() {
		return aCMG_path_score;
	}
	public void setaCMG_path_score(String aCMG_path_score) {
		this.aCMG_path_score = aCMG_path_score;
	}
	public String getdNA_Storage() {
		return dNA_Storage;
	}
	public void setdNA_Storage(String dNA_Storage) {
		this.dNA_Storage = dNA_Storage;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
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

}
