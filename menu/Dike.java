import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Dike extends Actor{
    
    private int dikeHP;
    private Materials material;
    
    public Dike(){
        dikeHP = 24;
        setImage("dijkdoorbraak/break-1.png");
    }

    public void act(){
        // See wheter the dike has any of these objects on him
        material = (Materials) getOneObjectAtOffset(0, 40, Materials.class);
        
        // If a dike is broken end the game.
        // else if any of the objects exist ontop of the dike, do damage to
        // them (chance of 1 to 150) instead of the dike.
        if(endGame()){
            Dijkdoorbraak.endGame();
        }else if(material != null){
            if(doDamage(150)){
                doSomeDamageToMaterial();
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
            case  1: case  2: case  3: this.setImage("dijkdoorbraak/break-8.png"); break;
            case  4: case  5: case  6: this.setImage("dijkdoorbraak/break-7.png"); break;
            case  7: case  8: case  9: this.setImage("dijkdoorbraak/break-6.png"); break;
            case 10: case 11: case 12: this.setImage("dijkdoorbraak/break-5.png"); break;
            case 13: case 14: case 15: this.setImage("dijkdoorbraak/break-4.png"); break;
            case 16: case 17: case 18: this.setImage("dijkdoorbraak/break-3.png"); break;
            case 19: case 20: case 21: this.setImage("dijkdoorbraak/break-2.png"); break;
        }
    }
        
    public void doSomeDamageToMaterial(){
        material.decreaseBaseHealth((int) (Math.random() * 3) + 1);
    }
}
