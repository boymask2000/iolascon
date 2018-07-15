/**
 * 
 */
package beans;

import java.util.Date;

import org.omnifaces.cdi.GraphicImageBean;

import common.AmbUtils;

/**
 * @author giovanni
 *
 */
@GraphicImageBean
public class PersonalData {
	private int n;
	private int id;
	private String name;
	private String surname;
	private String familial_degree;
	private String consanguinity;
	private Date withdrawal;
	private Date acceptance;
	private String codeEthnicity;
	private String gender;
	private String dob;
	private String place_of_residence;
	private int reference_doctor;
	private int initial_clinical;
	private int age_at_diagnosis;
	private String onset_symptoms;
	private int age_onset_symptoms;
	private byte[] photo;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFamilial_degree() {
		return familial_degree;
	}
	public void setFamilial_degree(String familial_degree) {
		this.familial_degree = familial_degree;
	}
	public String getConsanguinity() {
		return consanguinity;
	}
	public void setConsanguinity(String consanguinity) {
		this.consanguinity = consanguinity;
	}
	public Date getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(Date withdrawal) {
		this.withdrawal = withdrawal;
	}
	public Date getAcceptance() {
		return acceptance;
	}
	public void setAcceptance(Date acceptance) {
		this.acceptance = acceptance;
	}
	public String getCodeEthnicity() {
		return codeEthnicity;
	}
	public void setCodeEthnicity(String codeEthnicity) {
		this.codeEthnicity = codeEthnicity;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPlace_of_residence() {
		return place_of_residence;
	}
	public void setPlace_of_residence(String place_of_residence) {
		this.place_of_residence = place_of_residence;
	}
	public int getReference_doctor() {
		return reference_doctor;
	}
	public void setReference_doctor(int reference_doctor) {
		this.reference_doctor = reference_doctor;
	}
	public int getInitial_clinical() {
		return initial_clinical;
	}
	public void setInitial_clinical(int initial_clinical) {
		this.initial_clinical = initial_clinical;
	}
	public int getAge_at_diagnosis() {
		return age_at_diagnosis;
	}
	public void setAge_at_diagnosis(int age_at_diagnosis) {
		this.age_at_diagnosis = age_at_diagnosis;
	}
	public String getOnset_symptoms() {
		return onset_symptoms;
	}
	public void setOnset_symptoms(String onset_symptoms) {
		this.onset_symptoms = onset_symptoms;
	}
	public int getAge_onset_symptoms() {
		return age_onset_symptoms;
	}
	public void setAge_onset_symptoms(int age_onset_symptoms) {
		this.age_onset_symptoms = age_onset_symptoms;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
		
		
	}
	public String getEncodedImage() {
		return AmbUtils.convertToBase64(getPhoto());
	}
	
}
