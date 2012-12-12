import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Soldier extends Helpers{
    public Soldier(){
        super.setSpeed(5);
        super.setPower(4);
    }
    
    public void act(){
        super.act();
    }
    
    public void select(){
        setImage("selectedsoldier.png");
    }
    
    public void deselect(){
        setImage("soldier.png");
    }
}

