import java.util.Scanner;

public class Assignment1 {
	
	static Scanner scanner = new Scanner(System.in);		//declaring a new global function 'scanner' for the multiple methods
	
	public static void Task1() {							//calculating the mean

		int[] input = {2, 30, 326, 412, 19, 9, 76};

		double total = 0;

		for (int i = 0 ; i <= 6 ; i++){                		//this for-loop sums up all the elements of the array 'input'

			total = total + input[i];
		}
		System.out.print("The mean is: " + (total/7));		//the program calculates the mean by dividing
	}
	
	public static void Task2() {							//reading student's full name

 		System.out.print("Please type the student's full name: " );
 		String name = scanner.nextLine();
 		
 		String[] fullName = name.split(" ");				//calls upon the function 'split' and creates a string array.
 															//fills every array 'box' with a string for every space in between
 		System.out.println("First name: " + fullName[0]);
 		
 		if ( fullName.length >= 2 ) {						//if length of array fullName is equal or bigger than 2, it will also print out the last name
 			System.out.print("Last name: " + fullName[fullName.length-1]);
 		}													//'.length' function will always start at '1' instead of the array size starting at 'o'.
 															//this forces us to call upon the array with '-1' to get to the last string
 	}
	
	public static void Task3() {							//searching for students
			
		String[] studentNames = { "Angela Smith", "Elizabeth Markson", "Smith Jordan", "Paul Chris", "Smith Williams", "Smith Jacobs" };
		String compare = "Smith ";
			
		for ( int i = 0 ; i < 6 ; i++) {					//program will stay in loop for 6 times (same as the number of student names we have)
				
			if ( studentNames[i].contains(compare) ) {		//if the current 'box' of array 'studentNames', based on the number we've been in the loop,
				System.out.print( studentNames[i] );		//contains the same string as the variable 'compare', it will print it out
					
				if ( i < studentNames.length-1 ) {			//if we've repeated the loop less times than the actual array size (-1 because '.length' function starts at 1 )
					System.out.print(", ");					//the program will print out a ', ' between the student names.
				}
			}
		}
	}

	public static void Task4() {							//generate a student ID

		System.out.print("Please enter your full name: ");
		String fullName = scanner.nextLine();

		int thirdToLast = fullName.length()-3;				//declaring a variable that is equal to the length of the full name minus 3
		int secondToLast = fullName.length()-2;				//declaring a variable that is equal to the length of the full name minus 2
		int last = fullName.length();						//declaring a variable that is equal to the length of the full name

		String firstThree = fullName.substring(0, 3);		//this variable represents the first three letters of the first name.

		String lastTwo = fullName.substring(secondToLast, last);
		   													//this variable represents the last two letters of the surname.
		String thirdUpper = fullName.substring(thirdToLast, secondToLast).toUpperCase();
		   													//this variable represents the third to last letter in the surname, but in upper case.
		System.out.print("Your student ID is: " + firstThree + thirdUpper + lastTwo);
		   													//the program prints the first three letters of the user's first name and using the int variables 
		}	   												//'thirdToLast' and 'last', it prints the last three letters of the user's surname.
	
	public static void Task5() {							//use the switch case
			
		String exit = "";									//gives the string 'exit' an empty value so we can use it for the while-loop below
			
		System.out.print("Please Enter the Grade: ");
			
		while (exit != "X") {								//program will loop inside here as long as the typer doesn't type in 'X'
		
			String grade = scanner.nextLine();	
			switch (grade) {								//following switch will have a case for each grade (A,B,C,D,E,F), an exit option and a misstype default.
			case "X":
				exit = "X";									//if program enters case 'X', it will give the value exit a 'X' which will result in stopping the loop
				System.out.print("Have a Good Day!");
				break;
			case "A":
				System.out.println("Your marks are 90. Excellent!");
				System.out.print("Please Enter the Grade: ");
				break;
			case "B":
				System.out.println("Your marks are 80. Very nice!");
				System.out.print("Please Enter the Grade: ");
				break;
			case "C":
				System.out.println("Your marks are 70. Good enough!");
				System.out.print("Please Enter the Grade: ");
				break;
			case "D":
				System.out.println("Your marks are 60. Satisfactory!");
				System.out.print("Please Enter the Grade: ");
				break;
			case "E":
				System.out.println("Your marks are 50. You can do better!");
				System.out.print("Please Enter the Grade: ");
				break;
			case "F":
				System.out.println("Your scored less than 40. Better Luck Next Time!");
				System.out.print("Please Enter the Grade: ");
				break;
			default:
				System.out.println("You have entered an invalid selection.");
				System.out.print("Please Enter the Grade: ");
			}
		}
	}

	public static void main (String[]args) {
		
		String exit = "";
		
		while (exit != "X") {								//main program will stay in this loop and let the user call upon the different tasks above until he/ she chooses to exit ('X')
			System.out.print("\n\nWhich task would you like to run? ");
			String task = scanner.nextLine();
			
			switch (task) {
			case "X":
				System.out.print("Thank you for using our program :O)");
				exit = "X";
				break;
			case "1":
				Task1();
				break;
			case "2":
				Task2();
				break;
			case "3":
				Task3();
				break;
			case "4":
				Task4();
				break;
			case "5":
				Task5();
				break;
			default:
				System.out.print("You have entered an invalid selection.");
			}
		}
		scanner.close();	
	}
}
