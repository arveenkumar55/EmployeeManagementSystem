package application.model;

import java.util.ArrayList;
import java.util.List;

public class SystemContoller {
	public Admin admin;
	public Account account;
	public Manager manager;
	public Project project;
	public Attendence attendence;
	public SimpleEmployee employee;
	//static int counter;
    static SystemContoller SystemController=new SystemContoller();
	
    public static SystemContoller getInstance()
    {
    	return SystemController;
    }
    
    
	private SystemContoller() {
		super();
		admin = new Admin();
		account = new Account();
		manager = new Manager();
		project = new Project();
		attendence=new Attendence();
		employee=new SimpleEmployee();
	}
	
	public void ViewProfile(Employee emp)
	{
		emp.viewProfile();
	}
	public void createEmployee(Employee emp)
	{
		//Admin admin=new Admin();
		admin.createAccount(emp);
	}
	public void update(Employee emp)
	{
		//Admin admin=new Admin();
		admin.UpdateAccount(emp);
		
		
	}
	public boolean deleteEmployee(String string) {
	
		//Admin admin=new Admin();
		boolean flag=admin.deleteAccount(string);
		return flag;  
		
	}
	public boolean ChangePassword(String emp_id, String c_Password, String n_Password) {
		// TODO Auto-generated method stub
		//Account account=new Account();
		System.out.println("in controller is "+emp_id);
		boolean flag=account.ChangePassword(emp_id,c_Password,n_Password);
		return flag;
	}

	public boolean addProject(String emp_id, Project project) {
		// TODO Auto-generated method stub
		boolean flag=false;
		//Manager manager=new Manager();
		flag=manager.addProject(emp_id, project);
		return flag;
	}
	public List<String> getProject(String emp_id) {
		// TODO Auto-generated method stub
		//Project project=new Project();
	
		return project.getproject(emp_id);
	}
	public boolean assignProject(Team team, String selected_PID, String duedate, String startDate,String emp_id) {
		// TODO Auto-generated method stub
		//Manager manager=new Manager();
		return manager.ProjectAssign(team,selected_PID, duedate,startDate,emp_id);
	}
	public List<String> calculate(String emp_id, String string) {
		// TODO Auto-generated method stub
		//Project project=new Project();
		return project.calculate(emp_id,string);
	}


	public boolean isExistAccount(String name, String password) {
		// TODO Auto-generated method stub
		return account.isExistAccount(name, password);
	}
	public void markAttendence(String id)
	{
		attendence.markAttendence(id);
	}


	public List<Double> viewAttendence(String emp_id) {
		// TODO Auto-generated method stub
		return attendence.view_Attendence(emp_id);
		
	}

}
