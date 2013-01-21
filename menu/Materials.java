import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Materials extends Actor{
    private int dissolveRate;
    private int speedReducement;
    private int baseHealth;
    private int weight;
    
    //amount it costs to use this Material
    private int scoreDecrease;
    
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
    
    public int getSpeedReducement(){
        return speedReducement;
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
    
    public void setWeight(int val){
        weight = val;
    }
    
    public int getWeight(){
        return weight;
    }
    
    //sets scoreDecrease
    public void setScoreDecrease(int val){
        scoreDecrease = val;
    }
    
    //decreases score
    public void ScoreDecrease(){
        Dijkdoorbraak.score -= scoreDecrease;
    }
    
    public void select(){
        imageCreater(2, 501);
    }
    
    //next 2 methods do the same?
    public void deselect(){
        imageCreater(0, 409);
    }
    
    public void selectable(){
        imageCreater(0, getY());
    }
    
    public void unselectable(){
        imageCreater(1, 501);
    }
    
    public void imageCreater(int x, int location){
    
    }
}
 