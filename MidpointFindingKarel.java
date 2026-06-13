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

public class MidpointFindingKarel extends SuperKarel 
{
	double beepersLaid = 0;
	
	public void run()
	{
		placeBeepers();
		findMidpoint();
		layAtMidpoint();
	}
	
	
	private void placeBeepers()
	{
		while(frontIsClear()){
			putBeeper();
			beepersLaid++;
			move();
		}
		putBeeper();
	}
	
	
	private void findMidpoint()
	{
		turnAround();
		while(frontIsClear()){
			pickBeeper();
			move();
		}
		pickBeeper();
	}
	
	
	private void layAtMidpoint()
	{
		double midpoint = 0;
		int beepersRetrieved = 0;
		
		turnAround();
		if (beepersLaid % 2 == 0){
			double midpointMin = beepersLaid / 2;
			double midpointMax = (beepersLaid / 2) + 1;
			midpoint = (Math.random() * (midpointMax - midpointMin)) + midpointMin;
		}
		else { midpoint = (beepersLaid / 2) + 0.5; }
		
		while (beepersRetrieved != (beepersLaid - 1)){
			if (beepersRetrieved != midpoint) { 
				pickBeeper(); 
				beepersRetrieved++;
			}
			if (frontIsClear()){ move(); }
		}
	}
}
