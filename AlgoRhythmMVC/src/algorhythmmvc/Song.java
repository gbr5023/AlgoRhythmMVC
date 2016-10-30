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

/**
 *
 * @author Gisward
 */
public class Song extends Media
{
    private String songName;
    private String artistName;
    private double songLength;
    private int songRating;
    
    public Song()
    {
        songName = "";
        artistName = "";
        songLength = 0.0;
        songRating = 0;
    }
    
    public Song(String newSong, String newArtist, double newLength, int newRating)
    {
        this.songName = newSong;
        this.artistName = newArtist;
        this.songLength = newLength;
        this.songRating = newRating;
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
    public int getMediaRating()
    {
        return this.songRating;
    }
    
    @Override
    public void setMediaRating(int newRating)
    {
        this.songRating = newRating;
    }
}
