package print;

public class Pair {
	private String name;
	private Object val;

	public Pair(String name, Object v) {
		this.name = name;
		this.val = v;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}
