import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class that is used for extends of calamaities
 * extends TimeInformation
 * 
 * @author  RU development 
 * @version 1.0
 */
public abstract class Calamities extends TimeInformation{
    
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
     * @param minimumTime the minimal time of this duration
     * @param suffix String containing what is displayed after the time
     * @param calamityTypeVal contains the type of calamity
     * @param classVal contains the calamity
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
     * @return CalamityTimer the timer that belongs to this calamity.
     */
    public CalamityTimer getCalamityTimer(){
        return calamityTimer;
    }

    /**
     * Adding information to the calamity timer variable for further reference.
     * @param newVal the timer object that is going to belong to this calamity.
     */
    public void setCalamityTimer(CalamityTimer newVal){
        calamityTimer = newVal;
    }
}
