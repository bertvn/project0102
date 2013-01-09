import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalCarCrash extends Calamities{
    private long endTime;
    private long timeLeft;
    private boolean imageHasChanged;
    private CalamityTimer calamityTimer;
    
    public void act(){
        setImage("carCrash.png");
    }    
}
