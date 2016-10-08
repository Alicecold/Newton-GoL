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
    public static boolean[][] loadFile() throws IOException{
        //There is a small possiblility that it should be 2 * IntergerSize.
        //In that case, please comply
        byte[] biteSize = new byte[2*Integer.SIZE];
        
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
//            Path path = jfc.getSelectedFile().toPath();
//            byte[] bite = Files.readAllBytes(path);
//            ByteBuffer wrap = ByteBuffer.wrap(bite);
//            IntBuffer ib = wrap.asIntBuffer();
//            int sizeX = ib.get(); //No idea how this will work, but right now it won't render a fricken huge number at least.
//            int sizeY = ib.get();
//            
//            boolean[][] array = new boolean[sizeX][sizeY];
//            int stepX = 0, stepY=0;
//            
//            while(ib.hasRemaining()){
//                if(ib.get() == 1){
//                    array[stepX][stepY] = true;
//                }else{
//                    array[stepX][stepY] = false;
//                }
//                
//                stepX++;
//                if(stepX >= sizeX){
//                    stepX = 0;
//                    stepY++;
//                    if(stepY >= sizeY){
//                        break;
//                    }
//                }
//            }
//            
//            return array;
           System.err.println("Not implemented");
           return new boolean[0][0];
        }else{
            System.err.println("File Not Approved");
        }
        return new boolean[0][0];
    }
    
    @Deprecated
    public static void saveFile(boolean board[][]) throws IOException{
        
        //TODO: how to handle boardsize?
        //TODO: test this in a real scenario and hope for the best <3
        
        //Find size of board
        ByteBuffer dbuf = ByteBuffer.allocate(2);
        dbuf.putInt(board.length);
        dbuf.putInt(board[0].length);
        byte[] biteSize = dbuf.array();
        
        byte[] bite = new byte[biteSize.length +(board.length * board[0].length)];
        
        bite[0] = biteSize[0];
        bite[1] = biteSize[0];
        
        //Open file and fill with cell values
        JFileChooser jfc = new JFileChooser();
        if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
//            Path path = jfc.getSelectedFile().toPath();
//            for(int x = 0; x < board.length; x++){
//                for(int y = 0; y < board[x].length; y++){
//                    if(board[x][y]){
//                        bite[(x*board[x].length) +y +2] = 1;
//                    }else{
//                        bite[(x*board[x].length) +y +2] = 0;
//                    }
//                }
//            }
//            
//            //write to file
//            Files.write(path,bite);
            System.err.println("Not implemented");
            
        }else{
            
            System.err.println("File not approved");
            
        }
        
    } 
    
}
