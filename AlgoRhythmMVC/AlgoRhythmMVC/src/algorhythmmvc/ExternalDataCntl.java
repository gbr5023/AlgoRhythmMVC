/*
• You can work with a partner on this problem 
• Implement Media (Song) import and app-wide data serialization 
• Uses should be able to:

– Navigate to the media list view (use a JTable to display the list of media)
– Media are imported from the songlist.TSV file or another source (you need a minimum of 1000 songs)
– Select a media (e.g., a song) and view the detail for the object 
– Create a Rating for the media, a media can have more than one Rating 
– Compute and display an aggregate Rating for the media based on all of its individual Ratings 
– Your implementation should conform to the MVC architecture pattern 
– All data should be saved (persisted) between application runs

• Zip the entire AlgoRhythm Netbeans project and submit to Canvas before the due data and time
• Important: Each successive version of AlgoRhythm should build on code you wrote for the prior submission
• Due Friday, 11 November @ 11:50pm
 */

package algorhythmmvc;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author gbr5023
 */
public class ExternalDataCntl 
{
    private final String EXTERNAL_DATA_PATH = "algorhythmmvc_data";
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
            File externalDataFile = new File(EXTERNAL_DATA_PATH, SONG_FILE_NAME); //File() arg needs a path
            Scanner in = new Scanner(externalDataFile); //have Scanner scan the File for input
            int count = 0;
            ArrayList<Media> tempMediaList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getTheMediaList();
            tempMediaList.clear();
            
            
            while(in.hasNextLine())
            {
                String tempStr = in.nextLine();
                //System.out.println(tempStr);
                Song tempSong = new Song(tempStr);
                //tempMediaList.add(tempSong);
                System.out.println(tempSong.getMediaName());
                count++;
            }
            
            System.out.println("Count: " + count);
            // write here
            SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
            SerializedDataCntl.getSerializedDataCntl().readSerializedDataModel();
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
