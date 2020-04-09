package lesson19;

import java.util.Random;

public class Skeptic extends Person {

	public Skeptic(int x, int y, Country country) {
		super(x, y, country);
		// TODO Auto-generated constructor stub
	}

	public Skeptic(){
	}
	 // the persons fate depends on some random variables...
	 private Random random = new Random();

	public void tryToMove() {
		tryToMoveRandomly();
	}

	  /**
		   try to move one step in a random direction.
			 if they way is blocked then don't move.
		*/
	public void tryToMoveRandomly() {
	   int dx = random.nextInt(3)-1; // -1,0,1
	   int dy = random.nextInt(3)-1; // -1,0,1
	   if (isOK(this.x+dx, this.y+dy,this.country)) {
	     this.moveTo(this.x+dx, this.y+dy);
	   }
	} 
}
