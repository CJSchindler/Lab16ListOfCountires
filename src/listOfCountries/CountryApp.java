package listOfCountries;

import java.util.List;
import java.util.Scanner;

public class CountryApp {
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		boolean userContinues = false; //keeps track of whether user wants to continue
		
		System.out.println("Welcome to the Countries Maintenance Application!");
		
		// loop that continues as long as userContinues is true
		do {
		
			System.out.println("\nPlease choose from the following: ");
			System.out.println("1 - See the list of countries\n"
					+ "2 - Add a country\n"
					+ "3 - Exit");
			
			//allow user to choose what to do, get input through validator
			int userChoice = Validator.getInt(scnr, "\nEnter a menu number: ", 1, 3);
			System.out.println(); // blank line for readability
			
			if (userChoice == 1) {
				
				//read a list of countries from a file
				List<Country> countries = CountryFileUtil.readFile(); //
				for (Country country : countries) {
					System.out.println(country.getName());
				}
				userContinues = true;
			}	
			else if (userChoice == 2) {
				//append countries to existing list
				System.out.println("What country would you like to add? ");
				String userCountry = scnr.nextLine();
				Country country = new Country(userCountry);
				CountryFileUtil.appendLine(country);
				
				userContinues = true;
			}
			else {
				userContinues = false;
			}
		} while (userContinues == true);
		
			
		// If countries file/directory does not exist, create the file/directory.
		CountryFileUtil.createDirectory(System.getProperty("user.home") + "/Desktop/CountriesFolder");
		CountryFileUtil.createBlankFile(System.getProperty("user.home") + "/Desktop/CountriesFolder/countries.txt");
		
		System.out.println("\nThank you for your participation!");
		
		scnr.close();
	}

}