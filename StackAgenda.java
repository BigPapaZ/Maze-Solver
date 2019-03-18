package zrandhawHWK4;

/**
 * StackAgenda.java
 * Builds the specific the Stack type of Agenda Super class
 * Part of HWK4 Midpoint.
 */

import java.util.Stack;

public class StackAgenda extends Agenda
{
    private Stack stc;

    /**
     * Constructor for the  StackAgenda class
     */
    public StackAgenda()
    {
        stc=new Stack();
    }

    
    /**
     * Adds location to a Stack
     */
    
    @Override
    public void addLocation(Location loc)
    {
        stc.push(loc);
    }
    
    /**
     * Returns the topmost location on the stack
     * @return Location
     */
    @Override
    public Location getLocation()
    {
        return (Location) stc.pop();
    }
    
    /**
     * Determines whether a Stack is empty or not
     * @return boolean true if empty
     */
    @Override
    public boolean isEmpty()
    {
        return stc.empty();
    }
    
    /**
     * Clears a list
     */
    @Override
    public void clear()
    {
        stc=new Stack();
        //At first had used the method below, but this one is more efficient
        /**
        while (!this.isEmpty())
        {this.getLocation();}
        */
    }
}