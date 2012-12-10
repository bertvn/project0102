import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Dike extends Actor{
    private int dikeHP;
    private int dikeDamage;
    
    public Dike(){
        dikeHP = 24;
    }

    public void act(){
        if(endGame()){
            WorldSpawner.endGame();
        }else if(doDamage()){
            doSomeDamage();
        }       
    }
    
    public boolean doDamage(){
        if((int) Math.floor(Math.random()*300)+1 == 1){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean endGame(){
        if(dikeHP <= 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void doSomeDamage(){
        dikeDamage = (int) Math.floor(Math.random()*3)+1;        
        dikeHP -= dikeDamage;
        
        switch(dikeHP){
            case  1: case  2: case  3: this.setImage("break-8.png"); break;
            case  4: case  5: case  6: this.setImage("break-7.png"); break;
            case  7: case  8: case  9: this.setImage("break-6.png"); break;
            case 10: case 11: case 12: this.setImage("break-5.png"); break;
            case 13: case 14: case 15: this.setImage("break-4.png"); break;
            case 16: case 17: case 18: this.setImage("break-3.png"); break;
            case 19: case 20: case 21: this.setImage("break-2.png"); break;
        }
    }
}
