package lesson19;

import java.util.Random;

public class RunSimulation {
	// the maximum number of days the simulation will run
	private static int MAX_TICKS=1000;

	private Random random = new Random();

	public static void main(String[] args) {
		// first we get the simulation parameters
		// from the command line

		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int numStayHome = Integer.parseInt(args[2]);
		int numEssential = Integer.parseInt(args[3]);
		int numSkeptic = Integer.parseInt(args[4]);
		int FrequentFlier = Integer.parseInt(args[5]);

		// next we create the population and the country
		Population population;

		//population = new Population(numPeople);
		//population = new AllStayAtHome(numPeople);
		//int numEssential = numPeople/10;
		//int numOther = numPeople/20;
		//int numStayHome = numPeople - numEssential - numOther;
		population = new MixedPopulation(numStayHome, numEssential, numSkeptic, FrequentFlier);
		population.createPeople(); //??****

		Country country = new Country(width,height);  //backward?***
		// and add a link to the population in the country
		country.population = population;
		// next we place the people into the country randomly
		population.placePeople(country);

		System.out.println("Initial State of the Country");
		country.printCountry();

		System.out.println("\nTracking the Infection");
		for(int k=0;k<MAX_TICKS; k++) {
			country.simulateOneStep();
			country.printState(k);

			if (country.numInfected==0) {
				break;

			}
		}
		System.out.println("\nFinal State of the Country");
		country.printCountry();

	}
	
	public static void AnalyzeSituation(){
		// first we get the simulation parameters
		// from the command line

		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int numStayHome = Integer.parseInt(args[2]);
		int numEssential = Integer.parseInt(args[3]);
		int numSkeptic = Integer.parseInt(args[4]);
		int numFrequentFlier = Integer.parseInt(args[5]);
		int numAthlete = Integer.parseInt(args[6]);
		int repetitions = Integer.parseInt(args[7]);
		int[] numOfDaysList = new int[repetitions];
		int numOfDays = 0;
		int[] numOfInfectedList = new int[repetitions];
		int numOfInfected = 0;
		int[] peakInfectedLevelList = new int[repetitions];
		int peakInfectedLevel = 0;
		
		for (int i = 0; i < repetitions; i++){
			

		// next we create the population and the country
		Population population;

		//population = new Population(numPeople);
		//population = new AllStayAtHome(numPeople);
		//int numEssential = numPeople/10;
		//int numOther = numPeople/20;
		//int numStayHome = numPeople - numEssential - numOther;
		population = new MixedPopulation(numStayHome, numEssential, numSkeptic, numFrequentFlier, numAthlete);
		population.createPeople(); //??****

		Country country = new Country(width,height);  //backward?***
		// and add a link to the population in the country
		country.population = population;
		// next we place the people into the country randomly
		population.placePeople(country);
		System.out.println("\nTracking the Infection");
		for(int k=0;k<MAX_TICKS; k++) {
			country.simulateOneStep();

			if (country.numInfected==0) {
				numOfDaysList[i] = k;
				break;

			}
		}
	}



	}
}
