package excel;

import beans.SurgicalIntervention;

public class SurgicalFiller extends BeanFiller {
	private SurgicalIntervention p = new SurgicalIntervention();
	public SurgicalFiller() {
		sheetName="Surgical";
	}
	@Override
	public void processPair(String key, Object val) {
		
	}

	@Override
	public int getN() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setN(int n) {
		p.setN(n);
		;

	}

}
