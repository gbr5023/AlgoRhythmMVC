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
