import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnfAmbulance extends Enforcements{

    public EnfAmbulance(){
        super();
        setImage("ambulanceCar.png");
    }
    
    public void act(){
        // Add your action code here.
    }
    
    public void setIsBusy(boolean status){
        super.setIsBusy("ambulanceCar", status);
    }
}
