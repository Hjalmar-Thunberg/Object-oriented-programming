// Promotion method argument: 
// We don't see any big problem with changing employee type the way we've done below.
// It feels very intuitive, and doesn't seem to bring any major disadvantages
// that inheritance generally might bring. It's not "pretty", but also not that ugly.

// The worst we noticed with this method is that if the employee currently getting promoted
// is ex. a manager and is promoted to a director we have to assign a value for degree again.
// For this we could make a work-around by creating more methods and have if-states but that
// would require more methods and code.

import java.util.ArrayList;

public class ReusaxCorp {
	
	private ArrayList<Employee> employees = new ArrayList<>();	// declaring a reference arraylist and specifying a generic type (Employee)
	private static int directorBonus = 5000;					// a attribute which is used in the calculation for ALL directors salary, set to static because of this

	public void hireEmployee(String name, String id, double salary) {
		Employee employee = new Employee(name, id, salary);		// declaring a reference of type Employee, creating a new Employee object and assigning them together
		employees.add(employee);								// adding our object to our declared arraylist
	}
	
	public void hireManager(String name, String id, double salary, String degree) {
		Employee employee = new Manager(name, id, salary, degree);
		employees.add(employee);
	}
	
	public void hireDirector(String name, String id, double salary, String degree, String department) {
		Employee employee = new Director(name, id, salary, degree, department);
		employees.add(employee);
	}
	
	public void hireIntern(String name, String id, double salary, int gpa) {
		Employee employee = new Intern(name, id, salary, gpa);
		employees.add(employee);
	}

	public Employee findEmployee(String ID) {					// method for searching through our arraylist for our referenced employees
		for (int i = 0; i < employees.size(); i++) {			// by comparing IDs with what the user inputed
			if (employees.get(i).getId().equals(ID)) {
				return employees.get(i);						// will return a employee if any match is made, otherwise nothing
			}
		}
		return null;
	}

	public void updateName(String ID, String newName) {			// uses the method for searching employees and changes the attribute value for the selected object
		findEmployee(ID).setName(newName);
	}

	public void updateSalary(String ID, double newSalary) {
		findEmployee(ID).setGrossSalary(newSalary);
	}
	
	public void updateDegree(String ID, String newDegree) {
		Manager temp = (Manager)findEmployee(ID);				// downcasts the selected object to a Manager type so we can access and 
		temp.setDegree(newDegree);								// change the saved attribute which doesn't exist in Employee class
	}

	public void updateGpa(String ID, int newGpa) {
		Intern temp = (Intern)findEmployee(ID);
		temp.setGpa(newGpa);
	}
	
	public void removeEmployee(String ID) {	
		employees.remove(findEmployee(ID));
	}
	
	public static int getDirectorBonus() {
		return directorBonus;
	}

	public void setDirectorBonus(int bonus) {
		directorBonus = bonus;
	}
	
	public int totalGross() {									// method for summing all the stored gross salarys from ALL of our employees
		int totalGross = 0;
		for (int i = 0; i < employees.size(); i++) {
			totalGross += employees.get(i).getGrossSalary();
		}
		return totalGross;
	}
	
	public int totalNet() {
		int totalNet = 0;
		for (int i = 0; i < employees.size(); i++) {
			totalNet += employees.get(i).getNetSalary();
		}
		return totalNet;
	}
	
	public int totalEmployees() {
		return employees.size();
	}

	public void promoteToManager(String ID, String degree) {	// following 4 methods are for changing the type of our object
		Employee employee = findEmployee(ID);					// we copy the selected employee into a new object
		employee = new Manager(employee.getName(), employee.getId(), employee.grossSalary, degree);
																// and then fill in the missing attributes
		employees.remove(findEmployee(ID));
		employees.add(employee);
	}

	public void promoteToDirector(String ID, String degree, String department) {
		Employee employee = findEmployee(ID);
		employee = new Director(employee.getName(), employee.getId(), employee.grossSalary, degree, department);

		employees.remove(findEmployee(ID));
		employees.add(employee);
	}

	public void promoteToIntern(String ID, int GPA) {
		Employee employee = findEmployee(ID);
		employee = new Intern(employee.getName(), employee.getId(), employee.grossSalary, GPA);

		employees.remove(findEmployee(ID));
		employees.add(employee);
	}

	public void promoteToEmployee(String ID) {
		Employee employee = findEmployee(ID);
		employee = new Employee(employee.getName(), employee.getId(), employee.grossSalary);

		employees.remove(findEmployee(ID));
		employees.add(employee);
	}
}
