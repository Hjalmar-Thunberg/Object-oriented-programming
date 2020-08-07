import java.util.Scanner;

public class CorpMain {			// our interface for our corp, was mostly used to test so all our methods and algorithms worked
	
	Scanner myscan = new Scanner(System.in);
	ReusaxCorp reusaxcorp = new ReusaxCorp();

	public String readString(String stringToPrint) {
		System.out.println(stringToPrint);
		String string = myscan.nextLine();
		return string;
	}

	public Double readDouble(String stringToPrint) {
		System.out.println(stringToPrint);
		Double ddouble = myscan.nextDouble();
		myscan.nextLine();
		return ddouble;
	}

	public int readIntNumber(String userMessage) {
		System.out.print(userMessage);
		int intNumber = myscan.nextInt();
		myscan.nextLine();
		return intNumber;
	}

	public void hireEmployee() {
		int choice = readIntNumber("Register: " + "\n" + "1. Employee" + "\n" + "2. Intern" + "\n" + "3. Manager" + "\n"
				+ "4. Director");

		String name = readString("Enter name of employee");
		String ID = readString("Enter ID of employee");
		Double salary = readDouble("Enter salary of employee");

		switch (choice) {

		case 1:
			reusaxcorp.hireEmployee(name, ID, salary);
			break;

		case 2:
			int gpa = readIntNumber("Enter GPA of employee");
			reusaxcorp.hireIntern(name, ID, salary, gpa);
			break;

		case 3:
			String degree1 = readString("Enter degree of employee");
			reusaxcorp.hireManager(name, ID, salary, degree1);
			break;
			
		case 4:
			String degree2 = readString("Enter degree of employee");
			String department = readString("Enter department of employee");
			reusaxcorp.hireDirector(name, ID, salary, degree2, department);
			break;

		default:
			System.out.println("LOL XDD");
			break;
		}
	}

	public void removeEmployee() {

		String ID = readString("Type the ID of the employee you want to fire");

		reusaxcorp.removeEmployee(ID);

	}

	public void findEmployee() {

		String ID = readString("Enter the ID of the employee you search for");

		if (reusaxcorp.findEmployee(ID) == null) {
			System.out.println("***This is not a valid ID***");
		} else {
			System.out.println(reusaxcorp.findEmployee(ID));
		}
	}

	public void updateName() {

		String ID = readString("Enter ID:");
		String newName = readString("Enter new name");

		reusaxcorp.updateName(ID, newName);
	}

	public void updateSalary() {

		String ID = readString("Enter ID:");
		Double newSalary = readDouble("Enter new salary");

		reusaxcorp.updateSalary(ID, newSalary);
	}

	public void promoteToManager() {

		String ID = readString("Enter employee ID");
		String degree = readString("Enter employee degree");

		reusaxcorp.promoteToManager(ID, degree);
	}

	public void promoteToDirector() {

		String ID = readString("Enter employee ID");
		String degree = readString("Enter employee degree");
		String department = readString("Enter department");

		reusaxcorp.promoteToDirector(ID, degree, department);
	}

	public void promoteToIntern() {

		String ID = readString("Enter employee ID");
		int GPA = readIntNumber("Enter GPA");

		reusaxcorp.promoteToIntern(ID, GPA);
	}

	public void promoteToEmployee() {

		String ID = readString("Enter employee ID");

		reusaxcorp.promoteToEmployee(ID);
	}

	public void updateDegree() {

		String ID = readString("Enter ID");
		String newDegree = readString("Enter new degree");

		reusaxcorp.updateDegree(ID, newDegree);
	}

	public void updateGPA() {

		String ID = readString("Enter ID");
		int newGpa = readIntNumber("Enter new GPA");

		reusaxcorp.updateGpa(ID, newGpa);
	}

	public void promote() {

		System.out.println("Promote to: " + "\n" + "1. Intern" + "\n" + "2. Employee" + "\n" + "3. Director" + "\n"
				+ "4. Manager");

		int option = readIntNumber("Enter number corresponding to the options below");

		switch (option) {

		case 1:
			promoteToIntern();
			break;

		case 2:
			promoteToEmployee();
			break;

		case 3:
			promoteToDirector();
			break;

		case 4:
			promoteToManager();
			break;
		}
	}
	
	public void directorBonus() {
		int bonus = readIntNumber("Enter director bonus");
		reusaxcorp.setDirectorBonus(bonus);
	}
	
	public void totalGross() {
		System.out.println("Total gross of the company is: " + reusaxcorp.totalGross());
	}
	
	public void totalNet() {
		System.out.println("Total net of the company is: " + reusaxcorp.totalNet());
	}
	
	public void totalEmployees() {
		System.out.println("Total employees of the company is: " + reusaxcorp.totalEmployees());
	}
	
	public void run() {

		int option;

		do {
			System.out.println("Choose and option by entering the corresponding number" + "\n" + "1. Register employee"
					+ "\n" + "2. Search for employee" + "\n" + "3. Remove employee" + "\n" + "4. Change employee name"
					+ "\n" + "5. Change employee salary" + "\n" + "6. Update degree" + "\n" + "7. Update GPA" + "\n" + "8. Promote employee"
					+ "\n" + "9. Change director bonus" + "\n" + "10. Total gross" + "\n" + "11. Total net" + "\n" + "12. Total Employees");
			option = myscan.nextInt();
			myscan.nextLine();

			switch (option) {

			case 1:
				hireEmployee();
				break;

			case 2:
				findEmployee();
				break;

			case 3:
				removeEmployee();
				break;

			case 4:
				updateName();
				break;

			case 5:
				updateSalary();
				break;

			case 6:
				updateDegree();
				break;
				
			case 7:
				updateGPA();
				break;
				
			case 8:
				promote();
				break;
			case 9:
				directorBonus();
				break;
			case 10:
				totalGross();
				break;
			case 11:
				totalNet();
				break;
			case 12:
				totalEmployees();
				break;
			}

		} while (option != 0);

	}

	public static void main(String[] args) {

		CorpMain program = new CorpMain();
		program.run();
	}
}

