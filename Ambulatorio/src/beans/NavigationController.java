package beans;

import java.io.Serializable;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

public class NavigationController implements Serializable {
	// this managed property will read value from request parameter pageId

	/**
	 * 
	 */
	private static final long serialVersionUID = 2506673480537598364L;

	private String pageId;

	public String showPage() {
		System.out.println("pageid2= " + pageId);
		if (pageId == null) {
			return "home";
		}
		//
		if (pageId.equals("1")) {
			return "schedaPaziente";
		} else if (pageId.equals("home")) {
			return "elenco";
		} else {
			return "home";
		}
	}

	public String goToScheda() {
		return "schedaPaziente";
	}

	public String nuovoPaziente() {
		NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
		nh.handleNavigation(FacesContext.getCurrentInstance(), null, "nuovo");
		FacesContext.getCurrentInstance().renderResponse();
		return null;
	}

	public String goToHome() {
		System.out.println("kk");
		return "elenco";
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public void navigate(String rule) {
		System.out.println("navigate: "+rule);
		JsfUtil.redirect(rule);
	}

}
