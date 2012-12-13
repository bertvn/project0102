import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Helpers extends Actor{


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
    
    public Helpers(){

    }
    
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
    
    public void move(){
        tempSpeed = speed;
        
        if(holding != null){
            tempSpeed -= holding.getSpeedReducement();
        }
        
        if(this.getX() != x && x != -1){
            if(Math.abs(this.getX() - x)< speed){
                tempSpeed = 1;
            }
            if(this.getX()< x){
                moveLeft(tempSpeed);
                return;
            }else{
                moveRight(tempSpeed);
                return;
            }
        }
        
        if(this.getY() != y && y != -1){
            if(Math.abs(this.getY() - y) < speed){
                tempSpeed = 1;
            }
            if(this.getY()< y){
                moveDown(tempSpeed);
                return;
            }else{
                moveUp(tempSpeed);
                return;
            }
        }
        
        if(holding != null){
            placeHolding();
        }
        
        if(this.getX() != startX || this.getY() != startY){
            startMovement(startX,startY);
        }else{
            movement = false;
        }
    }
    
    public void startMovement(int x, int y){
        this.x = x;
        this.y = y;
        movement = true;
        deselect();
    }
    
    public void moveLeft(int value){
        setLocation(getX()+value, getY());
    }
    
    public void moveRight(int value){
        setLocation(getX()-value, getY());
    }
    
    public void moveDown(int value){
        setLocation(getX(), getY()+value);
    }
    
    public void moveUp(int value){
        setLocation(getX(), getY()-value);
    }
    
    public void setHolding(Materials materiaal){
        holding = materiaal;
    }
    
    public void placeHolding(){
        if(holding != null){
           getWorld().addObject(holding, getX(), getY());
        }
        holding = null;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void setPower(int power){
        this.power = power;
    }
    
    public int getPower(){
        return power;
    }
    
    public Boolean isBusy(){
        return movement;
    }
    
    public void select(){
    
    }
    
    public void deselect(){
        
    }
}