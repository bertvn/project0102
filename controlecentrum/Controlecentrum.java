import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Controlecentrum extends World{
    

    public Controlecentrum(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 640, 1);
        populate();
    }
    
    public void populate(){
        setBackground("controlecentrum.jpg");
        
        // Headertext aanmaken voor kopje Calamiteiten
        HeaderText calamiteitenHeader = new HeaderText("Calamiteiten");
        addObject(calamiteitenHeader, 175, 475);
        
        // Headertext aanmaken voor kopje Hulpdiensten
        HeaderText hulpdienstHeader = new HeaderText("Hulpdiensten");
        addObject(hulpdienstHeader, 550, 475);
    }
}
