package beans;

import java.util.Date;

import org.primefaces.event.SelectEvent;

public class HematologicData {
	private int n;
	private int id;
	private Date date;
	private int rcb;
	private int hb;
	private int ht;
	private int mcv;
	private int mch;
	private int mchc;
	private int rdw;
	private int retics;
	private int retics_abs;
	private int wbc;
	private int plt;
	private int mpv;
	private int pdw;
	private int hba2;
	private int hbf;
	private String trasf_need;
	private String trasf_dep;
	private int n_life_trasf;
	private String g6pd_def;
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
	//	date.setTime(date.getTime() - (date.getTimezoneOffset() * 60 * 1000));
		this.date = JsfUtil.fixDate(date);
	}
	public int getRcb() {
		return rcb;
	}
	public void setRcb(int rcb) {
		this.rcb = rcb;
	}
	public int getHb() {
		return hb;
	}
	public void setHb(int hb) {
		this.hb = hb;
	}
	public int getHt() {
		return ht;
	}
	public void setHt(int ht) {
		this.ht = ht;
	}
	public int getMcv() {
		return mcv;
	}
	public void setMcv(int mcv) {
		this.mcv = mcv;
	}
	public int getMch() {
		return mch;
	}
	public void setMch(int mch) {
		this.mch = mch;
	}
	public int getMchc() {
		return mchc;
	}
	public void setMchc(int mchc) {
		this.mchc = mchc;
	}
	public int getRdw() {
		return rdw;
	}
	public void setRdw(int rdw) {
		this.rdw = rdw;
	}
	public int getRetics() {
		return retics;
	}
	public void setRetics(int retics) {
		this.retics = retics;
	}
	public int getWbc() {
		return wbc;
	}
	public void setWbc(int wbc) {
		this.wbc = wbc;
	}
	public int getPlt() {
		return plt;
	}
	public void setPlt(int plt) {
		this.plt = plt;
	}
	public int getMpv() {
		return mpv;
	}
	public void setMpv(int mpv) {
		this.mpv = mpv;
	}
	public int getPdw() {
		return pdw;
	}
	public void setPdw(int pdw) {
		this.pdw = pdw;
	}
	public int getHba2() {
		return hba2;
	}
	public void setHba2(int hba2) {
		this.hba2 = hba2;
	}
	public int getHbf() {
		return hbf;
	}
	public void setHbf(int hbf) {
		this.hbf = hbf;
	}
	public String getTrasf_need() {
		return trasf_need;
	}
	public void setTrasf_need(String trasf_need) {
		this.trasf_need = trasf_need;
	}
	public String getTrasf_dep() {
		return trasf_dep;
	}
	public void setTrasf_dep(String trasf_dep) {
		this.trasf_dep = trasf_dep;
	}

	public String getG6pd_def() {
		return g6pd_def;
	}
	public void setG6pd_def(String g6pd_def) {
		this.g6pd_def = g6pd_def;
	}
	public int getN_life_trasf() {
		return n_life_trasf;
	}
	public void setN_life_trasf(int n_life_trasf) {
		this.n_life_trasf = n_life_trasf;
	}
	public int getRetics_abs() {
		return retics_abs;
	}
	public void setRetics_abs(int retics_abs) {
		this.retics_abs = retics_abs;
	}
	public void fechaFinClickChange(SelectEvent event) {
	Date d =(Date)event.getObject(); // I couldn't find out why this is here given that
	                                          // the setter has already been called
	    System.out.println(d);
	}
}
