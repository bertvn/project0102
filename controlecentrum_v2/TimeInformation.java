import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TimeInformation extends Actor{
    private int duration;
    private long timeEnd;
    private long timeLeft;
    
    public void createTimeInformation(int minimum, int between){
        long timeCurrent = System.currentTimeMillis() / 1000;
        duration = (int) (Math.random() * between) + minimum; // Duration (10 ~ 15s) of the timer.
        
        timeEnd = timeCurrent + duration;
        timeLeft = timeEnd - timeCurrent;
    }
    
    public long getTimeLeft(){
        long timeCurrent = System.currentTimeMillis() / 1000;
        timeLeft = timeEnd - timeCurrent;
        return timeLeft;
    }
    
    public long getTimeEnd(){
        return timeEnd;
    }
}