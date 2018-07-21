package excelimport;

import beans.OtherInfo;

public class OtherInfoFiller extends BeanFiller{
	private OtherInfo p=new OtherInfo();
	
	public OtherInfoFiller() {
		sheetName="Other info";
	}

	@Override
	public void processPair(String key, Object val) {
		if (key.startsWith("Other")) {
			p.setInfo((String) val);
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

}
