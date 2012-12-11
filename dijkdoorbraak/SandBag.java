import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SandBag extends Materials{
    public SandBag(){
        super.setDissolveRate(4);
        super.setSpeedReducement(4);
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

