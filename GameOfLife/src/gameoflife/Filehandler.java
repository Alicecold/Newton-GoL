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
    
    /*Do not use untill byte arrays works perfectly*/
    //@Deprecated
    public static Board loadFile() throws IOException{
        //There is a small possiblility that it should be 2 * IntergerSize.
        //In that case, please comply
        byte[] biteSize = new byte[2*Integer.SIZE];
        
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            Path path = jfc.getSelectedFile().toPath();
            byte[] bite = Files.readAllBytes(path);
            ByteBuffer wrap = ByteBuffer.wrap(bite);
            IntBuffer ib = wrap.asIntBuffer();
            int sizeY = ib.get(); 
            int sizeX = ib.get();
            
            System.out.println(sizeX + "x" + sizeY);
            
            Board board = new Board(sizeX, sizeY);
            int stepX = 0, stepY=0;
            
            for(int x = 0; ib.hasRemaining()&& x < sizeX; x++){
                for(int y = 0; ib.hasRemaining() && y < sizeY; y++){
                int test = ib.get();
                if(test == 1){
                    board.getCell(x, y).setState(true);
                }else if(test== 0){
                    board.getCell(x, y).setState(false);
                }
                }
            }
            return board;
        }else{
            System.err.println("File Not Approved");
        }
        return null;
    }
    
    
    public static void saveFile(Cell board[][]) throws IOException{
        //TODO: test this in a real scenario and hope for the best <3
        
        //Find size of board
        ByteBuffer dbuf = ByteBuffer.allocate(Integer.SIZE * (2 + (board.length * board[0].length)));
        dbuf.putInt(board.length);
        dbuf.putInt(board[0].length);
        
        
        //Open file and fill with cell values
        JFileChooser jfc = new JFileChooser();
        if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            Path path = jfc.getSelectedFile().toPath();
            for(int x = 0; x < board.length; x++){
                for(int y = 0; y < board[x].length; y++){
                    if(board[x][y].isAlive()){
                        dbuf.putInt(1);
                    }else{
                        dbuf.putInt(0);
                    }
                }
            }
            byte[] bite = dbuf.array();
            //write to file
            Files.write(path,bite);            
        }else{
            
            System.err.println("File not approved");
            
        }
        
    } 
    
}
