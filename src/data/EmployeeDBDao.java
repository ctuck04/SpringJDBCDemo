package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDBDao implements EmployeeDao {
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/companydb";
	
	
	@Override
	public Employee getEmpByID(int input) {
		Employee emp = null;
		String sql = "select id, firstname, lastname, department_id, job_id from employees where id = " + input;
		System.out.println(sql);
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int dept_Id = rs.getInt(4);
				int job_Id = rs.getInt(5);
			
				emp = new Employee(id, firstName, lastName, dept_Id, job_Id);
				System.out.println(emp);
			}
			
			
			rs.close();
			statement.close();
			conn.close();
		
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println(emp);
		return emp;
	}
	
	@Override
	public Employee getEmpByLastName(String input) {
		Employee emp = null;
		String sql = "select firstname, lastname from employees where lastname = '" + input + "'";
		System.out.println(sql);
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				emp = new Employee(firstName, lastName);			
			}
			
			
			rs.close();
			statement.close();
			conn.close();
		
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println(emp);
		return emp;
	}
	
	@Override
	public Employee insertEmp (Employee emp) {
		//Employee emp = null;
		String sql = "INSERT INTO employees( firstname, lastname, department_id, job_id ) " + 
                "VALUES ( '" + emp.getFirstName() + "', '" + emp.getLastName() + "', " + emp.getDept_id() + ", " + emp.getDept_id() + " )";
		
		//System.out.println(sql);
		
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			int updateCount = statement.executeUpdate(sql);
			
			
			//emp = new Employee(firstName, lastName, deptId, jobId);
			

			
			
			statement.close();
			conn.close();
		} 
		
		catch (Exception e) {
			System.err.println(e);
		  }
		
		//System.out.println(emp);
		return emp;
	
	}
	
	@Override
	public List<List<String>> getQueryResults(String sql) {
		List<List<String>> results = new ArrayList<List<String>>();
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				for (int i = 1; i < columnCount; i++) {
					row.add(rs.getString(i));
				}
				results.add(row);
			}

			rs.close();
			statement.close();
			conn.close();

		} 
		
		catch (Exception e) {
			System.err.println(e);
		}
		//System.out.println(results);
		return results;
	}
	
	@Override
	public List<String> getHeaders(String sql){
		List<String> headers = new ArrayList<String>();
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			for (int i = 1; i <= columnCount; i++) {
				headers.add(rsmd.getColumnName(i));
			}

			rs.close();
			statement.close();
			conn.close();

		} 
		
		catch (Exception e) {
			System.err.println(e);
		}
		//System.out.println(results);
		return headers;
	}
	
	@Override
	public int deleteEmployee(Employee emp) {
		int affected = 0;
		try {
			AssignmentDBDao assignDao = new AssignmentDBDao();
			assignDao.deleteAssignment(emp.getId());
			
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			PreparedStatement stmt = conn.prepareStatement("DELETE from employees where id=?");
			//System.out.println(stmt);
			//stmt.setString(1, emp.getId());
			stmt.setInt(1, emp.getId());
			//stmt.setString(2, emp.getFirstName());
			//stmt.setString(3, emp.getLastName());
			//stmt.setInt(4, emp.getJob_id());
			//stmt.setInt(5, emp.getDept_id());
			
			affected = stmt.executeUpdate();

			stmt.close();
			conn.close();
			//affected = aff;
		}
		
		catch (Exception e) {
			System.err.println(e);
		}
		//return affected;
		//System.out.println(affected);
		return affected;
	}
	
	public int updateEmployee(Employee emp) {
		int affected = 0;
		try {
			//AssignmentDBDao assignDao = new AssignmentDBDao();
			//assignDao.updateAssignment(emp.getId());
			
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			PreparedStatement stmt = conn.prepareStatement("UPDATE employees set firstname=?, lastname=?, department_id=?, job_id=? where id =?");
			//System.out.println(stmt);
			//stmt.setString(1, emp.getId());
			stmt.setString(1, emp.getFirstName());
			stmt.setString(2, emp.getLastName());
			stmt.setInt(3, emp.getDept_id());
			stmt.setInt(4, emp.getJob_id());
			stmt.setInt(5, emp.getId());
			
			affected = stmt.executeUpdate();

			stmt.close();
			conn.close();
			//affected = aff;
		}
		
		
		catch (Exception e) {
			System.err.println(e);
		}
		//return affected;
		//System.out.println(affected);
		return affected;
	
	}


}
