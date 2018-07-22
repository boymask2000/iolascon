package beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import excelimport.ExcelParser;

public class FileUploadView {

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	private UploadedFile uploadedFile;

	public void fileUploadListener(FileUploadEvent event) {
		uploadedFile = event.getFile();
		try {
			ExcelParser parser = new ExcelParser(uploadedFile.getFileName(), uploadedFile.getInputstream());
			parser.process();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println(uploadedFile);
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
}