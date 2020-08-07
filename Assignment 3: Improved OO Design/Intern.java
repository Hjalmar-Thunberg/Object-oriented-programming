public class Intern extends Employee {		// inheriting ALL methods and attributes from the Manager class (also Employee)
	
	private int gpa;

	public Intern(String name, String id, double grossSalary, int gpa) {
		super(name, id, grossSalary);
		this.gpa = gpa;
	}

	public int getGpa() {
		return gpa;
	}

	public void setGpa(int gpa) {
		this.gpa = gpa;
	}

	@Override
	public double getGrossSalary() {
		if (gpa <= 5) {
			return 0;
		}
		else if (gpa < 8) {
			return super.grossSalary;
		}
		return super.grossSalary + 1000;
	}

	@Override
	public double getNetSalary() {
		return getGrossSalary();
	}

	@Override
	public String toString() {
		return "Intern [gpa=" + gpa + ", grossSalary=" + grossSalary + ", getGrossSalary()=" + getGrossSalary()
				+ ", getNetSalary()=" + getNetSalary() + ", getName()=" + getName() + ", getId()=" + getId() + "]";
	}

//	@Override
//	public String toString() {
//		return "ID " + getId() + " belongs to " + getName() + " who is an intern with a GPA of " + gpa + ".\n" 
//				+ getName() + "'s" + "gross salary is " + getGrossSalary() + " SEK and net salary is " + getGrossSalary() + " SEK.";
//	}
}
