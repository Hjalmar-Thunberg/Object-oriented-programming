import java.util.Scanner;								// import scanner and array utility
import java.util.Arrays; 

public class FarmMain {

	private static final int ACQUIRE_ANIMAL = 1;		// declaring and assigning our encapsulated variables that cannot be changed
	private static final int PRINT_ANIMALS = 2;
	private static final int PRINT_CHEAPEST_ANIMAL = 3;
	private static final int PRINT_ANIMAL = 4;
	private static final int ANIMAL_WANDER = 5;
	private static final int HIRE_FARMER = 6;
	private static final int FEED_ANIMAL = 7;
	private static final int QUIT = 8;

	private Animal[] animals;							// declaring the array-references for our classes
	private Farmer[] farmers;
	private int acquiredAnimals = 0;
	private int hiredFarmers = 0;

	private Scanner input;								// declaring scanner function
	
	public FarmMain() { 								// initialize the size for our array-references, both starting at 5 
		
		final int INITIAL_BARN_SIZE = 5;
		this.animals = new Animal[INITIAL_BARN_SIZE]; 	// assigning size for animals-reference

		final int INITIAL_HOUSE_SIZE = 5;
		this.farmers = new Farmer[INITIAL_HOUSE_SIZE];	// assigning size for farmer-reference

		input = new Scanner(System.in);					// assigning scanner function
		
														// hardcoded objects for easier debugging
		//animals[0] = new Animal("Hjalmar", "Cow", 500, 13, 50);
		//animals[1] = new Animal("Simon", "Chicken", 8, 3, 0);
		//animals[2] = new Animal("Emil", "sheep", 23, 7, 100);
		//acquiredAnimals = 3;
	}

	public Animal retrieveAnimal(String animalName) { 	// method for searching after Animal objects by the name, will return 
														// the referenced object or null
		for (int i = 0; i < acquiredAnimals; i++) {		// loops through the amount of animals created
			if (animals[i] != null && animals[i].getAnimalName().equalsIgnoreCase(animalName)) {
				return animals[i];						// checks if the current (i) referenced array is not null and equaled (ignoring case)
			}											// is the same as the string the user wrote
		}
		return null;
	}
	
	public Farmer retrieveFarmer(String farmerName) { 	// -||-
		
		for (int i = 0; i < hiredFarmers; i++) {
			if (farmers[i] != null && farmers[i].getFarmerName().equalsIgnoreCase(farmerName)) {
				return farmers[i];
			}
		}
		return null;
	}

	public Animal createAnimal() { 						// method for creating an Animal object from what the user inputs

		System.out.print("Type in the following animal information below\n");
		String animalName = readName("Name: ");			// calls method readName to temporarily store what the user typed in
		String animalType = readName("Type: ");
		int animalAge = readIntNumber("Age: ");
		double animalWeight = readDoubleNumber("Weight: ");
		double animalHunger = readDoubleNumber("Hunger (1 for default): ");

		if (animalHunger == 1) {						// constructs an Animal object without a user specified hungerlvl
			animals[acquiredAnimals] = new Animal(animalName, animalType, animalWeight, animalAge);
		}else {											// constructs an Animal object with a user specified hungerlvl
		animals[acquiredAnimals] = new Animal(animalName, animalType, animalWeight, animalAge, animalHunger);
		}
		System.out.println();
		return animals[acquiredAnimals];
	}
	
	public Farmer createFarmer() {						// method for creating an Animal object from what the user inputs

		System.out.print("Type in the following farmer information below\n");
		String farmerName = readName("Name: ");			// calls method readName to temporarily store what the user typed in

		farmers[hiredFarmers] = new Farmer(farmerName);	//constructs a Farmer object

		System.out.println();
		return farmers[hiredFarmers];	
	}

	public void run() {									// main part of program, will stay here and call on other program
														// methods until the user exits
		int option;
		do {
			printMenuOptions();							// calls on method to output the menu for the user
			System.out.print("Type the option number: ");
			option = input.nextInt();
			input.nextLine();
			System.out.println();

			switch (option) {							// switch for all the different options user can input and a default failsafe
			
			case ACQUIRE_ANIMAL:
				if (animals.length == acquiredAnimals) {// if we have created a maximum number of array references for our objects
														// we will copy in the old one, create a twice as big and input the old again
					Animal[] temp = Arrays.copyOf(animals, acquiredAnimals*2);
					animals = temp;
				}
				createAnimal();
				acquiredAnimals = acquiredAnimals + 1;	// stores that the number of animals we have created, starting from 0
				break;

			case PRINT_ANIMALS:
				printAllAnimals();
				break;

			case PRINT_ANIMAL:
				printOneAnimal();
				break;

			case PRINT_CHEAPEST_ANIMAL:
				printCheapest();
				break;

			case ANIMAL_WANDER:
				wander();
				break;

			case HIRE_FARMER:
				if (farmers.length == hiredFarmers) {
					
					Farmer[] temp = Arrays.copyOf(farmers, hiredFarmers*2);
					farmers = temp;
				}
				createFarmer();
				hiredFarmers = hiredFarmers + 1;
				break;

			case FEED_ANIMAL:
				feed();
				break;

			case QUIT:
				System.out.println("Thank you for visiting our Barn. See you soon!");
				System.out.println();
				break;

			default:									// if the user inputs an invalid option, we output it
				System.out.println("Option " + option + " is not valid.");
				System.out.println();
				break;
			}
		} while (option != QUIT);						// if user picks option QUIT, we exit the loop
	}

