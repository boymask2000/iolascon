package beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import javax.faces.event.ComponentSystemEvent;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class BasicDocumentViewController implements Serializable {
	
	private File pdf=new File("/home/giovanni/Desktop/pippo.pdf");
	  
    private static final long serialVersionUID = 1L;  
  
    private StreamedContent content;  
    
    private String contentUrl;
  
    public void onPrerender(ComponentSystemEvent event) {  
  
        try {   
        	pdf=new File("/home/giovanni/Desktop/pippo.pdf");
        	contentUrl=pdf.toURI().toURL().toString();
            content = new DefaultStreamedContent(new FileInputStream(pdf), "application/pdf");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public StreamedContent getContent() {  
        return content;  
    }  
  
    public void setContent(StreamedContent content) {  
        this.content = content;  
    }

	public File getPdf() {
		return pdf;
	}

	public void setPdf(File pdf) {
		this.pdf = pdf;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}  
} 