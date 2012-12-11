import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CementBag extends Materials{
    public CementBag(){
        super.setDissolveRate(1);
        super.setSpeedReducement(1);
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

