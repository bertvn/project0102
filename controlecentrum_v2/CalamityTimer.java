import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalamityTimer extends Timers{

    public CalamityTimer(String prefix, long timeLeft, long timeEnd){//, int streetFloodingRefNr){
        super(prefix, timeLeft, timeEnd);
    }
    
    // Method to move the timer below upwards.
    public void moveTimerBelow(){
        // If we have a timer below
        if(getOneObjectAtOffset(0, 15, CalamityTimer.class) != null){
            // Get his information
            CalamityTimer timer = (CalamityTimer) getOneObjectAtOffset(0, 15, CalamityTimer.class);
            
            // Do this method for the timer below.
            timer.moveTimerBelow();
            
            // Move timer upwards.
            timer.setLocation(getX(), getY());
        }
    }
}
