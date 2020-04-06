import java.util.Random;

public class Athlete extends Person {
  // The Athlete is like the standard person, but has a chance to avoid infection, and may recover faster.
  int chance = random.nextInt(5);


  public void tick() {
    super.tryToMove();
    super.checkForInfection();

  }
  void tryToMove(){
		super.tryToMoveRandomly();
    super.tryToMoveRandomly();
	}

  void tryToMoveRandomly(){
    int dx = random.nextInt(4)-1; // -1,0,1
    int dy = random.nextInt(4)-1; // -1,0,1
    if (isOK(super.x+dx, super.y+dy,super.country)) {
      super.moveTo(super.x+dx, super.y+dy);
    }
  }

  void checkForInfection(){
    if (this.exposed && ! this.infected) {
      this.chance = new random.nextInt(5);
      if (this.chance > 1) {
        this.infected = true;
        this.infectionTime = this.age;
      }
    }
    this.age++;
    if (infected && !this.recovered && (this.age - this.infectionTime + this.chance > this.recoveryTime)) {
      this.recovered = true;
    }
  }

}
