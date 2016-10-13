/* This is a Newton YH Project for Application  2016.
 * This is not propriatary in any way, but please spread the word if it is in any way useful for you.
 * We are a group of four people looking for a job each :D
 */
package gameoflife;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFileChooser;

/**
 *
 * @author alice
 */
public final class Filehandler {
    
        public static Board loadFile() throws IOException{
                
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            //open path and get all bytes
            Path path = jfc.getSelectedFile().toPath();
            byte[] bite = Files.readAllBytes(path);
            
            //wrap bytes to ints
            ByteBuffer wrap = ByteBuffer.wrap(bite);
            IntBuffer ib = wrap.asIntBuffer();
            
            //Get two first ints = size of board
            int sizeY = ib.get(); 
            int sizeX = ib.get();
            
            //Create a board to set with alive cells. All cells wil automatically be set to dead in the constructor.
            Board board = new Board(sizeY, sizeX);
            
            //Fill board with alive cells.
            for(int x = 0; ib.hasRemaining()&& x < sizeY; x++){
                for(int y = 0; ib.hasRemaining() && y < sizeX; y++){
                    int test = ib.get();
                    if(test == 1){
                        board.getCell(x, y).setState(true);
                    }
                }
            }
            //Return board
            return board;
        }else{
            System.err.println("File Not Approved");
        }
        return null; //please change?
    }
    
    
    public static void saveFile(Board board) throws IOException{
        
        //Find size of board and add to bytebuffer
        ByteBuffer dbuf = ByteBuffer.allocate(Integer.SIZE * (2 + (board.getBoardSize(0) * board.getBoardSize(1))));
        dbuf.putInt(board.getBoardSize(0));
        dbuf.putInt(board.getBoardSize(1));
        
        //Fill buffer with ints correspondng to the cells    
        for(int x = 0; x < board.getBoardSize(0); x++){
            for(int y = 0; y < board.getBoardSize(1); y++){
                if(board.getCell(x, y).isAlive()){
                    dbuf.putInt(1);
                }else{
                    dbuf.putInt(0);
                }
            }
        }
        //Open file and fill with the values of the buffer
        JFileChooser jfc = new JFileChooser();
        if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            Path path = jfc.getSelectedFile().toPath();
            byte[] bite = dbuf.array();
            //write to file
            Files.write(path,bite);            
        }else{
            
            System.err.println("File not approved");
            
        }
        
    } 
    
}
