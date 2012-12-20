import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalStreetFlooding extends Calamities{
    private String streetState;

    public CalStreetFlooding(int imgNr){
        streetState = "open";
        setImage("overstroming" + imgNr + ".png");
    }
    
    public void act(){
        if(streetState == "open"){
            
        }
    }
    
    public void closeStreet(){
        streetState = "closed";
    }
    
    
    /* Not using this for now.
     * public void setStreetState(String newState){
     *     newState = newState.toLowerCase();
     *     if(newState != "closed" || newState != "open"){
     *         System.out.println("Use open or close as a state for this street");
     *     }else{
     *         streetState = newState;
     *     }
     * }
     */
}