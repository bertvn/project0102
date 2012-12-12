import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CementBag extends Materials{
    public CementBag(){
        super.setDissolveRate(1);
        super.setSpeedReducement(4);
        super.setItemsLeft(5);
        super.setBaseHealth(20);
        super.setWeight(3);
    }

    public void act(){
        
    }
    
    public void select(){
        setImage("selectedbigCementBag.png");
    }
    
    public void deselect(){
        setImage("bigCementBag.png");
    }
}

