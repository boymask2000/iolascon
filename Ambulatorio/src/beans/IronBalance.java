package beans;

import java.util.Date;

public class IronBalance {
	private int n ;
	private int id;
	private Date date;
	private int serum_iron;
	private int ferritin;
	private int transferrin;
	private int is_transferrin;
	private int sfTFR;
	private int hepcidin_serum;
	
	private int liver_NMR_T2;
	private int heart_NMR_T2;
	private String chelation_History;
	private String chelator;
	private int dosage_of_chelator;
	private String other;
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSerum_iron() {
		return serum_iron;
	}
	public void setSerum_iron(int serum_iron) {
		this.serum_iron = serum_iron;
	}
	public int getFerritin() {
		return ferritin;
	}
	public void setFerritin(int ferritin) {
		this.ferritin = ferritin;
	}
	public int getTransferrin() {
		return transferrin;
	}
	public void setTransferrin(int transferrin) {
		this.transferrin = transferrin;
	}
	public int getIs_transferrin() {
		return is_transferrin;
	}
	public void setIs_transferrin(int is_transferrin) {
		this.is_transferrin = is_transferrin;
	}
	public int getSfTFR() {
		return sfTFR;
	}
	public void setSfTFR(int sfTFR) {
		this.sfTFR = sfTFR;
	}
	public int getHepcidin_serum() {
		return hepcidin_serum;
	}
	public void setHepcidin_serum(int hepcidin_serum) {
		this.hepcidin_serum = hepcidin_serum;
	}
	public int getLiver_NMR_T2() {
		return liver_NMR_T2;
	}
	public void setLiver_NMR_T2(int liver_NMR_T2) {
		this.liver_NMR_T2 = liver_NMR_T2;
	}
	public int getHeart_NMR_T2() {
		return heart_NMR_T2;
	}
	public void setHeart_NMR_T2(int heart_NMR_T2) {
		this.heart_NMR_T2 = heart_NMR_T2;
	}
	public String getChelation_History() {
		return chelation_History;
	}
	public void setChelation_History(String chelation_History) {
		this.chelation_History = chelation_History;
	}
	public String getChelator() {
		return chelator;
	}
	public void setChelator(String chelator) {
		this.chelator = chelator;
	}
	public int getDosage_of_chelator() {
		return dosage_of_chelator;
	}
	public void setDosage_of_chelator(int dosage_of_chelator) {
		this.dosage_of_chelator = dosage_of_chelator;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
}
