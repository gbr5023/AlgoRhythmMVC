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

import java.util.ArrayList;

/**
 *
 * @author Gisward
 
public class SongList
{
    private MediaListCntl theMediaListCntl;
    private ArrayList<Media> theMediaList;
    private ArrayList<String> theMediaNameList;
    private String colMediaArray[] = {"Song Name", "Artist", "Length", "Avg Rating"};
    private String colMediaNameArray[] = {"Song"};
    
    public SongList()
    {
        if(theMediaList == null)
        {
            populateSongList();
        }
        else
        {
            populateSongList();
            theMediaListCntl.updateTheSongList();
            theMediaList = getTheSongList();
        }
    }
    
    public void populateSongList()
    {
        theMediaList = new ArrayList<>();
        theMediaList.add(new Song("Shake It Off", "Taylor Swift", 3.5));
        theMediaList.add(new Song("Sweater Weather", "The Neighbourhood", 4.0));
        theMediaList.add(new Song("Yeezus", "Kanye West", 3.4));
        theMediaList.add(new Song("The Eye", "Infinite", 4.3));
        theMediaList.add(new Song("Anaconda", "Nicki Minaj", 3.2));
        for(int i = 1; i <= 30; i++)
        {
            theMediaList.add(new Song("Hotline Bling " + i, "Drake", 3.9));
        }
        String colMediaArray[] = {"Media Name", "Artist", "Length", "Rating"};
        String colMediaNameArray[] = {"Song"};
    }
    
    public void addRow(Song newSong)
    {
        theMediaList.add(newSong);
    }
    
    
}
*/
