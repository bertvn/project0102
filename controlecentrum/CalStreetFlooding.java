import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalStreetFlooding extends Calamities{
    private Boolean streetIsOpen;
    private Boolean hasShortCircuit;

    public CalStreetFlooding(int imgNr){
        streetIsOpen = true;
        hasShortCircuit = false;
        setImage("overstroming" + imgNr + ".png");
    }
    
    public void act(){
        if(streetIsOpen == true && hasShortCircuit == false){
            if((int) (Math.random() * 1000) == 1){
                createNewShortCircuit();
            }
        }
    }
    
    public void closeStreet(){
        streetIsOpen = false;
    }
    
    public void createNewShortCircuit(){
        getWorld().addObject(new CalShortCircuit(), getX()+5, getY()+5);
        hasShortCircuit = true;
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