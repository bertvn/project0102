import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class Enforcements extends TimeInformation{

    private boolean fireTruckIsBusy;
    private boolean policeCarIsBusy;
    private boolean ambulanceCarIsBusy;
    
    EnforcementTimer enforcementTimer;
    
    public void createTimer(int xCoordinate){ // create timer on given xCoordinate
        createTimeInformation(10, 5); // creating a timer of 10~15s.
        
        enforcementTimer = new EnforcementTimer("Busy: ", super.getTimeLeft(), super.getTimeEnd());
        getWorld().addObject(enforcementTimer, xCoordinate, 585);
    }
    
    // Removing method.
    public void removeEnforcementTimer(){
        getWorld().removeObject(enforcementTimer);
        enforcementTimer = null;
    }
    
    // Updating the enforcement to the correct image / status.
    public void setIsBusy(String value, boolean status){
        if(status){
            setImage(value + "Used.png"); // display used image.
        }else{
            setImage(value + ".png"); // display normal image.
        }
    
        if(value == "fireTruck"){ // update fireTruck status.
            fireTruckIsBusy = status;
        }else if(value == "policeCar"){ // update policeCar status.
            policeCarIsBusy = status; 
        }else if(value == "ambulanceCar"){ // update ambulanceCar status.
            ambulanceCarIsBusy = status;
        }
    }
    
}
