package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String formatDate(Date d) {
		if(d==null)return "";
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(d);
	}
}
