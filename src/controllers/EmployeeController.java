package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.AssignmentDao;
import data.Employee;
import data.EmployeeDao;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	//private AssignmentDao assignmentDao;
	
	
	@RequestMapping(path="GetEmployeeById.do", params="id", method=RequestMethod.GET )
	public ModelAndView getEmployeeById(int id) {
		Employee emp = employeeDao.getEmpByID(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("employee", emp);
		return mv;
	}
	
	@RequestMapping(path="GetEmployeeById2.do", params="id", method=RequestMethod.GET )
	public ModelAndView getEmployeeById2(int id) {
		Employee emp = employeeDao.getEmpByID(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result2.jsp");
		mv.addObject("employee", emp);
		return mv;
	}
	
	
	@RequestMapping("GetEmpByLastName.do")
	public ModelAndView getEmployeeByLastName(String input) {
		Employee emp = employeeDao.getEmpByLastName(input);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("employee", emp);
		return mv;
	}
	
	@RequestMapping(path="insertEmp.do",
			        params={"firstName", "lastName", "deptId","jobId"},
			        method=RequestMethod.POST)
	public ModelAndView insertEmp(String firstName, String lastName, int deptId, int jobId) {
		Employee emp = new Employee(firstName, lastName, deptId, jobId);
		//System.out.println(emp);
		employeeDao.insertEmp(emp);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insertTest.jsp");
		mv.addObject("employee", emp);
		return mv;
		
	}
	
	@RequestMapping(path="deleteEmployee.do", method=RequestMethod.POST)
	public ModelAndView deleteEmployee (int id, String firstName, String lastName, int dept_id, int job_id) {
		
		Employee emp = new Employee(id, firstName, lastName, dept_id, job_id);

		//assignmentDao.deleteEmployee(emp);
		employeeDao.deleteEmployee(emp);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.html");
		mv.addObject("remove", emp);
		return mv;
		
	}
	
	
	
	
	
	@RequestMapping(path="insertEmp.do", 
			params="param", 
			method=RequestMethod.POST)
	public ModelAndView getEmployeeById(String param) {
		List<List<String>> results = employeeDao.getQueryResults(param);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insertTable.jsp");
		mv.addObject("results", results);
		mv.addObject("headers", employeeDao.getHeaders(param));
		return mv;
	}
	
//	@RequestMapping(path="updateEmployee.do", params={"firstName","lastName", "dept_id", "job_id"}, 
//			method=RequestMethod.GET)
//	public ModelAndView updateEmployeeGet(String firstName, String lastName, int dept_id, int job_id) {
//		ModelAndView mv = new ModelAndView();
//		
//		Employee emp = new Employee(firstName, lastName, dept_id, job_id);
//		
//		mv.setViewName("index.html");
//		mv.addObject("id", emp.getId());
//		mv.addObject("fn", emp.getFirstName());
//		mv.addObject("ln", emp.getLastName());
//		mv.addObject("d_did", emp.getDept_id());
//		mv.addObject("j_id", emp.getJob_id());
//		return mv;
//	}
	
	@RequestMapping(path="updateEmployee.do", params={"id", "firstName","lastName", "dept_id", "job_id"}, 
			method=RequestMethod.GET)
	public ModelAndView updateEmployeePost(int id, String firstName, String lastName, int dept_id, int job_id) {
		ModelAndView mv = new ModelAndView();
		Employee emp = new Employee(id, firstName, lastName, dept_id, job_id);
		System.out.println(emp);
		employeeDao.updateEmployee(emp);
		mv.setViewName("index.html");
		mv.addObject("edit", emp);
		return mv;
	}

}
