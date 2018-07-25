package database;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.UploadedFile;

import beans.BiochemicalData;
import beans.GeneticData;
import beans.HematologicData;
import beans.IndirectTests;
import beans.IronBalance;
import beans.JsfUtil;
import beans.OtherInfo;
import beans.PersonalData;
import beans.Query;
import beans.SurgicalIntervention;
import database.dao.BiochemicalDataDAO;
import database.dao.GeneticDataDAO;
import database.dao.HematologicDataDAO;
import database.dao.IndirectTestsDAO;
import database.dao.IronBalanceDAO;
import database.dao.OtherInfoDAO;
import database.dao.PersonalDataDAO;
import database.dao.QueryDAO;
import database.dao.SurgicalInterventionDAO;
import database.dao.UtentiDAO;
import query.QueryHandler;
import query.QueryXml;

public class DBUtil {

	private List<SurgicalIntervention> elencoSurgical = new ArrayList<SurgicalIntervention>();
	private List<HematologicData> elencoEmatologic = new ArrayList<HematologicData>();
	private List<Query> elencoQuery = new ArrayList<Query>();
	private PersonalData selectedPersonalData;
	private SurgicalIntervention surgicalIntervention;
	private HematologicData hematologicData;
	private BiochemicalData biochemicalData;
	private OtherInfo otherInfo;
	private Query query;
	private List<BiochemicalData> elencoBiochemicalData = new ArrayList<BiochemicalData>();

	private IronBalance ironBalance;

	private IndirectTests indirectTests;
	private GeneticData geneticData;

	// ##########################################-Query-###########################################
	public List<Query> getElencoQuery() {
		elencoQuery.clear();
		QueryDAO dao = new QueryDAO();
		return dao.selectAll();
	}

	public void insertQuery() {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		QueryHandler queryHandler = (QueryHandler) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "queryHandler");

		String query = queryHandler.buildQuery();

		QueryXml qx = new QueryXml();
		try {
			String xml = qx.queryToXml(queryHandler);
			Query q = new Query();
			q.setXml(xml);
			q.setDescription(queryHandler.getDescription());
			QueryDAO dao = new QueryDAO();

			dao.insert(q);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addMessage("Inserimento");

	}

	public Query getQuery() {
		if (query == null)
			query = new Query();
		return query;
	}

	// ##########################################IndirectTests###########################################
	public List<IndirectTests> getElencoIndirectTests() {
		elencoBiochemicalData.clear();
		IndirectTestsDAO dao = new IndirectTestsDAO();
		return dao.selectAll(selectedPersonalData);
	}

	public void insertIndirectTests() {
		addMessage("Aggiornamento");

		IndirectTestsDAO dao = new IndirectTestsDAO();
		indirectTests.setN(selectedPersonalData.getN());

		dao.insert(indirectTests);
	}

	public IndirectTests getIndirectTests() {
		if (indirectTests == null)
			indirectTests = new IndirectTests();
		return indirectTests;
	}

	public void updateIndirectTests() {
		addMessage("Aggiornamento");

		IndirectTestsDAO dao = new IndirectTestsDAO();
		dao.update(indirectTests);
	}
	// ##########################################-GeneticData-###########################################

	public List<GeneticData> getElencoGeneticData() {
		// elencoBiochemicalData.clear();
		GeneticDataDAO dao = new GeneticDataDAO();
		return dao.selectAll(selectedPersonalData);
	}

	public void insertGeneticData() {
		addMessage("Inserimento");

		GeneticDataDAO dao = new GeneticDataDAO();
		geneticData.setN(selectedPersonalData.getN());

		dao.insert(geneticData);
	}

	public GeneticData getGeneticData() {
		if (geneticData == null)
			geneticData = new GeneticData();
		return geneticData;
	}

	// ##########################################-IronBalance-###########################################
	public List<IronBalance> getElencoIronBalance() {
		elencoBiochemicalData.clear();
		IronBalanceDAO dao = new IronBalanceDAO();
		return dao.selectAll(selectedPersonalData);
	}

	public void insertIronBalance() {
		addMessage("Inserimento");

		IronBalanceDAO dao = new IronBalanceDAO();
		ironBalance.setN(selectedPersonalData.getN());

		dao.insert(ironBalance);
	}

	public IronBalance getIronBalance() {
		if (ironBalance == null)
			ironBalance = new IronBalance();
		return ironBalance;
	}

	// ##########################################-BiochemicalData-###########################################
	public List<BiochemicalData> getElencoBiochemicalData() {
		elencoBiochemicalData.clear();
		BiochemicalDataDAO dao = new BiochemicalDataDAO();
		return dao.selectAll(selectedPersonalData);
	}

	public void insertBiochemicalData() {
		addMessage("Inserimento");

		BiochemicalDataDAO dao = new BiochemicalDataDAO();
		biochemicalData.setN(selectedPersonalData.getN());

		dao.insert(biochemicalData);
	}

	public BiochemicalData getBiochemicalData() {
		if (biochemicalData == null)
			biochemicalData = new BiochemicalData();
		return biochemicalData;
	}

