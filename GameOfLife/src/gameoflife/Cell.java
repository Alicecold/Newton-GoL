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
    
    public void born(){
        numberOfAlive++;
        isAlive = true;
    }
    
    public void die(){
        numberOfAlive--;
        isAlive = false;
    }
    
    public boolean isAlive(){
        return isAlive;
    }
    
    public static int getNumberOfAliveCells(){
        return numberOfAlive;
    }
    
}