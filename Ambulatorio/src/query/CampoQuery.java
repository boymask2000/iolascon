package query;

import java.lang.reflect.Field;

public class CampoQuery {
	private String tabella;
	private String campo;
	private boolean selected;
	private boolean lessThen;
	private boolean greaterThen;
	private boolean equalTo;

	private Object lessThenValue;
	private Object greaterThenValue;
	private Object equalToValue;
	private boolean goToOutput;

	// public CampoQuery(String tab, String f) {
	// this.tabella = tab;
	// this.campo = f;
	// }
	public CampoQuery() {

	}

	public CampoQuery(String tab, Field f) {
		this.tabella = tab;
		this.campo = f.getName();
	}

	public String getTabella() {
		return tabella;
	}

	public void setTabella(String tabella) {
		this.tabella = tabella;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isLessThen() {
		this.selected = lessThen || greaterThen || equalTo;
		return lessThen;
	}

	public void setLessThen(boolean lessThen) {
		this.selected = lessThen || greaterThen || equalTo;
		this.lessThen = lessThen;
	}

	public boolean isGreaterThen() {
		return greaterThen;
	}

	public void setGreaterThen(boolean greaterThen) {
		this.selected = lessThen || greaterThen || equalTo;
		this.greaterThen = greaterThen;
	}

	public boolean isEqualTo() {
		return equalTo;
	}

	public void setEqualTo(boolean equalTo) {
		this.selected = lessThen || greaterThen || equalTo;
		this.equalTo = equalTo;
	}

	public Object getLessThenValue() {
		return lessThenValue;
	}

	public void setLessThenValue(Object lessThenValue) {
		this.lessThenValue = lessThenValue;
		setLessThen(true);
	}

	public Object getGreaterThenValue() {
		return greaterThenValue;
	}

	public void setGreaterThenValue(Object greaterThenValue) {
		this.greaterThenValue = greaterThenValue;
		setGreaterThen(true);
	}

	public Object getEqualToValue() {
		return equalToValue;
	}

	public void setEqualToValue(Object equalToValue) {
		this.equalToValue = equalToValue;
		setEqualTo(true);
	}

	public boolean isGoToOutput() {
		return goToOutput;
	}

	public void setGoToOutput(boolean goToOutput) {
		this.goToOutput = goToOutput;
	}

}
