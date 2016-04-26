package data;

import java.util.List;

public interface EmployeeDao {
	
	public Employee getEmpByID(int id);
	public Employee getEmpByLastName(String lastName);
	public Employee insertEmp (Employee emp);
	public int deleteEmployee(Employee emp);
	public int updateEmployee(Employee emp);
	public List<List<String>> getQueryResults(String sql);
	public List<String> getHeaders(String sql);


}
