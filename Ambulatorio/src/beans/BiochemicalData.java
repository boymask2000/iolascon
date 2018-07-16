package beans;

import java.util.Date;

public class BiochemicalData {
	private int n;
	private int id;
	private Date date;
	private int tot_bilirubin;
	private int indirect_bilirubin;
	private int ldh;
	private int haptoglobin;
	private int ast;
	private int alt;
	private int epo;
	private int na;
	private int k;
	private int ca;
	private String dat_yn;
	private Date dat_date;
	private int dat_micromol;
	private int dat_vn1;
	private int dat_millisec;
	private int dat_vn2;
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
		this.date = JsfUtil.fixDate(date);
	}
	public int getTot_bilirubin() {
		return tot_bilirubin;
	}
	public void setTot_bilirubin(int tot_bilirubin) {
		this.tot_bilirubin = tot_bilirubin;
	}
	public int getIndirect_bilirubin() {
		return indirect_bilirubin;
	}
	public void setIndirect_bilirubin(int indirect_bilirubin) {
		this.indirect_bilirubin = indirect_bilirubin;
	}
	public int getLdh() {
		return ldh;
	}
	public void setLdh(int ldh) {
		this.ldh = ldh;
	}
	public int getHaptoglobin() {
		return haptoglobin;
	}
	public void setHaptoglobin(int haptoglobin) {
		this.haptoglobin = haptoglobin;
	}
	public int getAst() {
		return ast;
	}
	public void setAst(int ast) {
		this.ast = ast;
	}
	public int getAlt() {
		return alt;
	}
	public void setAlt(int alt) {
		this.alt = alt;
	}
	public int getEpo() {
		return epo;
	}
	public void setEpo(int epo) {
		this.epo = epo;
	}
	public int getNa() {
		return na;
	}
	public void setNa(int na) {
		this.na = na;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public int getCa() {
		return ca;
	}
	public void setCa(int ca) {
		this.ca = ca;
	}
	public String getDat_yn() {
		return dat_yn;
	}
	public void setDat_yn(String dat_yn) {
		this.dat_yn = dat_yn;
	}
	public Date getDat_date() {
		return dat_date;
	}
	public void setDat_date(Date dat_date) {
		this.dat_date = dat_date;
	}
	public int getDat_micromol() {
		return dat_micromol;
	}
	public void setDat_micromol(int dat_micromol) {
		this.dat_micromol = dat_micromol;
	}
	public int getDat_vn1() {
		return dat_vn1;
	}
	public void setDat_vn1(int dat_vn1) {
		this.dat_vn1 = dat_vn1;
	}
	public int getDat_millisec() {
		return dat_millisec;
	}
	public void setDat_millisec(int dat_millisec) {
		this.dat_millisec = dat_millisec;
	}
	public int getDat_vn2() {
		return dat_vn2;
	}
	public void setDat_vn2(int dat_vn2) {
		this.dat_vn2 = dat_vn2;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
}
