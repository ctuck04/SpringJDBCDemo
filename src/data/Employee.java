package data;

public class Employee {
	
	private String firstName;
	private String lastName;
	private int Id;
	private int dept_id;
	private int job_id;
	
	public Employee(int id, String firstName, String lastName, int dept_id, int job_id) {
		super();
		this.Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept_id = dept_id;
		this.job_id = job_id;
	}
	
	public Employee(String firstName, String lastName, int dept_id, int job_id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept_id = dept_id;
		this.job_id = job_id;
	}
	
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", dept_id=" + dept_id + ", " + "job_id=" + job_id + "]";
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	
}
