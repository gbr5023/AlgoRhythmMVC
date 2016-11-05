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
public class SongList extends MediaList
{
    private ArrayList<Song> theMediaList;
    private ArrayList<String> theMediaNameList;
    private Song theSong;
    private String colMediaArray[] = {"Song Name", "Artist", "Length", "Avg Rating"};
    private String colMediaNameArray[] = {"Song"};
    
    public SongList()
    {
        if(theMediaList == null)
        {
            populateSongList();
        }
    }
    
    public void populateSongList()
    {
        theMediaList = new ArrayList<>();
        theMediaList.add(new Song("Shake It Off", "Taylor Swift", 3.5, 3));
        theMediaList.add(new Song("Sweater Weather", "The Neighbourhood", 4.0, 5));
        theMediaList.add(new Song("Yeezus", "Kanye West", 3.4, 4));
        theMediaList.add(new Song("The Eye", "Infinite", 4.3, 5));
        theMediaList.add(new Song("Anaconda", "Nicki Minaj", 3.2, 5));
        for(int i = 1; i <= 30; i++)
        {
            theMediaList.add(new Song("Hotline Bling " + i, "Drake", 3.9, 3));
        }
        String colMediaArray[] = {"Media Name", "Artist", "Length", "Rating"};
        String colMediaNameArray[] = {"Song"};
    }
    
    public void addRow(Song newSong)
    {
        theMediaList.add(newSong);
    }
    
    public Song getSongDetail(int row)
    {
        return theMediaList.get(row);
    }

    @Override
    public String[] getColMediaArray() 
    {
        return this.colMediaArray;
    }

    @Override
    public String[] getColMediaNameArray() 
    {
        return this.colMediaNameArray;
    }      

    public ArrayList<Song> getTheSongList()
    {
        return this.theMediaList;
    }

    @Override
    public ArrayList<String> getTheMediaNameList() 
    {
        theMediaNameList = new ArrayList<>();
        
        for(int i = 0; i < this.theMediaList.size(); i++)
        {
            String theSongName = this.theMediaList.get(i).getMediaName();
            theMediaNameList.add(theSongName);
        }
        
        return theMediaNameList;
    }
}