	private void printMenuOptions() {
		
		System.out.println("=== Welcome to DIT042 Barn === ");
		System.out.println(" Choose an option below: ");
		System.out.println(" ");
		System.out.println(" 1. Acquire an animal. ");
		System.out.println(" 2. Print all animals. ");
		System.out.println(" 3. Print the cheapest animal's information. ");
		System.out.println(" 4. Print an animal's information. ");
		System.out.println(" 5. Make an animal wander ");
		System.out.println(" 6. Hire a farmer ");
		System.out.println(" 7. Feed an animal ");
		System.out.println(" 8. Quit this program. ");
		System.out.println();
	}

	public void printAllAnimals() {
		
		if (acquiredAnimals == 0) {
			System.out.println("***You have no animals in the barn!***\n");
		}else {
			
		for (int i = 0; i < acquiredAnimals; i++) {		// loops through all created animals and prints them out by calling a method for it
			System.out.println(animals[i].printAnimalInfo());
		}
		}
	}

	public void printOneAnimal() {
		
		if (acquiredAnimals == 0) {
			System.out.println("\n***You have no animals in the barn!***\n");
		}else {
														// uses method retrieveAnimal to see if it matches what user input
		String animalName = readName("Type in the name of the animal: ");
		Animal foundAnimal = retrieveAnimal(animalName);
		
		if (foundAnimal == null) {
			System.out.println("\n***This animal doesn't exist***\n");
			
		}else {
			
		System.out.println("\n" + foundAnimal.printAnimalInfo());
		}
		}
	}

	public void printCheapest() {

		if (acquiredAnimals == 0) {
			System.out.println("\n***You have no animals in the barn!***\n");
		}
		
		int temp = Integer.MAX_VALUE;					// declaring and assigning the HIGEST integer possible, we use this
		String cheapest = "";							// to force the first animal to be saved into int temp in the loop below.
														
		for (int i = 0; i < acquiredAnimals; i++) {		// Loops through all created animals
														// if current (i) object has a lower price than the saved temp, it will save
			if (animals[i].getAnimalPrice() < temp) {	// it to compare it with the next. Loop this until we have the cheapest stored

				temp = animals[i].getAnimalPrice();
				cheapest = animals[i].printAnimalInfo();
			}
		}
		System.out.println(cheapest);
	}

	public String readName(String userMessage) { 		// outputs the specified text when we called the method
		System.out.print(userMessage);					// and stores what the user inputs
		String name = input.nextLine();
		return name;
	}

	public int readIntNumber(String userMessage) { 		// -||-
		System.out.print(userMessage);
		int foodAmount = input.nextInt();
		input.nextLine();								// clears the input for when the user presses <ENTER>
		return foodAmount;
	}

	public double readDoubleNumber(String userMessage) {// -||-
		System.out.print(userMessage);
		double doubleNumber = input.nextDouble();
		input.nextLine();
		return doubleNumber;
	}
	
	public void wander() {		 						// method for making the animal wander, requires an animal to have been made
		
		if (acquiredAnimals == 0) {
			System.out.println("\n***You have no animals in the barn!***\n");
		}else {
			
		String animalName = readName("Type the name of the animal that should wander: ");
		Animal foundAnimal = retrieveAnimal(animalName);
		
		if (foundAnimal == null) {
			System.out.println("\n***This animal doesn't exist***\n");
			
		}else {
			
		int laps = readIntNumber("How many laps? ");

		foundAnimal.wander(laps);
		}
		}
	}

	public void feed() {								// method for feeding the animal, requires an animal and farmer to have been made
		
		if (acquiredAnimals == 0 ) {
			System.out.println("***You have no animals in the barn!***\n");
		}else if (hiredFarmers == 0) {
			System.out.println("***You have not hired any farmers for the barn!***\n");
		}else {
			
		String animalName = readName("Type the name of the animal to be fed: ");
		Animal foundAnimal = retrieveAnimal(animalName);
		
		if (foundAnimal == null) {
			System.out.println("\n***This animal doesn't exist***\n");
			
		}else {

		String farmerName = readName("Type the name of the farmer that should feed " + foundAnimal.getAnimalName() + ": ");
		Farmer foundFarmer = retrieveFarmer(farmerName);
		
		if (foundFarmer == null) {
			System.out.println("\n***This farmer doesn't exist***\n");
			
		}else {
		
		int foodAmount = readIntNumber("How many kilos of food will " + foundAnimal.getAnimalName() + " eat: ");
		
		if (foundAnimal.getAnimalHunger() <= 0) {
			System.out.println("\n" + foundAnimal.getAnimalName() + " is is not hungry right now, try again later!\n");
		}else {
		foundFarmer.feed(foodAmount, foundAnimal);
		}
		}
		}
		}
	}

	public static void main(String[] args) {		//main program, runs 2 methods (creating farm and the looped program)
		FarmMain program = new FarmMain();
		program.run();
	}
}