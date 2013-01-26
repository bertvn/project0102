import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public abstract class Helpers extends Actor{

    private Boolean movement = false;
    private int x=-1;
    private int y=-1;
    private Materials holding = null;
    private int startX = -1;
    private int startY = -1;
    private Boolean checked = false;
    private int speed;
    private int power;
    private int tempSpeed;
    
    //amount it costs to use this Material
    private int scoreDecrease;
        
    /**
     * method that is run every act, this is contains everything that makes the class do what it does
     */
    public void act(){
        if(!checked){
            startX = getX();
            startY = getY();
            checked = true;
        }
        
        if(movement){
            move();
        }
    }
    /**
     * moves the helpers, x is prioritised over y
     * if the helper has reached it's destination it will return to it's initial location
     */
    public void move(){
        //store speed
        tempSpeed = speed;
        
        if(holding != null){
            //reduce speed with the reduce of the material
            tempSpeed -= holding.getSpeedReducement();
        }
        //if helper had not reached his xCoord of his location
        if(this.getX() != x && x != -1){
            //if distance left < speed
            if(Math.abs(this.getX() - x)< speed){
                //tempspeed is reduce to 1 to be able to reach the location
                tempSpeed = 1;
            }
            //if target is to the right
            if(this.getX()< x){
                //go to the right
                moveRight(tempSpeed);
                return;
            }else{
                //else go to the left
                moveLeft(tempSpeed);
                return;
            }
        }
        //if helper has not reached his location
        if(this.getY() != y && y != -1){
            //if distance left < speed
            if(Math.abs(this.getY() - y) < speed){
                //temp speed is reduce to 1 to be able to reach his location
                tempSpeed = 1;
            }
            //if target is down
            if(this.getY()< y){
                //move down
                moveDown(tempSpeed);
                return;
            }else{
                //else move up
                moveUp(tempSpeed);
                return;
            }
        }
        //if reached location and is holding a material
        if(holding != null){
            //place material
            placeHolding();
        }
        //if reached location and is not at start position
        if(this.getX() != startX || this.getY() != startY){
            //return to start position
            startMovement(startX,startY);
        }else{
            //else stop moving
            movement = false;
        }
    }
    
    /**
     * starts moving the character to location (x,y)
     * @param x x coord of his destination
     * @param y y coord of his destination
     */
    public void startMovement(int x, int y){
        this.x = x;
        this.y = y;
        movement = true;
        deselect();
    }
    
    /**
     * move to the right with amount value
     * @param value the amount the helper moves
     */
    public void moveRight(int value){
        setLocation(getX()+value, getY());
    }
    
    /**
     * move to the left with amount value
     * @param value the amount the helper moves
     */
    public void moveLeft(int value){
        setLocation(getX()-value, getY());
    }
    
    /**
     * move down with amount value
     * @param value the amount the helper moves
     */
    public void moveDown(int value){
        setLocation(getX(), getY()+value);
    }
    
    /**
     * move up with amount value
     * @param value the amount the helper moves
     */
    public void moveUp(int value){
        setLocation(getX(), getY()-value);
    }
    
    /**
     * sets holding, used to store materials in helpers
     * @param materiaal the material that the helper will carry
     */
    public void setHolding(Materials materiaal){
        holding = materiaal;
    }
    
    /**
     * places holding back in the world and removes it from this helper
     */
    public void placeHolding(){
        if(holding != null){
           getWorld().addObject(holding, getX(), getY());
        }
        holding = null;
    }
    
    /**
     * sets speed
     * @param speed this value will be set in speed
     */
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    /**
     * sets power
     * @param power this value will be set in power
     */
    public void setPower(int power){
        this.power = power;
    }
    
    /**
     * returns power
     * @returns int which contains the value of power
     */
    public int getPower(){
        return power;
    }
    
    /**
     * checks if helper is moving
     * @returns boolean which is true if helper is moving
     */
    public Boolean isBusy(){
        return movement;
    }
    
    /**
     * used to change image is overriden in the child class
     */
    public void select(){
    
    }
    
    /**
     * used to change image is overriden in the child class
     */
    public void deselect(){
        
    }
    
    /**
     * sets scoreDecrease
     * @param val the value will be stored in scoreDecrease
     */
    public void setScoreDecrease(int val){
        scoreDecrease = val;
    }
    
    //decreases score
    /**
     * decreases score with the amount stored in scoreDecrease
     */
    public void ScoreDecrease(){
        Dijkdoorbraak.score -= scoreDecrease;
    }
}