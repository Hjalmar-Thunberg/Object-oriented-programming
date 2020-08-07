public class Farmer {

	private String farmerName;				// encapsulate our class-attributes from the public use

	Farmer(String name) {					// constructor to create a farmer-object

		this.farmerName = name;
	}

	public String getFarmerName() {			// method for the public to see our private variable without a direct access

		return this.farmerName;
	}

	public void feed(int food, Animal animal) {
											// main method for feed-function (composite)
		System.out.println("\n" + food + "kg of food given to a " + animal.getAnimalType() + " (" + 
			animal.getAnimalName() + ") that is " + animal.getAnimalWeight() + "kg\nand has a " +
				"hunger level of " + animal.getAnimalHunger() + " increased its weight to");
		
		animal.setWeight(food);				// calls on the component in Animal-class
		animal.setHunger(food);
	}
}