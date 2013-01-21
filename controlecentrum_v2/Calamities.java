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
    
    public void createTimer(String suffix){
        createTimeInformation(25, 10);
        
        calamityTimer = new CalamityTimer(suffix, super.getTimeLeft(), super.getTimeEnd());
        getWorld().addObject(calamityTimer, 130, Controlecentrum.getNextTimerPosition());
    }
    
    public void removeCalamityTimer(){
        System.out.print("Trying to remove: ");
        System.out.println(calamityTimer);
        calamityTimer.moveTimerBelow();
        getWorld().removeObject(calamityTimer);
        calamityTimer = null;
    }
    
    public CalamityTimer getCalamityTimer(){
        return calamityTimer;
    }
}
