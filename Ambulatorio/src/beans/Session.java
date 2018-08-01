package beans;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		
	//	System.out.println(toString());
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

}
