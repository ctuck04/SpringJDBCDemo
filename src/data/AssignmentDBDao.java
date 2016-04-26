package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AssignmentDBDao implements AssignmentDao {
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/companydb";
		
		
		@Override
		public int deleteAssignment(int emp_id) {
			int affected = 0;
			try {
				Class.forName(DRIVER_CLASS_NAME);
				Connection conn = DriverManager.getConnection(URL, "student", "student");
				PreparedStatement stmt = conn.prepareStatement("DELETE from assignments where employee_id=?");
				//System.out.println(stmt);
				//stmt.setString(1, emp.getId());
				stmt.setInt(1, emp_id);
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
	

}
