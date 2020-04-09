package lesson19;

public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numSkeptic;
  int numFrequentFlier;
  int numAthlete;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numSkeptic, int numFrequentFlier, int numAthlete){
    super(numShelterInPlace + numEssential + numSkeptic + numFrequentFlier + numAthlete); // Gets the whole population number
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numSkeptic = numSkeptic;
    this.numFrequentFlier = numFrequentFlier;
    this.numAthlete = numAthlete;
  }

  public void createPeople(){
    for(int i=0; i<this.numShelterInPlace; i++){
      this.addPerson(new StayAtHome());   //***addperson?
    }
    for(int i=0; i<this.numEssential; i++){
      this.addPerson(new StayAtHomeIfSick());
    }
    for(int i=0; i<this.numSkeptic; i++){
      this.addPerson(new Skeptic());
    }
    for(int i=0; i<this.numFrequentFlier; i++){
        this.addPerson(new FrequentFlier());
      }
    for(int i=0; i<this.numAthlete; i++){
        this.addPerson(new Athlete());
      }
  }
}
