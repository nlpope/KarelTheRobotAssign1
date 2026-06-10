/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

//testing push 2
import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	
	public void run()
	{
		fillColumn();
	}

	public void fillColumn()
	{
		if (leftIsClear()) { turnLeft(); }
		else { turnRight(); }
		
		while (frontIsClear()) {
			if (noBeepersPresent()) { putBeeper(); }
			move();
		}
		if (noBeepersPresent()) { putBeeper(); }
		arreglar();
	}
	
	private void arreglar() 
	{
		if (facingNorth()) { turnRight(); } 
		else { turnLeft(); }
		if (frontIsBlocked()){ print("done"); return; }
		for (int i = 0; i < 4; i++) { move(); }
		fillColumn();
	}
}
