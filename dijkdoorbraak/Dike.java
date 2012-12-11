import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Dike extends Actor{
    private int dikeHP;
    private Materials selectedMaterial;
    
    public Dike(){
        dikeHP = 24;
    }

    public void act(){
        if(endGame()){
            WorldSpawner.endGame();
        }else if(materialOnDike()){
            if(doDamage(150)){
                System.out.println("Does damage");
                doSomeDamageToMaterial();
            }
        }else if(doDamage(300)){
            doSomeDamage();
        }       
    }
    
    public boolean doDamage(int chance){
        if((int) Math.floor(Math.random() * chance ) +1 == 1){
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
    
    public boolean materialOnDike(){
        //List<Materials> matList = getWorld().getObjectAt(getX(), getY()+40, Materials.class);
        selectedMaterial = (Materials) getOneObjectAtOffset(getX(), getY()+40, Materials.class);
        
        if(selectedMaterial != null){
            System.out.println("Is now true");
            return true;
        }else{
            return false;
        }
    }
    
    public void doSomeDamage(){       
        dikeHP -= (int) Math.floor(Math.random()*3)+1; 
        
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
    
    public void doSomeDamageToMaterial(){
        int amount = (int) Math.floor(Math.random()*3)+1;
        //selectedMaterial.decreaseBaseHealth(amount);
    }
}
