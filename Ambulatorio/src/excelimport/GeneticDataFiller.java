package excelimport;

import beans.GeneticData;

public class GeneticDataFiller extends BeanFiller {
	private GeneticData p = new GeneticData();

	public GeneticDataFiller() {
		sheetName = "Genetic data";
	}

	@Override
	public void processPair(String key, Object val) {
		if (key.startsWith("gene")) {
			p.setgENE((String) val);
		}
		if (key.startsWith("hgvs (genomic)")) {
			p.setHgvs_genomic((String) val);
		}
		if (key.startsWith("hgvs (protein)")) {
			p.setHgvs_protein((String) val);
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
