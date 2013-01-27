import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TimeInformation class is used for for extends
 * 
 * @author  RU development 
 * @version 1.0
 */
public abstract class TimeInformation extends Actor{
    
    private int duration;
    private long timeEnd;
    private long timeLeft;

    /**
     * This method is used for creating time information for the objects.
     * @param minimun minimum duration for the timer
     * @param between between what amount of seconds it should keep running after.
     * (0-between)
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
     * @return long The amount of time left.
     */
    public long getTimeLeft(){
        long timeCurrent = System.currentTimeMillis() / 1000;
        timeLeft = timeEnd - timeCurrent;
        return timeLeft;
    }
    
    /**
     * @return long The ending time.
     */
    public long getTimeEnd(){
        return timeEnd;
    }
    
    /**
     * @return int The duration of this object.
     */
    public int getDuration(){
        return duration;
    }
}