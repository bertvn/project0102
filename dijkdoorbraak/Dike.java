import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Dike extends Actor{
    private int dikeHP;
    private Paper paper;
    private Cardboard cardboard;
    private SandBag sandBag;
    private GravelBag gravelBag;
    private CementBag cementBag;
    
    public Dike(){
        dikeHP = 24;
    }

    public void act(){
        // See wheter the dike has any of these objects on him
        paper = (Paper) getOneObjectAtOffset(0, 40, Paper.class);
        cardboard = (Cardboard) getOneObjectAtOffset(0, 40, Cardboard.class);
        sandBag = (SandBag) getOneObjectAtOffset(0, 40, SandBag.class);
        gravelBag = (GravelBag) getOneObjectAtOffset(0, 40, GravelBag.class);
        cementBag = (CementBag) getOneObjectAtOffset(0, 40, CementBag.class);
        
        // If a dike is broken end the game.
        // else if any of the objects exist ontop of the dike, do damage to
        // them (chance of 1 to 150) instead of the dike.
        if(endGame()){
            WorldSpawner.endGame();
        }else if(paper != null){
            if(doDamage(150)){
                doSomeDamageToPaper();
            }
        }else if(cardboard != null){
            if(doDamage(150)){
                doSomeDamageToCardboard();
            }
        }else if(sandBag != null){
            if(doDamage(150)){
                doSomeDamageToSandBag();
            }
        }else if(gravelBag != null){
            if(doDamage(150)){
                doSomeDamageToGravelBag();
            }
        }else if(cementBag != null){
            if(doDamage(150)){
                doSomeDamageToCementBag();
            }
        }else if(doDamage(300)){ // else do dike to the damage (chance 1 to 300)
            doSomeDamage();
        }       
    }
    
    public boolean doDamage(int chance){
        if((int)(Math.random() * chance ) + 1 == 1){
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
        dikeHP -= (int) (Math.random() * 3 ) + 1; 
        
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
    
    public void doSomeDamageToPaper(){
        paper.decreaseBaseHealth((int) (Math.random() * 3) + 1);
    }
    
    public void doSomeDamageToCardboard(){
        cardboard.decreaseBaseHealth((int) (Math.random() * 3) + 1);
    }
        
    public void doSomeDamageToSandBag(){
        sandBag.decreaseBaseHealth((int) (Math.random() * 3) + 1);
    }
    
    public void doSomeDamageToGravelBag(){
        gravelBag.decreaseBaseHealth((int) (Math.random() * 3) + 1);
    }
    
    public void doSomeDamageToCementBag(){
        cementBag.decreaseBaseHealth((int) (Math.random() * 3) + 1);
    }
}
