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
        int v = speed;
        if(holding != null){
            v -= holding.getSpeedReducement();
        }
        if(this.getX() != x && x != -1){
            if(Math.abs(this.getX() - x)< speed){
                v = 1;
            }
            if(this.getX()< x){
                moveLeft(v);
                return;
            }else{
                moveRight(v);
                return;
            }
        }
        if(this.getY() != y && y != -1){
            if(Math.abs(this.getY() - y) < speed){
                v = 1;
            }
            if(this.getY()< y){
                moveDown(v);
                return;
            }else{
                moveUp(v);
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
    
    public void moveLeft(int v){
        setLocation(getX()+v,getY());
    }
    
    public void moveRight(int v){
        setLocation(getX()-v,getY());
    }
    
    public void moveDown(int v){
        setLocation(getX(),getY()+v);
    }
    
    public void moveUp(int v){
        setLocation(getX(),getY()-v);
    }
    
    public void setHolding(Materials materiaal){
        holding = materiaal;
    }
    
    public void placeHolding(){
        if(holding != null){
           getWorld().addObject(holding,getX(),getY());
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