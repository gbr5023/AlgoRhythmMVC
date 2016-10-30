/*
You can work with a partner on this problem 
• Implement the AlgoRhythm use case Rate Media 

• Uses should be able to:
– Navigate to the media list view (use a JTable to display the list of media) 
– Select a media (e.g., a song) and view the detail for the object 
– Create a Rating for the media, a media can have more than one Rating 
– Compute and display an aggregate Rating for the media based on all of its individual Ratings 
– Your implementation should conform to the MVC architecture pattern

• Zip the entire AlgoRhythm Netbeans project and submit to Canvas before the due data and time
• Important: Each successive version of AlgoRhythm should build on code you wrote for the prior submission
• Due Friday, 4 November @ 11:50pm
 */

package algorhythmmvc;

import java.util.ArrayList;

/**
 *
 * @author Gisward
 */
public abstract class MediaList 
{
    private ArrayList<Media> theMediaList;
    private ArrayList<String> theMediaNameList;
    private Media theMedia;
    private String colMediaArray[] = {"Media Name", "Artist", "Length", "Rating"};
    private String colMediaNameArray[] = {"Media"};
    
    public abstract String[] getColMediaArray();
    public abstract String[] getColMediaNameArray();
    public abstract ArrayList<String> getTheMediaNameList();
    
    public ArrayList<Media> getTheMediaList()
    {
        return this.theMediaList;
    }
    
    
}
