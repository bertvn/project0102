import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class EnforcementTimer extends Timers{
    /**
     * Constructor for this class. Creates a timer belonging to an enforcement.
     * @param prefix String that is placed in front of the time
     * @param timeLeftVal amount of seconds left 
     * @param timeEndVal the amount of seconds till the end is reached.
     */
    public EnforcementTimer(String prefix, long timeLeft, long timeEnd){       
        super(prefix, timeLeft, timeEnd);
    }
}