	public void setHematologicData(BiochemicalData biochemicalData) {
		this.biochemicalData = biochemicalData;
	}

	public void setElencoBiochemicalData(List<BiochemicalData> l) {
		this.elencoBiochemicalData = l;
	}

	// ########################################## HematologicData
	// ###########################################
	// public List<HematologicData> getElencoHematologicData() {
	// elencoEmatologic.clear();
	// HematologicDataDAO dao = new HematologicDataDAO();
	// return dao.selectAll(selectedPersonalData);
	// }
	public void insertHematologicData() {
		addMessage("Inserimento");

		HematologicDataDAO dao = new HematologicDataDAO();
		hematologicData.setN(selectedPersonalData.getN());

		dao.insert(hematologicData);
	}

	public List<HematologicData> getElencoEmatologic() {
		elencoEmatologic.clear();
		HematologicDataDAO dao = new HematologicDataDAO();
		return dao.selectAll(selectedPersonalData);
	}

	public HematologicData getHematologicData() {
		if (hematologicData == null)
			hematologicData = new HematologicData();
		return hematologicData;
	}

	public void setHematologicData(HematologicData hematologicData) {
		this.hematologicData = hematologicData;
	}

	public void setElencoEmatologic(List<HematologicData> elencoEmatologic) {
		this.elencoEmatologic = elencoEmatologic;
	}
	// ##########################################-SurgicalIntervention-###########################################

	public List<SurgicalIntervention> getElencoSurgical() {
		elencoSurgical.clear();
		SurgicalInterventionDAO dao = new SurgicalInterventionDAO();
		return dao.selectAll(selectedPersonalData);
	}

	public boolean isOneSurgical() {
		if (getElencoSurgical().size() == 1) {
			surgicalIntervention = getElencoSurgical().get(0);
			return true;
		}
		return false;
	}

	public boolean isZeroSurgical() {
		return getElencoSurgical().size() == 0;
	}

	public void insertSurgical() {
		addMessage("Inserimento");

		SurgicalInterventionDAO dao = new SurgicalInterventionDAO();
		surgicalIntervention.setN(selectedPersonalData.getN());

		dao.insert(surgicalIntervention);
	}

	public SurgicalIntervention getSurgicalIntervention() {
		if (surgicalIntervention == null)
			surgicalIntervention = new SurgicalIntervention();
		return surgicalIntervention;
	}

	public void setSurgicalIntervention(SurgicalIntervention surgicalIntervention) {
		this.surgicalIntervention = surgicalIntervention;
	}

	// ##########################################-OtherInfo-###########################################
	public List<OtherInfo> getElencoOtherInfo() {

		OtherInfoDAO dao = new OtherInfoDAO();
		return dao.selectAll(selectedPersonalData);
	}

	public boolean isOneOtherInfo() {
		if (getElencoOtherInfo().size() == 1) {
			otherInfo = getElencoOtherInfo().get(0);
			return true;
		}
		return false;
	}

	public void insertOtherInfo() {
		addMessage("Inserimento");

		OtherInfoDAO dao = new OtherInfoDAO();
		otherInfo.setN(selectedPersonalData.getN());

		dao.insert(otherInfo);
	}

	public void modificaOtherInfo() {
		addMessage("Inserimento");

		OtherInfoDAO dao = new OtherInfoDAO();
		otherInfo.setN(selectedPersonalData.getN());

		dao.update(otherInfo);
	}

	public void cancellaOtherInfo() {
		addMessage("Inserimento");

		OtherInfoDAO dao = new OtherInfoDAO();
		otherInfo.setN(selectedPersonalData.getN());

		dao.delete(otherInfo);
	}

	public OtherInfo getOtherInfo() {
		if (otherInfo == null)
			otherInfo = new OtherInfo();
		return otherInfo;
	}

	public void setOtherInfo(OtherInfo o) {
		this.otherInfo = o;
	}

	// ##########################################-PersonalData-###########################################
	public String getCurrentSelectionDesc() {
		if (customPazienti == null)
			return "All data";
		else
			return currentQuery.getDescription();

	}

	// private String currentSelectionDesc;
	private Query currentQuery = null;
	private List<PersonalData> customPazienti = null;

	public void resetQuery() {
		customPazienti = null;
		currentQuery = null;
		QueryHandler qh = (QueryHandler) JsfUtil.getBean("queryHandler");
		qh.resetQuery();

	}

	public List<PersonalData> getPazienti() {
		if (customPazienti != null)
			return customPazienti;

		PersonalDataDAO dao = new PersonalDataDAO();
		List<PersonalData> list = dao.selectAll();
		return list;
	}

	public void updatePersonalData() {
		addMessage("Update");

		PersonalDataDAO dao = new PersonalDataDAO();
		dao.update(selectedPersonalData);
	}

	public void insertPersonalData() {
		addMessage("Welcome to Primefaces!!");

		PersonalDataDAO dao = new PersonalDataDAO();
		dao.insert(selectedPersonalData);
	}

