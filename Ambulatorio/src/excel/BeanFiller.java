package excel;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public abstract class BeanFiller {
	protected String sheetName = "";

	public abstract void processPair(String key, Object val);

	public abstract int getN();

	public abstract void setN(int n);

	public String getName() {
		return "";
	}

	public String getSurname() {
		return "";
	}

	public void setName(String s) {
	}

	public void setSurname(String s) {
	}

	public String getSheetName() {
		return sheetName;
	}

	public void fillData(Map<String, Object> vals) {
		Set<Entry<String, Object>> set = vals.entrySet();

		for (Entry<String, Object> e : set) {

			String key = e.getKey();
			Object val = e.getValue();
			
			key=key.toLowerCase();

			System.out.println("["+key+"]=["+val+"]");
			processPair(key, val);
		
		}
	}
}
