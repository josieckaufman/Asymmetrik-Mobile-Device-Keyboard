package cmdLineInterpreter;
import java.util.Scanner;

import autoInterfaces.AutocompleteProvider;
import autocomplete.AutocompleteImpl;

/*This class is the driver for the program. 
 * TIt holds the main method which drives the scanner.*/
public class Driver {

	public static void main(String[] args) {
		String train, input, choice;
		
		
		AutocompleteProvider auto = new AutocompleteImpl();
			
		/*Create a new scanner*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello A-Team!");
		
		/*Until the user enters Quit, keep looping*/
	
		while(true) {
			System.out.println("Type (t) to train, (i) to input, and (q) to quit program");

			choice = scanner.nextLine();

			switch(choice) {
			
			case "t":
			System.out.println("Enter Your Training String: ");
			train = scanner.nextLine();
			auto.train(train);
			break;
			
			case "i":
			System.out.println("Enter Your Input String: ");
			input = scanner.nextLine();
			System.out.println("Output --> " + auto.toString(auto.getWords(input)));
			break;
			
			case "q":
			System.out.println("Goodbye A-Team!");
			scanner.close();
			System.exit(0);	
			break;
			
			default: System.out.println("Invalid choice.");
			
			}
		}	  
	}
}
