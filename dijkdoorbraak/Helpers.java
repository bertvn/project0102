import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Helpers extends Actor{

    private Boolean movement = false;
    private int x=-1;
    private int y=-1;
    private Materials holding = null;
    private int startX = -1;
    private int startY = -1;
    private Boolean checked = false;
    
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
        if(this.getX() != x && x != -1){
            if(this.getX()< x){
                moveLeft();
                return;
            }else{
                moveRight();
                return;
            }
        }
        if(this.getY() != y && y != -1){
            if(this.getY()< y){
                moveDown();
                return;
            }else{
                moveUp();
                return;
            }
        }
        if(holding != null){
            placeHolding();
        }
        startMovement(startX,startY);
        movement = false;
        
    }
    
    public void startMovement(int x, int y){
        this.x = x;
        this.y = y;
        movement = false;
    }
    
    public void moveLeft(){
        setLocation(getX()+1,getY());
    }
    
    public void moveRight(){
        setLocation(getX()-1,getY());
    }
    
    public void moveDown(){
        setLocation(getX(),getY()+1);
    }
    
    public void moveUp(){
        setLocation(getX(),getY()-1);
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
}