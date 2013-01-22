import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class Enforcements extends TimeInformation{

    private boolean isBusy;
    
    EnforcementTimer enforcementTimer;
    
    String enfType;
    
    public Enforcements(String enfTypeVal){
        enfType = enfTypeVal;
    }
    
    public void createTimer(int xCoordinate, int minimumTime){ // create timer on given xCoordinate
        createTimeInformation(minimumTime, 5);
        
        enforcementTimer = new EnforcementTimer("Busy: ", super.getTimeLeft(), super.getTimeEnd());
        getWorld().addObject(enforcementTimer, xCoordinate, 585);
    }
    
    // Removing method.
    public void removeEnforcementTimer(){
        getWorld().removeObject(enforcementTimer);
        enforcementTimer = null;
    }
    
    // Updating the enforcement to the correct image / status.
    public void isNowBusy(boolean status){
        if(status){
            newStatus(status);
        }else{
            resetStatus(status);
        }
    }

    public void newStatus(boolean status){
        setImage(enfType + "Used.png"); // display normal image.
        isBusy = status;
        
        if(enfType == "EnfFirefighter"){
            createTimer(396, 12);
        }else if(enfType == "EnfPolice"){
            createTimer(497, 7);
        }else if(enfType == "EnfAmbulance"){
            createTimer(600, 12);
        }
    }

    public void resetStatus(boolean status){
        setImage(enfType + ".png"); // display used image.
        isBusy = status;
    }
    
    public String getEnfType(){
        return enfType;
    }
    
    public boolean getStatus(){
        return isBusy;
    }
}
