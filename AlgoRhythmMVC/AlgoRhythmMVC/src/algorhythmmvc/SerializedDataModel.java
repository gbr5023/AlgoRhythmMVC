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

/**
 *
 * @author gbr5023
 */
public class SerializedDataModel implements Serializable
{
    private UserList theUserList;
    private MediaList theMediaList;
    
    public SerializedDataModel()
    {
        if(this.theUserList == null)
        {
            this.theUserList = new UserList();
        }
        if(this.theMediaList == null)
        {
            this.theMediaList = new MediaList();
        }
    }
    
    public UserList getUserList()
    {
        return this.theUserList;
    }
    
    public MediaList getMediaList()
    {
        return this.theMediaList;
    }
    
    public void setUserList(UserList newUserList)
    {
        this.theUserList = newUserList;
    }
    
    public void setMediaList(MediaList newMediaList)
    {
        this.theMediaList = newMediaList;
    }
}
