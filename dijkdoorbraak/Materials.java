import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Materials extends Actor{
    private int dissolveRate;
    private int speedReducement;
    private int itemsLeft;
    private int baseHealth;
    
    public void act(){
        if(isMaterialBroken()){
            removeMaterial();
        }
    }
    
    public boolean isMaterialBroken(){
        if(baseHealth <= 0){
            return true;
        }else{
            return false;
        }
    }
        
    public void removeMaterial(){
        getWorld().removeObject(this);
    }
    
    public void setDissolveRate(int dissolveRate){
        this.dissolveRate = dissolveRate;
    }
    
    public void setSpeedReducement(int speedReducement){
        this.speedReducement = speedReducement;
    }
    
    public void setItemsLeft(int itemsLeft){
        this.itemsLeft = itemsLeft;
    }
    
    public void setBaseHealth(int baseHealth){
        this.baseHealth = baseHealth;
    }
        
    public void decreaseBaseHealth(int amount){ 
        if(baseHealth - (amount * dissolveRate) <= 0){
            getWorld().removeObject(this);
        }else{
            baseHealth -= (amount * dissolveRate);
        }
    }
}
 