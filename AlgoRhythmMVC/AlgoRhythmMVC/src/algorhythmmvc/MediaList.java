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

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gisward
 */
public class MediaList implements Serializable
{
    private ArrayList<Media> theMediaList;
   
    public MediaList()
    {
        if(theMediaList == null)
        {
            //buildTestMediaList();
            ExternalDataCntl theExternalDataCntl = new ExternalDataCntl();
            
        }
    }
    
    public ArrayList<Media> getTheMediaList()
    {
        if(theMediaList == null)
        {
            buildTestMediaList();
        }
        return this.theMediaList;
    }

    public void buildTestMediaList() 
    {
        theMediaList = new ArrayList<Media>();
        for(int i = 0; i < 100; i++)
        {
            Song tempSong = new Song(("Title") + i, ("Artist") + i, i);
            theMediaList.add(tempSong);
        }
    }
    
    
}
