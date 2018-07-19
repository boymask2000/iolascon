package excel;

import beans.PersonalData;

public class PersonalDataFiller extends BeanFiller {
	private PersonalData p = new PersonalData();

	public PersonalDataFiller() {
		sheetName = "Personal data";
	}

	@Override
	public void processPair(String key, Object val) {

		if (key.startsWith("Consanguineity")) {
			p.setConsanguinity((String) val);
		}

		// if( key.startsWith("Hepatomegaly")) {
		// p.setEHConsanguinity((String)val);
		// }
		if (key.startsWith("age onset")) {
			p.setAge_onset_symptoms((Integer.parseInt((String) val)));
		}
		if (key.startsWith("age at diagnosis")) {
			p.setAge_at_diagnosis((Integer.parseInt((String) val)));
		}
		if (key.startsWith("gender")) {
			p.setGender((String) val);
		}
		if (key.startsWith("code ethnicity")) {
			p.setCodeEthnicity((String) val);
		}
		if (key.startsWith("dob")) {
			p.setDob((String) val);
		}
		if (key.startsWith("initial clinical")) {
			p.setInitial_clinical((Integer.parseInt((String) val)));
		}

	}

	@Override
	public int getN() {

		return p.getN();
	}

	@Override
	public void setN(int n) {
		p.setN(n);

	}

	@Override
	public String getName() {

		return p.getName();
	}

	@Override
	public String getSurname() {

		return p.getSurname();
	}

	@Override
	public void setName(String s) {

		p.setName(s);
	}

	@Override
	public void setSurname(String s) {

		p.setSurname(s);
	}

}
