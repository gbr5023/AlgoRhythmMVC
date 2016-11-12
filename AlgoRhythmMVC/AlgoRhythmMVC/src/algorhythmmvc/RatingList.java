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
public class RatingList 
{
    ArrayList<Rating> songRatingList = new ArrayList<>(); 
    double songAvgRating;
    
    public RatingList(double newRating)
    {
        this.songRatingList.add(new Rating(newRating));
    }
    
    private void calculateMediaAvgRating() 
    {
        double sum = 0.0;
        //double currentRating = 0.0;
        for(int i = 0; i < this.songRatingList.size(); i++)
        {
            double currentRating = this.songRatingList.get(i).getRating();
            sum = (currentRating + sum);
            this.songAvgRating = (sum / this.songRatingList.size());
        }
        //this.songAvgRating = Math.round(this.songAvgRating)
    }

    public double getMediaAvgRating() 
    {
        this.calculateMediaAvgRating();
        return this.songAvgRating;
    }
    
    public ArrayList<Rating> getMediaRatingList() 
    {
        return this.songRatingList;
    }
}
