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
public abstract class Media implements Serializable
{
    private String mediaName = "";
    private String artistName = "";
    private double mediaLength = 0;
    private double mediaAvgRating = 0;
    private String genre = "";
    private String year = "";
    private ArrayList<Double> mediaRating;
    
    public Media()
    {
        System.out.println("Called: Media()");
    }
    
    public Media(String importMediaString)
    {
        String delimiter = "\\t";
        String[] tempMediaArray = importMediaString.split(delimiter);
        this.genre = tempMediaArray[0];
        this.mediaName = tempMediaArray[1];
        this.artistName = tempMediaArray[2];
        this.year = tempMediaArray[3];
    }
    
    public Media(String newMedia, String newArtist, double newLength)
    {
        this.mediaName = newMedia;
        this.artistName = newArtist;
        this.mediaLength = newLength;
    }
    
    public Media(String newMedia, String newArtist, double newLength, double newRating)
    {
        this.mediaName = newMedia;
        this.artistName = newArtist;
        this.mediaLength = newLength;
        this.mediaAvgRating = newRating;
    }
    
    public Media(String newMedia, String newArtist, String newYear, String newGenre)
    {
        this.mediaName = newMedia;
        this.artistName = newArtist;
        this.year = newYear;
        this.genre = newGenre;
    }
    
    public abstract String getMediaName();
    public abstract void setMediaName(String newMedia);
    public abstract String getMediaArtist();
    public abstract void setMediaArtist(String newArtist);
    public abstract double getMediaLength();
    public abstract void setMediaLength(double newLength);
    //public abstract RatingList getRatingList();
    //public abstract double setMediaAvgRating(double newRating);
    public abstract double getMediaAvgRating();
    public abstract ArrayList<Double> getMediaRatingList();
    //public abstract void addMediaRating(double newRating);
}
