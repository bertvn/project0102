import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enforcements extends Actor{

    private boolean fireTruckIsBusy;
    private boolean policeCarIsBusy;
    private boolean ambulanceCarIsBusy;
    
    private int duration;
    private long timeEnd;
    private long timeLeft;
    
    // Updating the enforcement to the correct image / status.
    public void setIsBusy(String value, boolean status){
        if(status){
            setImage(value + "Used.png"); // display used image.
        }else{
            setImage(value + ".png"); // display normal image.
        }
    
        if(value == "fireTruck"){ // update fireTruck status.
            fireTruckIsBusy = status;
        }else if(value == "policeCar"){ // update fireTruck status.
            policeCarIsBusy = status; 
        }else if(value == "ambulanceCar"){ // update fireTruck status.
            ambulanceCarIsBusy = status;
        }
    }
    
    public void createTimeInformation(){
        long timeCurrent = System.currentTimeMillis() / 1000;
        duration = (int) (Math.random() * 5) + 10; // Duration (10 ~ 15s) of the timer.
        
        timeEnd = timeCurrent + duration;
        timeLeft = timeEnd - timeCurrent;
    }
    
    public long getTimeLeft(){
        return timeLeft;
    }
    
    public long getTimeEnd(){
        return timeEnd;
    }
}
