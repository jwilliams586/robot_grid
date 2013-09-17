/*
Name: Jason Williams
SSOID#: jaw7w6
Class: CS2261
Section: E01
Programming Exercise #1
*/

import java.util.Scanner;
import java.io.*;

public class Pe1{
  public static void main(String[] args) {
 
	/* Variables!! */
    char robotnum;
	char direction;
	String in;

	Scanner input = new Scanner(System.in);

    /* Create grid and initialize the 4 robots */
	Grid grid = new Grid();
    Robot robot1 = new Robot(0,0,1,grid);
	Robot robot2 = new Robot(4,0,2,grid);
	Robot robot3 = new Robot(4,4,3,grid);
	Robot robot4 = new Robot(0,4,4,grid);

    System.out.print("Enter Command: ");
 
	/* Read input */
    while (input.hasNext()) {
	   in = input.next();

	/* Breaks loop if "e" is entered */
       if (in.contains("E") || in.contains("e")) {
	      grid.endIT();
	      break;
	   }

	/* Variables for char commands */
       robotnum = (char)in.charAt(0);
	   direction = (char)in.charAt(1);

	/* Process commands    NOTE: will accept upper and lower case */
	   if (robotnum == '1') {
	      if ((direction == 'U') || direction == 'u')
	         robot1.U(grid);

          if ((direction == 'D') || direction == 'd')
	         robot1.D(grid);

	      if ((direction == 'L') || direction == 'l')
	         robot1.L(grid);

	      if ((direction == 'R') || direction == 'r')
	         robot1.R(grid);
	   }
   
	   if (robotnum == '2') {
	      if ((direction == 'U') || direction == 'u')
	         robot2.U(grid);

	      if ((direction == 'D') || direction == 'd')
	         robot2.D(grid);

	      if ((direction == 'L') || direction == 'l')
	         robot2.L(grid);

	      if ((direction == 'R') || direction == 'r')
	         robot2.R(grid);
	   }
											
       if (robotnum == '3') {
          if ((direction == 'U') || direction == 'u')
	         robot3.U(grid);

	      if ((direction == 'D') || direction == 'd')
	         robot3.D(grid);

	      if ((direction == 'L') || direction == 'l')
	         robot3.L(grid);

          if ((direction == 'R') || direction == 'r')
	         robot3.R(grid);
       }

       if (robotnum == '4') {
	      if ((direction == 'U') || direction == 'u')
	         robot4.U(grid);

	      if ((direction == 'D') || direction == 'd')
	         robot4.D(grid);

	      if ((direction == 'L') || direction == 'l')
	         robot4.L(grid);

	      if ((direction == 'R') || direction == 'r')
	         robot4.R(grid);
	   }
	}
}

static class Robot {
 
   /* Private Variables!!! */
	private int x;
	private int y;
	private int robotID;

	/* No arg constructor (not used) */
	Robot() {
	}

	/* Constructor */
	Robot(int startx, int starty, int ID, Grid grid) {
	   x = startx;
	   y = starty;
	   robotID = ID;
	   grid.mark(x,y,robotID);
	}
    
	/* Movement of robots, Marking grid */
	void U(Grid grid) {
	   y++;
	   if (y <= 4 && y >= 0) {
          grid.mark(x,y,robotID);
	   }
	   else y--;
    }

	void D(Grid grid) {
	   y--;
       if (y >= 0 && y <= 4) {
          grid.mark(x,y,robotID);
       }
	   else y++;
	}

	void L(Grid grid) {
	   x--;
	   if (x >= 0 && x <= 4) {
          grid.mark(x,y,robotID);
       }
	   else x++;
	} 

	void R(Grid grid) {
	   x++;
	   if (x <= 4 && x >= 0) {
          grid.mark(x,y,robotID);
       }
	   else x--;
	}
}
static class Grid {

	int[][] matrix;
	   
    Grid() {
       matrix = new int[5][5];
    }

	/* Marks grid */
    void mark(int x, int y, int value) {
       matrix[x][y] = value;
    }

	/* Print current grid */
    void endIT() {
       for (int row = 4; row >= 0; row--) {
          for (int col = 0; col < 5; col++) {
             System.out.print(matrix[col][row]);
          }
          System.out.println();
       }
       System.out.println("PROGRAM ENDS");
	}
    }
}