	public PersonalData getSelectedPersonalData() {
		if (selectedPersonalData == null)
			selectedPersonalData = new PersonalData();
		return selectedPersonalData;
	}

	public void setSelectedPersonalData(PersonalData selectedPersonalData) {
		this.selectedPersonalData = selectedPersonalData;
		surgicalIntervention = null;
		hematologicData = null;
	}

	// ###############################################################################
	public void onRowSelect(SelectEvent event) {
		selectedPersonalData = (PersonalData) event.getObject();
		FacesMessage msg = new FacesMessage("Car Selected " + ((PersonalData) event.getObject()).getN());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onIndirectTestsRowSelect(SelectEvent event) {
		indirectTests = (IndirectTests) event.getObject();

	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Car Unselected");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	private UploadedFile uploadedFile;

	public void fileUploadListener(FileUploadEvent event) {
		uploadedFile = event.getFile();

		byte[] bb = uploadedFile.getContents();
		selectedPersonalData.setPhoto(bb);

	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	// ********************************
	private UploadedFile uploadedFileIndirectTests_1;

	public void uploadedFileIndirectTests_1_Listener(FileUploadEvent event) {
		indirectTests = (IndirectTests) event.getComponent().getAttributes().get("foo");
		uploadedFileIndirectTests_1 = event.getFile();

		byte[] bb = uploadedFileIndirectTests_1.getContents();

		indirectTests.setBone_marrow(bb);

		updateIndirectTests();
	}

	public UploadedFile getUploadedFileIndirectTests_1() {
		return uploadedFileIndirectTests_1;
	}

	public void setUploadedFileIndirectTests_1(UploadedFile uploadedFileIndirectTests_1) {
		this.uploadedFileIndirectTests_1 = uploadedFileIndirectTests_1;
	}

	// ********************************
	private UploadedFile uploadedFileIndirectTests_2;

	public void uploadedFileIndirectTests_2_Listener(FileUploadEvent event) {
		indirectTests = (IndirectTests) event.getComponent().getAttributes().get("foo");
		uploadedFileIndirectTests_2 = event.getFile();

		byte[] bb = uploadedFileIndirectTests_2.getContents();

		indirectTests.setEktacytometry_chart(bb);

		updateIndirectTests();
	}

	public UploadedFile getUploadedFileIndirectTests_2() {
		return uploadedFileIndirectTests_2;
	}

	public void setUploadedFileIndirectTests_2(UploadedFile uploadedFileIndirectTests_2) {
		this.uploadedFileIndirectTests_2 = uploadedFileIndirectTests_2;
	}

	// ********************************
	private UploadedFile uploadedFileIndirectTests_3;

	public void uploadedFileIndirectTests_3_Listener(FileUploadEvent event) {
		indirectTests = (IndirectTests) event.getComponent().getAttributes().get("foo");
		uploadedFileIndirectTests_3 = event.getFile();

		byte[] bb = uploadedFileIndirectTests_3.getContents();

		indirectTests.setPeripehral_blood_smear(bb);

		updateIndirectTests();
	}

	public UploadedFile getUploadedFileIndirectTests_3() {
		return uploadedFileIndirectTests_3;
	}

	public void setUploadedFileIndirectTests_3(UploadedFile uploadedFileIndirectTests_3) {
		this.uploadedFileIndirectTests_3 = uploadedFileIndirectTests_3;
	}

	// ********************************
	public void setIndirectTests(IndirectTests indirectTests) {
		this.indirectTests = indirectTests;
	}

	public void setIronBalance(IronBalance car) {
		ironBalance = car;
	}

	public void prova(javax.faces.event.AjaxBehaviorEvent event) throws javax.faces.event.AbortProcessingException {

		this.indirectTests = (IndirectTests) event.getComponent().getAttributes().get("test");
	}

	public List<PersonalData> getCustomPazienti() {
		return customPazienti;
	}

	public void setCustomPazienti(List<PersonalData> customPazienti) {
		this.customPazienti = customPazienti;
	}

	public Query getCurrentQuery() {
		return currentQuery;
	}

	public void setCurrentQuery(Query currentQuery) {
		this.currentQuery = currentQuery;
	}

	// public void onCellSurgicalEdit(CellEditEvent event) {
	// Object oldValue = event.getOldValue();
	// Object newValue = event.getNewValue();
	// System.out.println(oldValue);System.out.println(newValue);
	// if (newValue != null && !newValue.equals(oldValue)) {
	// FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell
	// Changed",
	// "Old: " + oldValue + ", New:" + newValue);
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }
	// }
	public String goModificaOtherInfo() {
		return "modifica_otherinfo";
	}

	public void setGeneticData(GeneticData geneticData) {
		this.geneticData = geneticData;
	}
	
	public void modificaGeneticData() {
		GeneticDataDAO dao = new GeneticDataDAO();
		dao.update(geneticData);
	}
	public void eliminaGeneticData() {
		GeneticDataDAO dao = new GeneticDataDAO();
		dao.delete(geneticData);
	}
}
