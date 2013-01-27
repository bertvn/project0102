import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class Calamities extends TimeInformation{
    
    private CalamityTimer calamityTimer;
    
    /**
     * This method runs every act and will update the timer and start removing
     * procedure if it reached 0.
     */
    public void act(){
        if(calamityTimer != null){
            long currentTimeLeft = super.getTimeLeft();
            if(currentTimeLeft <= 0){
                int pointReduction = (int) ((Math.random() * 10) + 40 + super.getDuration());
                Controlecentrum.scoreControl -= pointReduction;
                removeCalamityTimer();
            }else{
                calamityTimer.setCurrentValue(super.getTimeLeft());
            }
        }
    }
    
    /**
     * Method for creating a new timer.
     * @param Requires the minimal time of his duration, a suffix, string
     * based calamity type and the name of the calamity it belongs to.
     */
    public void createTimer(int minimumTime, String suffix, String calamityTypeVal, Calamities classVal){
        createTimeInformation(minimumTime, 10);
        
        calamityTimer = new CalamityTimer(suffix, super.getTimeLeft(), super.getTimeEnd(), calamityTypeVal, classVal);
        getWorld().addObject(calamityTimer, 138, Controlecentrum.getNextTimerPosition());
        Controlecentrum.setNextTimerPosition();
    }
    
    /**
     * Method to call for the removal procedure of a timer.
     */
    public void removeCalamityTimer(){
        calamityTimer.removeCalamityTimer();
        calamityTimer = null;
    }
    
    /**
     * Get information about timer (ie. used to check if it exists or not).
     * @return The name of the timer that belongs to this calamity.
     */
    public CalamityTimer getCalamityTimer(){
        return calamityTimer;
    }

    /**
     * Adding information to the calamity timer variable for further reference.
     * @param Requires the timer object that is going to belong to this calamity.
     */
    public void setCalamityTimer(CalamityTimer newVal){
        calamityTimer = newVal;
    }
}
