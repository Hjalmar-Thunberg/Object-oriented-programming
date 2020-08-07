public class Manager extends Employee { 		// inheriting ALL methods and attributes from the Employee class
	
	private String degree;

	public Manager(String name, String id, double grossSalary, String degree) {
		super(name, id, grossSalary);			// using the Employee constructor to store the attributes that we inherited 
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public double getGrossSalary() {			// overriding the method inherited from Employee for our separated
		if (degree.equalsIgnoreCase("bsc")) {	// calculation of the Manager gross salary. By returning a value we 
			return super.grossSalary * 1.1;		// never override the base gross salary the user inputed
		}
		else if (degree.equalsIgnoreCase("msc")) {
			return super.grossSalary * 1.2;
		}
		else if (degree.equalsIgnoreCase("phd")) {
			return super.grossSalary * 1.35;
		}
		return super.grossSalary;
	}
	
	@Override
	public double getNetSalary() {				// overriding another method for a separated calculation of the net salary
		return getGrossSalary() - (getGrossSalary() * 0.1);
	}

	@Override
	public String toString() {					// overriding the toString in Employee so we also can print Manager stored attributes
		return "Manager [degree=" + degree + ", grossSalary=" + grossSalary + ", getGrossSalary()=" + getGrossSalary()
				+ ", getNetSalary()=" + getNetSalary() + ", getName()=" + getName() + ", getId()=" + getId() + "]";
	}
	
//	@Override
//	public String toString() {
//		return "ID " + getId() + " belongs to " + getName() + " who is a manager with a degree of " + degree + ".\n" 
//				+ getName() + "'s" + "gross salary is " + getGrossSalary() + " SEK and net salary is " + getNetSalary() + " SEK.";
//	}
}
