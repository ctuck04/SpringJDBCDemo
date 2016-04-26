package data;

public class Assignments {

	private int assignment_date;
	private String name;
	private String start_date;
	private String end_date;
	private int employee_id;
	private int project_id;
	
	public Assignments(int assignment_date, String name, String start_date, String end_date, int employee_id, int project_id) {
		super();
		this.assignment_date = assignment_date;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.project_id = project_id;
	}
	
	public int getAssignment_date() {
		return assignment_date;
	}
	public void setAssignment_date(int assignment_date) {
		this.assignment_date = assignment_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

}
