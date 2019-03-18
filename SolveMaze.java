package zrandhawHWK4;

/**
 * SolveMaze.java
 * Brings together all of the architecture of a program to solve the maze
 * Part of HWK4 Midpoint.
*/

import java.io.FileNotFoundException;

public class SolveMaze
{
    public static void main(String args[])
    {
        Maze maze=null;
        try
        {
         maze=new Maze(args[0]);
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("Input file not found");
            System.exit(1);
        }
        
        StackAgenda SA=new StackAgenda(); //Creating a stack Agenda
        MazeSolver MS=new MazeSolver(SA);//Creating the Maze object
        //The above 2 lines could have been written like, but not done because the question 
        //statement asked us to create these things
        //MazeSolver MS1=new MazeSolver(new StackAgenda());
        
        System.out.println(MS.solveMaze(maze));//Printing the path
    }
}