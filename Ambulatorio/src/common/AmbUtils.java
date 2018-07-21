package common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public static List<Pair> caricaCampi(Object bean, boolean all) {
		List<Pair> lista = new ArrayList<Pair>();
		try {
			Field[] ll = bean.getClass().getDeclaredFields();
			for (Field f : ll) {
				String name = f.getName();
				String type = f.getType().getName();
if(!all) {
				if (name.equals("id"))
					continue;
				if (name.equals("n"))
					continue;
}
				if (!type.equals("int") && !type.equals("java.lang.String") && !type.equals("java.util.Date"))
					continue;

				String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
				Method meth = bean.getClass().getDeclaredMethod(methodName, null);
				System.out.println(meth.getName());
				Object val = meth.invoke(bean, null);
				System.out.println(val);
				if (val == null)
					val = "";
				if (val instanceof Date)
					val = AmbUtils.formatDate((Date) val);
				lista.add(new Pair(name, val, type));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}
}
