/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private String colMediaArray[] = {"Song Name", "Artist", "Length", "Rating"};
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
        String colMediaArray[] = {"Song Name", "Artist", "Length", "Rating"};
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
