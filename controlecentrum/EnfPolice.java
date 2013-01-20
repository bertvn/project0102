import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnfPolice extends Enforcements{

    public EnfPolice(){
        super();
        setImage("policeCar.png");
    }
    
    public void act(){
        // Add your action code here.
    }  
    
    public void setIsBusy(boolean status){
        super.setIsBusy("policCar", status);
    }
}