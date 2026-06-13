/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;
import java.util.Random;

public class MidpointFindingKarel extends SuperKarel 
{
	double beepersPlaced = 0;
	double beepersRetrieved = 0;
	
	public void run()
	{
		placeBeepers();
		retrieveBeepersBarMidpoint();
		// layBeeperAtMidpoint();
	}
	
	
	private void placeBeepers()
	{
		while(frontIsClear()){
			putBeeper();
			beepersPlaced++;
			move();
		}
		putBeeper();
		beepersPlaced++;
		print("beepersplaced = " + beepersPlaced + "\n");
	}
	
	
	private void retrieveBeepersBarMidpoint()
	{
		turnAround();
		double midpoint = 0;
		
		if (beepersPlaced % 2 == 0){
			print("even beepers = " + beepersPlaced + "\n");
			double midpointMin = beepersPlaced / 2;
			print("midpointMin = " + midpointMin + "\n");
			double midpointMax = (beepersPlaced / 2) + 1;
			print("midpointMax = " + midpointMax + "\n");
			midpoint = (Math.random() * (midpointMax - midpointMin)) + midpointMin;
		}
		else { midpoint = (beepersPlaced / 2) + 0.5; }
		//prob
		print("midpoint = " + midpoint + "\n");
		//----------------
		while(frontIsClear()){
			pickBeeper();
			beepersRetrieved++;
			print("beepersRetrievd = " + beepersRetrieved + "\n");
			if (beepersRetrieved == midpoint){ putBeeper(); }
			move();
		}
		pickBeeper();
		beepersRetrieved++;
		
		print("donezo");
	}
}
