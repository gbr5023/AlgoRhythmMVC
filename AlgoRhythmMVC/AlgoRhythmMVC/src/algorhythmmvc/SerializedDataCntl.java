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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.ArrayList;

/**
 *
 * @author gbr5023
 */
public class SerializedDataCntl 
{
    private SerializedDataModel theSerializedDataModel;
    private static SerializedDataCntl theSerializedDataCntl;
    private final String EXTERNAL_DATA_PATH = "algorhythmmvc_data/";
    private final String ALGORHYTHMMVC_DATA_FILE_NAME = "songlist.tsv";
    //private ExternalDataCntl theExternalDataCntl;
    
    private SerializedDataCntl()
    {
        getSerializedDataModel();
    }
    
    public static SerializedDataCntl getSerializedDataCntl()
    {
        if(theSerializedDataCntl == null)
        {
            theSerializedDataCntl = new SerializedDataCntl();
        }
        
        return theSerializedDataCntl;
    }
    
    
    public SerializedDataModel getSerializedDataModel()
    {
        if(theSerializedDataModel == null)
        {
            readSerializedDataModel();
            if(theSerializedDataModel == null)
            {
                theSerializedDataModel = new SerializedDataModel();
                writeSerializedDataModel();
                readSerializedDataModel();
            }
        }
        
        return theSerializedDataModel;
    }
    
    public void readSerializedDataModel()
    {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String filePath = EXTERNAL_DATA_PATH + ALGORHYTHMMVC_DATA_FILE_NAME;
        
        try
        {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            theSerializedDataModel = (SerializedDataModel) ois.readObject();
            ois.close();
        }
        catch(FileNotFoundException err)
        {
            err.printStackTrace();
        }
        catch(IOException err)
        {
            err.getStackTrace();
        }
        catch(ClassNotFoundException err)
        {
            err.getStackTrace();
        }     
    }
    
    public void writeSerializedDataModel()
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        String filePath = EXTERNAL_DATA_PATH + ALGORHYTHMMVC_DATA_FILE_NAME;
        
        try
        {
            fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(theSerializedDataModel);
            oos.close();
        }
        catch(IOException err)
        {
            err.printStackTrace();
        }
    }
}
