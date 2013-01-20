import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnfFirefighter extends Enforcements {

    EnforcementTimer firetruckTimer;
    
    public EnfFirefighter(){
        super();
        setImage("fireTruck.png");
    }
    
    // Change status to input.
    public void setIsBusy(boolean status){
        super.setIsBusy("fireTruck", status);
        
        createTimer();
    }
    
        
    public void createTimer(){
        createTimeInformation();
        
        firetruckTimer = new EnforcementTimer("Busy: ", super.getTimeLeft(), super.getTimeEnd());
        getWorld().addObject(firetruckTimer, 396, 585);
    }
    

}
