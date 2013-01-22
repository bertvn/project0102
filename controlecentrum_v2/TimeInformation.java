import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class TimeInformation extends Actor{
    private int duration;
    private long timeEnd;
    private long timeLeft;
    
    // Updating time information for the objects.
    public void createTimeInformation(int minimum, int between){
        long timeCurrent = System.currentTimeMillis() / 1000;
        // Duration will be minimal ~ min+between (ie. 5~10s).
        duration = (int) (Math.random() * between) + minimum;
        
        timeEnd = timeCurrent + duration;
        timeLeft = timeEnd - timeCurrent;
    }
    
    // Get the timeleft.
    public long getTimeLeft(){
        long timeCurrent = System.currentTimeMillis() / 1000;
        timeLeft = timeEnd - timeCurrent;
        return timeLeft;
    }
    
    // Get the ending time.
    public long getTimeEnd(){
        return timeEnd;
    }
    
    // Get the ending time.
    public int getDuration(){
        System.out.println("Duration was: " + duration);
        return duration;
    }
}