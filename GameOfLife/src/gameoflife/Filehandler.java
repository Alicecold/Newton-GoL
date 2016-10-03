/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFileChooser;

/**
 *
 * @author alicecold
 */
public abstract class Filehandler {
    
    /*Do not use untill byte arrays works perfectly*/
    @Deprecated
    public static boolean[][] loadFile() throws IOException{
        //There is a small possiblility that it should be 2 * IntergerSize.
        //In that case, please comply
        byte[] biteSize = new byte[2];
        
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            Path path = jfc.getSelectedFile().toPath();
            byte[] bite = Files.readAllBytes(path);
            ByteBuffer wrap = ByteBuffer.wrap(bite);
            int size = wrap.getInt(); //Right now this will render a FUCKNG LARGE NUMBER
            return new boolean[biteSize[0]][biteSize[1]];
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
            Path path = jfc.getSelectedFile().toPath();
            for(int x = 0; x < board.length; x++){
                for(int y = 0; y < board[x].length; y++){
                    if(board[x][y]){
                        bite[(x*board[x].length) +y +2] = 1;
                    }else{
                        bite[(x*board[x].length) +y +2] = 0;
                    }
                }
            }
            
            //write to file
            Files.write(path,bite);
            
        }else{
            
            System.err.println("File not approved");
            
        }
        
    } 
    
}
