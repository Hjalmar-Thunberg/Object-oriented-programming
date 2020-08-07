public class Director extends Manager {		// inheriting ALL methods and attributes from the Manager class (also Employee)

	private String department;
	
	public Director(String name, String id, double grossSalary, String degree, String department) {
		super(name, id, grossSalary, degree);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public double getGrossSalary() {
		if (getDegree().equalsIgnoreCase("bsc")) {
			return (super.grossSalary * 1.1) + ReusaxCorp.getDirectorBonus();
		}
		else if (getDegree().equalsIgnoreCase("msc")) {
			return (super.grossSalary * 1.2) + ReusaxCorp.getDirectorBonus();
		}
		else if (getDegree().equalsIgnoreCase("phd")) {
			return (super.grossSalary * 1.35) + ReusaxCorp.getDirectorBonus();
		}
		return super.grossSalary + ReusaxCorp.getDirectorBonus();
	} 

	@Override
	public double getNetSalary() {
		if (getGrossSalary() < 30000) {
			return getGrossSalary() - (getGrossSalary() * 0.1);
		}
		else if (getGrossSalary() < 50000) {
			return getGrossSalary() - (getGrossSalary() * 0.2);
		}
		return getGrossSalary() - (((getGrossSalary() - 30000) * 0.4) + (30000 * 0.2));
	}

	@Override
	public String toString() {
		return "Director [department=" + department + ", grossSalary=" + grossSalary + ", getGrossSalary()="
				+ getGrossSalary() + ", getNetSalary()=" + getNetSalary() + ", getDegree()=" + getDegree()
				+ ", getName()=" + getName() + ", getId()=" + getId() + "]";
	}
	
//	@Override
//	public String toString() {
//		return "ID " + getId() + " belongs to " + getName() + " who is a director with a degree of " + getDegree() + " within department " + department + ".\n" 
//				+ getName() + "'s" + "gross salary is " + getGrossSalary() + " SEK and net salary is " + getNetSalary() + " SEK.";
//	}
}
