package lesson19;

import java.util.Random;

public class Athlete extends Person{

	Random random = new Random();

	// The Athlete is like the standard person, but has a chance to avoid infection, and may recover faster.
	  int chance = random.nextInt(5);

	  public void tick() {
	    tryToMove();
	    super.checkForInfection();

	  }
	  public void tryToMove(){
			super.tryToMoveRandomly();
		}

	  public void setPosition(int x, int y){
	    super.x=x;
	    super.y=y;
	  }


	  void tryToMoveRandomly(){
			// The athlete can move for longer distances.
	    int dx = random.nextInt(5)-2; // -2,-1,0,1,2
	    int dy = random.nextInt(5)-2; // -2,-1,0,1,2
	    if (isOK(super.x+dx, super.y+dy,super.country)) {
	      super.moveTo(super.x+dx, super.y+dy);
	    }
	  }

	  void checkForInfection(){
			// Has a probability for whether the Athlete is infected.
	    if (this.exposed && !this.infected) {
	      this.chance = random.nextInt(5);
	      if (this.chance > 1) {
	        this.infected = true;
	        this.infectionTime = this.age;
	      }
	    }
	    this.age++;
	    if (infected && !this.recovered && (this.age - this.infectionTime + this.chance > this.recoveryTime)) {
			// The athlete will usually recover faster than others.
	      this.recovered = true;
	    }
	  }

	  boolean isOK(int a, int b,Country country) {
			if (a<0 || a>=country.places.length || b<0
					|| b>= country.places[0].length) {
				return false;
			}else if (country.places[a][b] !=null) {
				return false;
			}else {
				return true;
			}
	  }
}
