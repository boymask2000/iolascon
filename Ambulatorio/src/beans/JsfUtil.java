package beans;

import java.util.Date;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

public class JsfUtil {
	public static void redirect(String rule) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		NavigationHandler nh = ctx.getApplication().getNavigationHandler();
		nh.handleNavigation(ctx, null, rule);
		ctx.renderResponse();
	}
	public static Date fixDate( Date date) {
		date.setTime(date.getTime() - (date.getTimezoneOffset() * 60 * 1000));
		return date;
	}
	
}
