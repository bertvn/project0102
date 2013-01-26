import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class TimeInformation extends Actor{
    
    private int duration;
    private long timeEnd;
    private long timeLeft;

    /**
     * This method is used for creating time information for the objects.
     * @param Requires a minimum duration for the timer and between what 
     * amount of seconds it should keep running after.
     */
    public void createTimeInformation(int minimum, int between){
        long timeCurrent = System.currentTimeMillis() / 1000;
        // Duration will be minimal ~ min+between (ie. 5~10s).
        duration = (int) (Math.random() * between) + minimum;
        
        timeEnd = timeCurrent + duration;
        timeLeft = timeEnd - timeCurrent;
    }
    
    /**
     * This method first updates the amount of time left.
     * @return The amount of time left.
     */
    public long getTimeLeft(){
        long timeCurrent = System.currentTimeMillis() / 1000;
        timeLeft = timeEnd - timeCurrent;
        return timeLeft;
    }
    
    /**
     * @return The ending time.
     */
    public long getTimeEnd(){
        return timeEnd;
    }
    
    /**
     * @return The duration of this object.
     */
    public int getDuration(){
        return duration;
    }
}