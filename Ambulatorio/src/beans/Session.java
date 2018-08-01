package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
	private int id;
	private String user;
	private Date startDate;
	private Date endDate;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;

		// System.out.println(toString());
	}

	public String getExtval(Date d) {
		if (d == null)
			return "";
		String pattern = "MM/dd/yyyy  HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(d);

	}

	public String getEndDateExt() {
		return getExtval(endDate);
	}

	public String getStartDateExt() {
		return getExtval(startDate);
	}

	@Override
	public String toString() {
		return "Session [user=" + user + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDurata() {
		if (startDate == null || endDate == null)
			return "";
		long end = endDate.getTime();
		long start = startDate.getTime();
		long diff = (end - start) / 1000;

		String out = "";
		if (diff / 3600 > 0) {
			out += (diff / 3600);
			diff = diff - (diff / 3600) * 3600;
		} else
			out = "0";
		out += ":";
		if (diff / 60 > 0) {

			out += (diff / 60);
			diff = diff - (diff / 60) * 60;
		} else
			out += "0";

		out += ":";
		out += diff;
		return out;
	}
}
