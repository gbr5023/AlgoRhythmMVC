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
 */
public class Song extends Media
{
    private String songName;
    private String artistName;
    private double songLength;
    private double songAvgRating;
    private ArrayList<Double> theMediaRatingList;
    private String spotifyURL = "";
    RatingList theRatingList;
    
    public Song()
    {
        System.out.println("Called: Song()");
    }
    
    
    public Song(String newSong, String newArtist, double newLength)
    {
        super(newSong, newArtist, newLength);
    }
    
    
    public Song(String importSongString)
    {
        super(importSongString);
        String delimiter = "\\t";
        String[] tempSongArray = importSongString.split(delimiter);
        this.spotifyURL = tempSongArray[4];
    }
    
    public Song(double newRating)
    {
        this.songAvgRating = newRating;
        theRatingList = new RatingList(this.songAvgRating);
    }
    
    /*
    public Song(String newSong, String newArtist, double newLength)
    {
        this.theMediaRatingList = new ArrayList<>();
        this.songName = newSong;
        this.artistName = newArtist;
        this.songLength = newLength;
    }
    
    public Song(String importSongString)
    {
        
        
        
        for(int i = 0; i <tempSongArray.length; i++)
        {
            String str = tempSongArray[i];
            System.out.println(str);
        }
        
    }
    */
    public double getMediaAvgRating()
    {
        theRatingList.getMediaAvgRating();
        
        return this.songAvgRating;
    }
    
    @Override
    public String getMediaName()
    {
        return this.songName;
    }
    
    @Override
    public void setMediaName(String newSong)
    {
        this.songName = newSong;
    }
    
    @Override
    public String getMediaArtist()
    {
        return this.artistName;
    }
    
    @Override
    public void setMediaArtist(String newArtist)
    {
        this.artistName = newArtist;
    }
    
    @Override
    public double getMediaLength()
    {
        return this.songLength;
    }
    
    @Override
    public void setMediaLength(double newLength)
    {
        this.songLength = newLength;
    }  

    @Override
    public ArrayList<Double> getMediaRatingList() {
        return this.theMediaRatingList;
    }
}
