import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cardboard extends Materials{
    public Cardboard(){
        super.setDissolveRate(8);
        super.setSpeedReducement(8);
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