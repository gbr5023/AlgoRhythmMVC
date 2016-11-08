/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorhythmmvc;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author gbr5023
 */
public class ExternalDataCntl 
{
    private final String EXTERNAL_DATA_PATH = "algorhythmmvc_data\\";
    private final String SONG_FILE_NAME = "songlist.tsv";
    
    public ExternalDataCntl()
    {
        if(confirmImport())
        {
            getSongList();
        }
    }
    
    public void getSongList()
    {
        try
        {
            File externalDataFile = new File(EXTERNAL_DATA_PATH + SONG_FILE_NAME); //File() arg needs a path
            Scanner in = new Scanner(externalDataFile); //have Scanner scan the File for input
            int count = 0;
            
            while(in.hasNextLine())
            {
                String tempStr = in.nextLine();
                //System.out.println(tempStr);
                Song tempSong = new Song(tempStr);
                System.out.println(tempStr);
                count++;
            }
            
            System.out.println("Count: " + count);
        }
        catch(FileNotFoundException fnfe)
        {
            String errMsg = fnfe.getMessage();
            System.err.println(errMsg);
        }
        
    }
    
    public boolean confirmImport()
    {
        boolean importConfirmed = false;
        String msg = "Are you sure you want to import songs?"; //Dialog message
        String title = "Import Songs"; //Dialog box title
        
        int result = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION); //combines msg, title, yes/no options in an option pane window
        if(result == JOptionPane.YES_OPTION)
        {
            importConfirmed = true;
        }
        
        return importConfirmed;
    }
}
