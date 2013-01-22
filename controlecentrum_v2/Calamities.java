import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class Calamities extends TimeInformation{
    
    private CalamityTimer calamityTimer;
    
    // Update the timer and start removing procedure if it reached 0.
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
    
    // Method for creating a new timer with given prefix.
    public void createTimer(int minimumTime, String suffix, String calamityTypeVal, Calamities classVal){
        createTimeInformation(minimumTime, 10);
        
        calamityTimer = new CalamityTimer(suffix, super.getTimeLeft(), super.getTimeEnd(), calamityTypeVal, classVal);
        getWorld().addObject(calamityTimer, 130, Controlecentrum.getNextTimerPosition());
    }
    
    // Method for removing the timer and moving all timers beneath up.
    public void removeCalamityTimer(){
        calamityTimer.removeCalamityTimer();
        calamityTimer = null;
    }
    
    // Get information about timer (mostly used for wheter it exists or not).
    public CalamityTimer getCalamityTimer(){
        return calamityTimer;
    }
    
    public void setCalamityTimer(CalamityTimer newVal){
        calamityTimer = newVal;
    }
}
