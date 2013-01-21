import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalamityTimer extends Timers{
    
    private String calamityType;
    private Calamities belongsTo;
    
    public CalamityTimer(String prefix, long timeLeft, long timeEnd, String calamityTypeVal, Calamities classVal){//, int streetFloodingRefNr){
        super(prefix, timeLeft, timeEnd);
        
        belongsTo = classVal;
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
    
    public Calamities getBelongsTo(){
        return belongsTo;
    }
    
    public void removeCalamityTimer(){
        moveTimerBelow();
        getWorld().removeObject(this);
    }
}
