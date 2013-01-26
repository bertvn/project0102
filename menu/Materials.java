import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Materials extends Actor{

    private int dissolveRate;
    private int speedReducement;
    private int baseHealth;
    private int weight;
    
    //amount it costs to use this Material
    private int scoreDecrease;
    
    /**
     * method that is run every act, this is contains everything that makes the class do what it does
     */
    public void act(){
        if(isMaterialBroken()){
            removeMaterial();
        }
    }
    
    /**
     * checks if material is broken
     * @return returns true if material is broken, otherwise it returnd false
     */
    public boolean isMaterialBroken(){
        if(baseHealth <= 0){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * removes this object
     */
    public void removeMaterial(){
        getWorld().removeObject(this);
    }
    
    /**
     * sets dissolveRate
     * @param dissolveRate sets the dissolveRate to this value
     */
    public void setDissolveRate(int dissolveRate){
        this.dissolveRate = dissolveRate;
    }
    
    /**
     * sets speedReducement
     * @param speedReducement sets speedReducement to this value
     */
    public void setSpeedReducement(int speedReducement){
        this.speedReducement = speedReducement;
    }
    
    /**
     * returns speedReducement
     * @return int that contains the value of speedReducement
     */
    public int getSpeedReducement(){
        return speedReducement;
    }
    
    /**
     * sets baseHealth
     * @param baseHealth sets baseHealth to this value
     */
    public void setBaseHealth(int baseHealth){
        this.baseHealth = baseHealth;
    }
    
    /**
     * decreases baseHealth with amount * dissolveRate
     * if baseHealth is <= 0 then the material will be removed from the world
     * @param amount this * dissolveRate is reduced from baseHealth
     */
    public void decreaseBaseHealth(int amount){ 
        if(baseHealth - (amount * dissolveRate) <= 0){
            getWorld().removeObject(this);
        }else{
            baseHealth -= (amount * dissolveRate);
        }
    }
    
    /**
     * sets weight
     * @param val value will be set as the materials weight
     */
    public void setWeight(int val){
        weight = val;
    }
    
    /**
     * returns weight
     * @return returns an int containing the weight
     */
    public int getWeight(){
        return weight;
    }
    
    /**
     * sets scoreDecrease
     * @param val value will be set as scoreDecrease
     */
    public void setScoreDecrease(int val){
        scoreDecrease = val;
    }
    
    /**
     * decreases score with scoreDecrease
     */
    public void ScoreDecrease(){
        Dijkdoorbraak.score -= scoreDecrease;
    }
    
    /**
     * changes image to selected
     */
    public void select(){
        imageCreater(2, 501);
    }
    
    /**
     * changes image to normal
     */
    public void deselect(){
        imageCreater(0, 409);
    }

    /**
     * changes image to selectable
     */
    public void selectable(){
        imageCreater(0, getY());
    }
    
    /**
     * changes image to unselectable
     */
    public void unselectable(){
        imageCreater(1, 501);
    }
    
    /**
     * method to change image, it is overriden by the child class
     */
    public void imageCreater(int x, int location){

    }
}
 
