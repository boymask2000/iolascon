package beans;

import java.util.Date;

public class SurgicalIntervention {
	private int n;
	private int id;

	private String splenectomy_YN;
	private Date splenectomy_DATE;
	private int splenectomy_age;
	private String gallstones;

	private String cholecystectomy_YN;
	private Date cholecystectomy_DATE;
	private int cholecystectomy_age;
	private String hepatomegaly;

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


	public String getSplenectomy_YN() {
		return splenectomy_YN;
	}

	public void setSplenectomy_YN(String s) {
		this.splenectomy_YN = s;
	
	}

	public Date getSplenectomy_DATE() {
		return splenectomy_DATE;
	}

	public void setSplenectomy_DATE(Date splenectomy_DATE) {
	//	this.splenectomy_DATE = splenectomy_DATE;
		this.splenectomy_DATE = JsfUtil.fixDate(splenectomy_DATE);
	}

	public int getSplenectomy_age() {
		return splenectomy_age;
	}

	public void setSplenectomy_age(int splenectomy_age) {
		this.splenectomy_age = splenectomy_age;
	}

	public String getGallstones() {
		return gallstones;
	}

	public void setGallstones(String gallstones) {
		this.gallstones = gallstones;
	}

	public String getCholecystectomy_YN() {
		return cholecystectomy_YN;
	}

	public void setCholecystectomy_YN(String cholecystectomy_YN) {
		this.cholecystectomy_YN = cholecystectomy_YN;
	}


	public int getCholecystectomy_age() {
		return cholecystectomy_age;
	}

	public void setCholecystectomy_age(int cholecystectomy_age) {
		this.cholecystectomy_age = cholecystectomy_age;
	}

	public String getHepatomegaly() {
		return hepatomegaly;
	}

	public void setHepatomegaly(String hepatomegaly) {
		this.hepatomegaly = hepatomegaly;
	}


	public Date getCholecystectomy_DATE() {
		return cholecystectomy_DATE;
	}

	public void setCholecystectomy_DATE(Date cholecystectomy_DATE) {
		//this.cholecystectomy_DATE = cholecystectomy_DATE;
		this.cholecystectomy_DATE = JsfUtil.fixDate(cholecystectomy_DATE);
	}
}
