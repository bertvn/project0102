import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Paper extends Materials{
    public Paper(){
        super.setDissolveRate(16);
        super.setSpeedReducement(16);
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
