import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author Felix 
 * @version 05/15/2023
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("A"))
        {
            move(-2);
        }else if(Greenfoot.isKeyDown("D")){
            move(2);
        }
        
        // Remove apple if elephant eats it
        removeTouching(Apple.class);
    }
}
