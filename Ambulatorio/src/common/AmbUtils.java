package common;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;

public class AmbUtils {
	public static String formatDate(Date d) {
		if(d==null)return "";
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(d);
	}
	public static String convertToBase64( byte b[]) {
		Base64 codec = new Base64();
		byte[] encoded = codec.encode(b);
		return new String(encoded);   // Outputs "SGVsbG8="
	}
}
