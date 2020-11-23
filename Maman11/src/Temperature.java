import java.util.Scanner; // Must Import this Every time when i use Input from user

public class Temperature {
	/*
	 * Class Author : Segev Kestenbaum
	 * Date : 13.11.2020 
	 * Description: 
	 * 				Class that will contain 1 method - main.
	 * 				The program will include constant variables for representing the numbers that require in the calculations.
	 * 				This class will calculate  and PAIR the temperature to KELVIN , FAHERNHEIT , CELCIUS
	 * 				According to the input that the user entered : Unit  + Temperature.
	 * 				The output will be the temperatures after calculations in all the measurements units ( as above).
	 * Formulas:
		 	C :
		 		C = C
		 		F =  ( 9 / 5 ) * C + 32
		 		K = C + 273.15 
		 	F :
		 		C = ( 5 / 9 ) * ( F - 32 )
		 		F = F
		 		K =  ( 5 / 9 ) * ( F - 32 ) + 273.15 
		 	K :
		 		C = K - 273.15
		 		F = ( 9 / 5 ) * ( K - 273.15 ) + 32
		 		K = K
	 */
	
	public static void main(String[] args) {
		
		//initialize all variables in Program
		double tempratureInput = 0, calcualtedCelcius = 0, calcualtedFahernheit = 0, calcualtedKelvin = 0;
		String degreesInput;
		
		// Variables for Calculations
		char degreesUnit;

		//  Final variables for calculations
		final double FAHERNHEIT_WATER_FREEZE_POINT = 32;
		final double KELVIN_WATER_FREEZE_POINT = 273.15;
		final double RATIO_BEWTEEN_UNITS = 9.0 / 5;
		final double OPPOSITE_RATIO_BEWTEEN_UNITS = 1 / RATIO_BEWTEEN_UNITS ;
		
		// Initiate a new instance of object from Scanner class - for use as input Object
		Scanner scan = new Scanner(System.in);

		// Message to Introduce the program
		System.out.println ("This program will calculate the Tempertures in every Measurement unit " +
							 "According to the Input from the user \n");
		
		// Message for first Input from user
		// Char that represent the Measurement Unit
		System.out.print("Please Enter a Character that represent the Measurement unit and Temperature amount : ");
		degreesInput = scan.next();
		tempratureInput = scan.nextDouble();
		
		//Extract the first Char of the Input to receive the Degree Unit.
		degreesUnit = degreesInput.charAt(0);

		 //Close scanner
		 scan.close();
		  
		 switch (degreesUnit) {
		 
		 //Calculate the Degrees
		 // First,In every Case, Insert the input according to the Unit that the user entered
		 // Then, calculate for each temperature all the other units.
		// In case that the Input character was not one of the above - do nothing.
		 
			case 'C':
				calcualtedCelcius = tempratureInput ; 
				calcualtedFahernheit = RATIO_BEWTEEN_UNITS * calcualtedCelcius + FAHERNHEIT_WATER_FREEZE_POINT ;
				calcualtedKelvin = tempratureInput + KELVIN_WATER_FREEZE_POINT ;
				break;
				
			case 'F':
				calcualtedFahernheit = tempratureInput ; // Insert the input according to the Unit that the user entered
				calcualtedCelcius = OPPOSITE_RATIO_BEWTEEN_UNITS * ( calcualtedFahernheit - FAHERNHEIT_WATER_FREEZE_POINT ) ;
				calcualtedKelvin = OPPOSITE_RATIO_BEWTEEN_UNITS * ( calcualtedFahernheit - FAHERNHEIT_WATER_FREEZE_POINT) + KELVIN_WATER_FREEZE_POINT ;
				break;
				
			case 'K':
				calcualtedKelvin = tempratureInput; 
				calcualtedCelcius = calcualtedKelvin - KELVIN_WATER_FREEZE_POINT ; 
				calcualtedFahernheit = RATIO_BEWTEEN_UNITS * ( calcualtedKelvin - KELVIN_WATER_FREEZE_POINT ) + FAHERNHEIT_WATER_FREEZE_POINT ;
				break;
		
			default: 
				break;
				
		}

		 // Final Output of Program
		System.out.println( calcualtedCelcius + " C" );
		System.out.println( calcualtedFahernheit + " F" );
		System.out.println( calcualtedKelvin + " K" );
		
	}	
}
