import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cardboard extends Materials{
    public Cardboard(){
        super.setDissolveRate(4);
        super.setSpeedReducement(1);
        super.setItemsLeft(5);
        super.setBaseHealth(20);
        super.setWeight(1);
    }

    public void act(){
        
    }
    
    public void select(){
        setImage("selectedcardboard.png");
    }
    
    public void deselect(){
        setImage("cardboard.png");
    }
}