/* This is a Newton YH Project for Application  2016.
 * This is not propriatary in any way, but please spread the word if t is in any way useful for you.
 * We are a group of four people looking for a job :D
 */
package gameoflife;

/**
 *
 * @author alicecold
 */
public class Cell {
    
    private boolean isAlive;
    private static int numberOfAlive = 0;
    
    
    Cell(boolean isAlive){
        if(isAlive){
            this.isAlive = true;
            numberOfAlive++;
        }else{
            this.isAlive = false;
        }
    }
    
    
    public void setState(boolean alive){
        isAlive = alive;
        
        if(isAlive)
            numberOfAlive++;
        else
            numberOfAlive--;
    }
    
    public boolean isAlive(){
        return isAlive;
    }
    
    public boolean isDead(){
        return !isAlive;
    }
    
    public static int getNumberOfAliveCells(){
        return numberOfAlive;
    }
    
    public static void setNumberOfAliveCells(int num){
        numberOfAlive = num;
    }
    
}
