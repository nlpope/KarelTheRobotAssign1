/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel 
{
	public void run(){ checkerStreet(); }
	
	
	private void checkerStreet()
	{
		if (frontIsBlocked() && facingEast() && leftIsClear()){ handleSingleAvenue(); }
		else if (frontIsClear() && facingEast() && leftIsBlocked()){ handleSingleStreet(); }
		else if (frontIsBlocked() && facingEast() && leftIsBlocked()) { putBeeper(); return; }
		else { handleStandardBoard(); }
	}
	
	
	private void climb()
	{
		turnLeft();
		move();
		turnRight();
	}
	
	
	private void climbAndFaceWest()
	{
		turnLeft();
		move();
		turnLeft();
	} 
	
	
	private void climbAndFaceEast()
	{
		turnRight();
		move();
		turnRight();
	}
	
	
	private void handleStandardBoard()
	{
		int i = 0;
		while(frontIsClear()){
			if (i % 2 == 0){ putBeeper(); }
			i++;
			move();
		}
		if (i % 2 == 0){ putBeeper(); i++; }
		
		if (facingEast() && leftIsClear()) { climbAndFaceWest(); checkerStreet();}
		else if (facingWest() && rightIsClear()){ climbAndFaceEast(); checkerStreet();}
		else { print("donezo"); return; } 
	}
	
	
	private void handleSingleStreet()
	{
		int i = 0;
		while (frontIsClear()){
			if (i % 2 == 0){ putBeeper(); }
			i++;
			move();
		}
		if (i % 2 == 0){ putBeeper(); }
		print("donezo"); return;
	}
	
	
	private void handleSingleAvenue()
	{
		int i = 0;
		while (leftIsClear()){ 
			if (i % 2 == 0){ putBeeper(); }
			i++;
			climb();
		}
		if (i % 2 == 0){ putBeeper(); }
		print("donezo"); return;
	}
}
