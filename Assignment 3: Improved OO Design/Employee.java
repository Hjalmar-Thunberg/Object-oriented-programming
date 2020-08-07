public class Employee {

	private String name;
	private String id;
	protected double grossSalary;									// set to protected so we can access and use the base gross salary
	private double netSalary;

	public Employee(String name, String id, double grossSalary) {	// constructor to create a Employee object, all the following attributes are mandatory
		this.name = name;				
		this.id = id;
		this.grossSalary = grossSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getNetSalary() {
		return grossSalary - (grossSalary * 0.1);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {								// generated hashcode and equals for the attribute ID so the same IDs makes the objects equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {										// generated and slightly modified toString for easier debugging
		return "Employee [name=" + name + ", id=" + id + ", grossSalary=" + getGrossSalary() + ", netSalary=" + netSalary
				+ "]";
	}

//	public String toString() {										// a more end-user friendly toString
//		return "ID " + id + " belongs to " + name + " who is an employee at ReusaxCorp.\n" 
//				+ name + "'s" + "gross salary is " + grossSalary + " SEK and net salary is " + netSalary + " SEK.";
//	}
}