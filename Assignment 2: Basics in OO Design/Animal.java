public class Animal {

	private String name;					// encapsulate our class-attributes from the public use
	private String type;
	private double weight;
	private int age;
	private double hungerlvl = 1;
	private int price;
	private String health;

	public Animal(String name, String type, double weight, int age, double hungerlvl) {
											// constructor to create an Animal-object (with hungerlvl)
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.age = age;
		this.hungerlvl = hungerlvl/100;		// user inputs a number between 0-100, we store it as a decimal between 0-1

		if (this.hungerlvl > 1) {			// upper threshold for hungerlvl
			this.hungerlvl = 1;
		}
		if (this.hungerlvl < 0) {			// lower threshold for hungerlvl
			this.hungerlvl = 0;
		}
		if (this.weight < 1) {				// lower threshold for weight	
			this.weight = 1;	
		}
	}

	public Animal(String name, String type, double weight, int age) { 
											// constructor to create a Animal-object (without hungerlvl)
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.age = age;
		if (this.weight < 1) {				// lower threshold for weight	
		this.weight = 1;	
		}
	}
	
	public String getAnimalName() {			// method for the public to see our private variables without a direct access
		
		return this.name;
	}
	
	public double getAnimalWeight() {
		
		return this.weight;
	}
	
	public String getAnimalType() {
		
		return this.type;
	}
	
	public double getAnimalHunger() {
		
		return this.hungerlvl;
	}
	
	public String getAnimalHealth() {

		if (this.hungerlvl < 0.26) {

			health = "Good";
		} else if (this.hungerlvl < 0.75) {

			health = "Ok";
		} else {

			health = "Bad";
		}
		return health;
	}

	public int getAnimalPrice() {			// calculates the price depending on which type, weight and age

		if (this.type.equalsIgnoreCase("Chicken")) {
			price = 2;

		} else if (this.type.equalsIgnoreCase("Cow")) {
			price = 5;

		} else {
			price = 3;

		}
		price = ((int) (price * this.weight) - this.age);		// casting result to an int type

		if (price < 0) {

			price = 0;
		}
		return price;
	}

	public String printAnimalInfo() {		// method that returns animals full info as a string

		String result = "Name: " + name + "\n" + "Type: " + type + "\n" + "Weight: " + weight + " kg\n" + "Age: " +
				age + " years old\n" + "Hunger Level: " + (hungerlvl * 100) + "%\n" + "Health Status: " + 
					getAnimalHealth() + "\n" + "Price: " + getAnimalPrice() + "$\n";
		return result;
	}

	public void wander(double distance) {	// main method for wander-function

		if (distance < 0) {					// animal is not allowed to wander for a negative amount of laps
			System.out.println("\nError: animal " + this.name + " can not wander for negative laps.\n");

		} else if (hungerlvl + (0.1 * distance) > 1) {		// animal is not allowed to wander for more than it's hunger allows it

			System.out.println("\nError: animal " + this.name + " is too hungry. Ask the farmer to feed it before wandering off!\n");
		} else {

			this.hungerlvl = (this.hungerlvl + (0.1 * distance));	 // calculates animals new hungerlvl and
			this.weight = this.weight - distance;					// 	weight depending on how many laps
			
			if (this.weight < 1) {	
				this.weight = 1;	
			}
			System.out.println("\n"+ this.name + "s new hunger level is " + this.hungerlvl * 100  
					+ "% and it's weight is " + this.weight + "kg\n");
		}
	}

	public void setWeight(int food) {		// method for the public to change the value of weight without a direct access (component)

		this.weight = this.weight + (food / 2);
		System.out.print(this.weight + "kg and decreased hunger level to ");
	}

	public void setHunger(int food) {		// method for the public to change the value of hungerlvl without a direct access (component)

		this.hungerlvl = this.hungerlvl - (0.1 * food / 2);

		if (this.hungerlvl < 0) {
			this.hungerlvl = 0;
		}
		System.out.println(this.hungerlvl + "\n");
	}
}
