package zrandhawHWK4;

/**
 * MazeSolver.java
 * Solves a maze
 * Part of HWK4 Midpoint.
 */
import java.util.ArrayList;

public class MazeSolver
{
    public Agenda agenda;
    /**
     * Constructor for the MazeSolver class
     * 
     * @param the Agenda to be used
     */
    public MazeSolver(Agenda Agn)
    {
        agenda=Agn;
    }

    /**
     * Returns the ArrayList from Start position to goal..if that exists
     * 
     * @return ArrayList<Location>
     */
    //READER: name of methond should be solveMaze
    public ArrayList<Location> solveMaze(Maze maze)
    {
        agenda.clear();
        
        //Following the algorithm
        agenda.addLocation(maze.getStartLocation());
        
        int nRow=maze.getNumRows();
        int nCol=maze.getNumColumns();
        
        Location[][] marker=new Location[nRow][nCol];//To keep track of positions that have been added
        Location[][] tracker=new Location[nRow][nCol];//To keep track of the path b/w the goal and start
        ArrayList<Location> track=new ArrayList<Location>();//To be returned


	// READER:  No need for param.  If you find the goal location
        //          Construct the path and return it, otherwise add
	//          adjacent locations if possible
        boolean param=false;//To determine whether a path was found or not
        
        //exploring the options
        while(!agenda.isEmpty()&&!param)
        {
            Location loc=agenda.getLocation();
            
            int row=loc.getRow();
            int col=loc.getColumn();
            
            marker[row][col]=loc;
            if(maze.getSquare(loc)=='*') 
            {
                param=true;
            }
            else
            {   //Determining the cardinal possibilities
                if(col+1<nCol && maze.getSquare(maze.world[row][col+1])!='#' && !maze.world[row][col+1].equals(marker[row][col+1]))
                {
                    agenda.addLocation(maze.world[row][col+1]);
                    tracker[row][col+1]=loc;
                }
                if(col-1>=0 && maze.getSquare(maze.world[row][col-1])!='#' && !maze.world[row][col-1].equals(marker[row][col-1]))
                {
                    agenda.addLocation(maze.world[row][col-1]);
                    tracker[row][col-1]=loc;
                }
                if(row+1<nRow && maze.getSquare(maze.world[row+1][col])!='#' && !maze.world[row+1][col].equals(marker[row+1][col]))
                {
                    agenda.addLocation(maze.world[row+1][col]);
                    tracker[row+1][col]=loc;
                }
                if(row-1>=0 && maze.getSquare(maze.world[row-1][col])!='#' && !maze.world[row-1][col].equals(marker[row-1][col]))
                {
                    agenda.addLocation(maze.world[row-1][col]);
                    tracker[row-1][col]=loc;
                }
            }
        }
        
        //Only for if a path exists, otherwise an empty array is returned
        //READER: No need to reverse the path for now. 
        if (param)
        {
            Location loc=maze.getGoalLocation();
            track.add(loc);

            while(!loc.equals(maze.getStartLocation()))
            {
                loc=tracker[loc.getRow()][loc.getColumn()];
                track.add(loc);
            }
        }

        return track;
    }
}
