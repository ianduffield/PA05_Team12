package lesson19;

import java.util.Random;

public class FrequentFlier extends Person{

	Random random = new Random();
	
	public FrequentFlier() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void tryToMove() {
	      // find an open random space for the person
	      int i = random.nextInt(country.places.length);
	      int j = random.nextInt(country.places[i].length);
	      while (country.places[i][j] != null) {
	        // loop to make sure it is an open space ...
	        i = random.nextInt(country.places.length);
	        j = random.nextInt(country.places[i].length);
	      }
	      //System.out.println("placing "+p.id+" at "+i+","+j);

	      this.setPosition(i,j);
	      // country.places[i][j]= this;
	}
	
	

}
