/* Partner: Jennifer Rhee
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

import java.util.ArrayList;

/**
 *
 * @author Gisward
 */
public class UserList 
{
    private ArrayList<User> theListOfUsers;
    private User theUser;
    
    /**
     * UserList(): initializes ArrayList<User> theListOfUsers and adds a 100 new
     *             User objects, see below in for loop.
     */
    public UserList()
    {
        theListOfUsers = new ArrayList<>();

        for(int i = 0; i <= 100; i++)
        {
            // add 100 new User objects of String username("giselle" + i) and
            // String literal password "abc123" which is converted into a character
            // array (.toCharArray()) which is the default type of JPasswordField
            theListOfUsers.add(new User("giselle" + i, ("abc123").toCharArray()));
        }
    }
    
    /**
     * printUsers(): prints all User objects in theListOfUsers if user must verify
     *               that theListOfUsers was initialized with 100 User objects.
     *                
     */
    public void printUsers()
    {
        for(int i = 0; i < theListOfUsers.size(); i++)
        {
            System.out.println("Username: " + theListOfUsers.get(i).getUsername() 
                               + " // Password: " + String.valueOf(theListOfUsers.get(i).getPassword()));
        }
    }
    
    /**
     * authenticate(): authenticates user-entered username and password against the
     *                 theListOfUsers ArrayList of User objects to find a match.
     *                 If match is found, in both nameMatch and passwordMatch
     *                 booleans, then boolean authenticated returns true and sends
     *                 this to LoginCntl which signals the LoginUIv2 class to request
     *                 initialization of NavigationCntl method in LoginCntl.
     * @param usernameToCheck
     * @param passwordToCheck
     * @return authenticated
     */
    public boolean authenticate(String usernameToCheck, char[] passwordToCheck)
    {
        boolean authenticated = false;
        boolean nameMatch = false;
        boolean passwordMatch = false;
        
        for(int i = 0; i < (theListOfUsers.size()); i++)
        {
            nameMatch = usernameToCheck.equals(theListOfUsers.get(i).getUsername());
            passwordMatch = String.valueOf(passwordToCheck).equals(String.valueOf(theListOfUsers.get(i).getPassword()));
            
            if(nameMatch && passwordMatch)
            {
                authenticated = true;
                break;
            }
            else
            {
                authenticated = false;
            }
        }
        
        return authenticated;
    }
}
