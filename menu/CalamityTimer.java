import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class CalamityTimer extends Timers{
    
    private String calamityType;
    private Calamities belongsTo;

    /**
     * Constructor for this class. Creates a timer belonging to calamities.
     * @param Requires a prefix, amount of seconds left, the 
     * amount of seconds till the end is reached, description of the calamity
     * it belongs to and the name of the class it belongs to.
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
