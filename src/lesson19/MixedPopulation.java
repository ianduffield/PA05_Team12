package lesson19;

public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numOthers;
  int FrequentFlier;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numOthers, int FrequentFlier){
    super(numShelterInPlace + numEssential + numOthers+FrequentFlier);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numOthers = numOthers;
    this.FrequentFlier = FrequentFlier;

  }

  public void createPeople(){
    for(int i=0; i<this.numShelterInPlace; i++){
      this.addPerson(new StayAtHome());   //***addperson?
    }
    for(int i=0; i<this.numEssential; i++){
      this.addPerson(new StayAtHomeIfSick());
    }
    for(int i=0; i<this.numOthers; i++){
      this.addPerson(new Person());
    }
    for(int i=0; i<this.FrequentFlier; i++){
        this.addPerson(new Person());
      }
  }
}
