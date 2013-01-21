import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalamityTimer extends Timers{
    
    private String calamityType;

    public CalamityTimer(String prefix, long timeLeft, long timeEnd, String calamityTypeVal){//, int streetFloodingRefNr){
        super(prefix, timeLeft, timeEnd);
        
        calamityType = calamityTypeVal;
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
    
    public String getCalamityType(){
        return calamityType;
    }
    
    public void removeCalamityTimer(){
        getWorld().removeObject(this);
    }
}
