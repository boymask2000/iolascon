package beans;

import java.util.Date;

import org.omnifaces.cdi.GraphicImageBean;

@GraphicImageBean
public class IndirectTests {
	private int n;
	private int id;
	private Date date;
	private int eMA_binding_test_patients;
	private int eMA_binding_test_normal_ctr_value;
	private int ektacytometry_omin;
	private int ektacytometry_o;
	private int ektacytometry_di_max;
	private String pB_smear_description;
	private String bone_marrow_description;
	private String cation_flux;
	private String other;
	private byte[] ektacytometry_chart;
	private byte[] peripehral_blood_smear;
	private byte[] bone_marrow;
	
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
	public int geteMA_binding_test_patients() {
		return eMA_binding_test_patients;
	}
	public void seteMA_binding_test_patients(int eMA_binding_test_patients) {
		this.eMA_binding_test_patients = eMA_binding_test_patients;
	}
	public int geteMA_binding_test_normal_ctr_value() {
		return eMA_binding_test_normal_ctr_value;
	}
	public void seteMA_binding_test_normal_ctr_value(int eMA_binding_test_normal_ctr_value) {
		this.eMA_binding_test_normal_ctr_value = eMA_binding_test_normal_ctr_value;
	}
	public int getEktacytometry_omin() {
		return ektacytometry_omin;
	}
	public void setEktacytometry_omin(int ektacytometry_omin) {
		this.ektacytometry_omin = ektacytometry_omin;
	}
	public int getEktacytometry_o() {
		return ektacytometry_o;
	}
	public void setEktacytometry_o(int ektacytometry_o) {
		this.ektacytometry_o = ektacytometry_o;
	}
	public int getEktacytometry_di_max() {
		return ektacytometry_di_max;
	}
	public void setEktacytometry_di_max(int ektacytometry_di_max) {
		this.ektacytometry_di_max = ektacytometry_di_max;
	}
	public String getpB_smear_description() {
		return pB_smear_description;
	}
	public void setpB_smear_description(String pB_smear_description) {
		this.pB_smear_description = pB_smear_description;
	}
	public String getBone_marrow_description() {
		return bone_marrow_description;
	}
	public void setBone_marrow_description(String bone_marrow_description) {
		this.bone_marrow_description = bone_marrow_description;
	}
	public String getCation_flux() {
		return cation_flux;
	}
	public void setCation_flux(String cation_flux) {
		this.cation_flux = cation_flux;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public byte[] getEktacytometry_chart() {
		if( ektacytometry_chart==null) return new byte[1];
		return ektacytometry_chart;
	}
	public void setEktacytometry_chart(byte[] ektacytometry_chart) {
		this.ektacytometry_chart = ektacytometry_chart;
	}
	public byte[] getPeripehral_blood_smear() {
		if( peripehral_blood_smear==null) return new byte[1];
		return peripehral_blood_smear;
	}
	public void setPeripehral_blood_smear(byte[] peripehral_blood_smear) {
		this.peripehral_blood_smear = peripehral_blood_smear;
	}
	public byte[] getBone_marrow() {
		if( bone_marrow==null) return new byte[1];
		return bone_marrow;
	}
	public void setBone_marrow(byte[] bone_marrow) {
		this.bone_marrow = bone_marrow;
	}
	
	
	
	
	


}
