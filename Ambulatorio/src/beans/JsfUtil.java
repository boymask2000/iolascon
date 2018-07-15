package beans;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

public class JsfUtil {
	public static void redirect(String rule) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		NavigationHandler nh = ctx.getApplication().getNavigationHandler();
		nh.handleNavigation(ctx, null, rule);
		ctx.renderResponse();
	}
}
