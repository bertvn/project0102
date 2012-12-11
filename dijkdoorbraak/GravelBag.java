import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GravelBag extends Materials{  
    public GravelBag(){
        super.setDissolveRate(2);
        super.setSpeedReducement(2);
        super.setItemsLeft(5);
        super.setBaseHealth(21);
    }

    public void act(){
        
    }
    
    public void decreaseBaseHealth(int amount){
        if(getBaseHealth() - amount <= 0){
            getWorld().removeObject(this);
        }else{
            super.setBaseHealth(getBaseHealth() - amount);
        }
    }
}