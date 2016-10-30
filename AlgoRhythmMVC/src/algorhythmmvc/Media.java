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
public abstract class Media 
{
    private String mediaName;
    private String artistName;
    private double mediaLength;
    private int mediaRating;
    
    public Media()
    {
        mediaName = "";
        artistName = "";
        mediaLength = 0.0;
        mediaRating = 0;
    }
    
    public Media(String newMedia, String newArtist)
    {
        this.mediaName = newMedia;
        this.artistName = newArtist;
    }
    
    public Media(String newMedia, String newArtist, double newLength, int newRating)
    {
        this.mediaName = newMedia;
        this.artistName = newArtist;
        this.mediaLength = newLength;
        this.mediaRating = newRating;
    }
    
    public abstract String getMediaName();
    public abstract void setMediaName(String newMedia);
    public abstract String getMediaArtist();
    public abstract void setMediaArtist(String newArtist);
    public abstract double getMediaLength();
    public abstract void setMediaLength(double newLength);
    public abstract int getMediaRating();
    public abstract void setMediaRating(int newRating);
}
