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
public class User 
{
    private String username;
    private char[] password;
    
    public User(String newUsername, char[] newPassword)
    {
        this.username = newUsername;
        this.password = newPassword;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void setUsername(String newUsername)
    {
        this.username = newUsername;
    }
    
    public char[] getPassword()
    {
        return this.password;
    }
    
    public void setPassword(char[] newPassword)
    {
        this.password = newPassword;
    }
}
