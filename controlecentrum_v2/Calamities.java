import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Calamities extends TimeInformation{
    
    private CalamityTimer calamityTimer;

    public void act(){
        if(calamityTimer != null){
            long currentTimeLeft = super.getTimeLeft();
            if(currentTimeLeft <= 0){
                removeCalamityTimer();
            }else{
                calamityTimer.setCurrentValue(super.getTimeLeft());
            }
        }
    }
    
    public void createTimer(){
        createTimeInformation(25, 10);
        
        calamityTimer = new CalamityTimer("Flooded street open: ", super.getTimeLeft(), super.getTimeEnd());
        
        getWorld().addObject(calamityTimer, 130, Controlecentrum.getNextTimerPosition());
    }
    
    public CalamityTimer getCalamityTimer(){
        return calamityTimer;
    }
    
    public void removeCalamityTimer(){
        calamityTimer.moveTimerBelow();
        getWorld().removeObject(calamityTimer);
    }
}
