/*
Problem Set #4

Implement the AlgoRhythm use case Add Media

Users should be able to:
-Navigate to the media list view (use a JTable to display the list of media)
-Select a media (eg a song) and view the detail for the object
-Create new media, edit existing media, delete media from the list

-Your implementation should conform to the MVC architecture pattern

Zip entire AlgoRhythm Netbeans project and submit to Canvas before due date and time
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
