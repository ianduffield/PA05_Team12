package lesson19;

public class AnalyzeSimulation extends RunSimulation {
	int width;
	int height;
	int numStayHome;
	int numEssential;
	int numSkeptic;
	int numFrequentFlier;
	int numAthlete;
	int repetitions;
	
	public AnalyzeSimulation(int width, int height, int numStayHome, int numEssential, int numSkeptic, int numFrequentFlier, int numAthlete, int repetitions){
		this.width = width;
		this.height = height;
		this.numStayHome = numStayHome;
		this.numEssential = numEssential;
		this.numFrequentFlier = numFrequentFlier;
		this.numAthlete = numAthlete;
		this.repetitions = repetitions;
}
	public void AnalyzeSituation(){
		int[] numOfDaysList = new int[this.repetitions];
		int numOfDays = 0;
		int[] numOfInfectedList = new int[this.repetitions];
		int numOfInfected = 0;
		int[] peakInfectedLevelList = new int[this.repetitions];
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
			for(int k=0;k<MAX_TICKS; k++) {
				country.simulateOneStep();
				if (country.numInfected > peakInfectedLevel){
					peakInfectedLevel = country.numInfected;
				}
				if (country.numInfected==0) {
					numOfDaysList[i] = k;
					country.printStats();
					break;

				}
			} numOfInfectedList[i] = country.numRecovered;
			peakInfectedLevelList[i] = peakInfectedLevel;
		} peakInfectedLevel = 0;
			for (int j = 0; j < this.repetitions; j++){
			numOfDays += numOfDaysList[j];
			numOfInfected += numOfInfectedList[j];
			peakInfectedLevel += peakInfectedLevelList[j];
		} System.out.println("Average number of days before the infection ends: " + numOfDays/this.repetitions);
		System.out.println("Average number of infected persons: " + numOfInfected/this.repetitions);
		System.out.println("Average level of peak infection: " + peakInfectedLevel/this.repetitions);
	}

}
