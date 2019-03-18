package zrandhawHWK4;

/**
* Maze.java
* Provides all the functionalites of a Maze
* Part of HWK4 Midpoint.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
* Contains several methods build and aid in the utilization of a maze
*/
public class Maze
{
    protected int numRows;
    protected int numCols;


    // READER:  You can simplify things by using char[][], not Location [][]
    protected Location[][] world;

    protected Location start;
    protected Location goal;
    
    protected Location[][] walls;
    /**
     * Constructor for the Maze class
     * 
     * @param the name of the input file
     */
    public Maze(String fileName) throws FileNotFoundException
    {
        File inFile = new File(fileName);
        Scanner input =  null;
        
        //Had to be put to prevent the fnfe errors
        input =  new Scanner(inFile);
        //Scanning the first line of the file as a string
        numRows=input.nextInt();
        numCols=input.nextInt();
        
        
        world=new Location[numRows][numCols];// Main grid to which all the postions will be added
        walls=new Location[numRows][numCols];// Postions will be added into this grid only at the position which have a wall
        input.nextLine();//Had to do this
        for(int i=0;i<numRows;i=i+1)
        {
            char[] Line=input.nextLine().toCharArray();//Much simler than using a substring function
            for (int x=0; x<numCols;x++)//Didn't use a for each loop for the char{} because there were some bugs. This iteration solved everything
            {
		// READER:  This could be greatly simplified.
		//          There is no need to keep track of walls
		//          separately from other locations
                if(Line[x]=='o')
                    {
                        world[i][x]=new Location(i,x);//Initialising a grid location at very point of the grid (aka double array)
                        start=world[i][x];//Setting the home location
                    }
                else if(Line[x]=='*')
                    {
                        world[i][x]=new Location(i,x);
                        goal=world[i][x];//Setting the End location
                    }
                else if(Line[x]=='#')
                    {
                        world[i][x]=new Location(i,x);
                        walls[i][x]=world[i][x];
                    }
                else if (Line[x]=='.')
                    {
                        world[i][x]=new Location(i,x);
                    }
            }
        }
    }

    
    /**
     * @return int number of Columns in the Maze
     */
    public int getNumColumns()
    {
        return numCols;
    }

    /**
     * @return int number of Rows in the Maze
     */
    public int getNumRows()
    {
        return numRows;
    }
    
    
    /**
     * Returns the start Location
     * @return Location
     */
    public Location getStartLocation()
    {
        return start;
    }
    
    
    /**
     * Returns the Location of the goal
     * @return Location
     */
    public Location getGoalLocation()
    {
        return goal;
    }
    
    
    /**
     * Returns the character representation of a location in the maze
     * @return char
     */
    public char getSquare(Location loc)
    {
        if(loc.equals(start))   {return 'o';}
        
        else if(loc.equals(goal))   {return '*';}
        
        else if(walls[loc.getRow()][loc.getColumn()]!=null)    {return '#';}
        
        else    {return '.';}
    }

    /**
     * Returns the String representation of the whole maze
     * @return string
     */
    public String toString()
    {

	// READER:  if world is char, not Location then there
	//          is no need for the if/else ifs
        String rt_string="";
        for(int i=0;i<numRows;i++)
        {
            for(int x=0;x<numCols;x++)
            {
                if(world[i][x].equals(start))   {rt_string+="o";}
        
                else if(world[i][x].equals(goal))   {rt_string+="*";}
        
                else if(walls[i][x]!=null)    {rt_string+="#";}
        
                else    {rt_string+=".";}
            }
            rt_string+="\n";
        }
        return rt_string;
    }
}
