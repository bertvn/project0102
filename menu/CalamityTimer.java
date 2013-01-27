import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * used to create a timer for a calamities
 * 
 * @author  RU development 
 * @version 1.0
 */
public class CalamityTimer extends Timers{
    
    private String calamityType;
    private Calamities belongsTo;

    /**
     * Constructor for this class. Creates a timer belonging to calamities.
     * @param prefix String that is placed in front of the time
     * @param timeLeft amount of seconds left
     * @param timeEnd the amount of seconds till the end is reached
     * @param clamityTypeVal description of the calamity it belongs to
     * @param classVal the name of the class it belongs to.
     */
    public CalamityTimer(String prefix, long timeLeft, long timeEnd, String calamityTypeVal, Calamities classVal){//, int streetFloodingRefNr){
        super(prefix, timeLeft, timeEnd);
        
        belongsTo = classVal;
        calamityType = calamityTypeVal;
    }
    
    /**
     * This method is used to move the timer below upwards.
     */ 
    public void moveTimerBelow(){
        // If we have a timer below
        if(getOneObjectAtOffset(0, 15, CalamityTimer.class) != null){
            CalamityTimer timer = (CalamityTimer) getOneObjectAtOffset(0, 15, CalamityTimer.class);
            
            timer.moveTimerBelow(); // Run this method for the timer below.
            timer.setLocation(getX(), getY()); // Move timer upwards.
        }
    }

    /**
     * @return The calamityname (String) to whom this timer belongs to.
     */
    public String getCalamityType(){
        return calamityType;
    }

    /**
     * @return The calamityname (intance name) to whom this timer belongs to.
     */
    public Calamities getBelongsTo(){
        return belongsTo;
    }

    /**
     * A method used to remove this timer.
     */
    public void removeCalamityTimer(){
        moveTimerBelow(); // Start moving below first.
        getWorld().removeObject(this);
        Controlecentrum.calamitiesRemoved++;
    }
}
