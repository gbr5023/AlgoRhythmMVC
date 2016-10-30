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

public class LoginCntl 
{
    private UserList theUserList; // declare theUserList object of class UserList
    private LoginUIv2 theLoginUIv2; // declare theLoginUIv2 object of class LoginUIv2
    private NavigationCntl theNavigationCntl; // declare theNavigationCntl object of class NavigationCntl
    
    /**
     * LoginCntl(): Notifies that the program is now at the LoginCntl.
     *              Instantiates a new UserList object = theUserList.
     *              Instantiates a new LoginUIv2 object = theLoginUIv2.
     */
    public LoginCntl()
    {
        System.out.println("Made it to LoginCntl");
        theUserList = new UserList();
        theLoginUIv2 = new LoginUIv2(this);
    }
    
    /**
     * requestNavigationCntl(): Instantiates a new NavigationCntl object = theNavigationCntl.
                                Takes the program from the LoginCntl to the NavigationCntl
                                if authenticate() in UserList and requestAuthenticate()
                                in LoginCntl both return true.
     */
    public void requestNavigationCntl()
    {
        this.theNavigationCntl = new NavigationCntl();
    }
    
    /**
     * requestAuthenticate(): calls theUserList.authenticate() sending user-entered
                              username and password to request an authentication and
                              theUserList.authenticate() returns a boolean and sets it to
                              the boolean authenticated in this.requestAuthenticate().
     * @param usernameToCheck
     * @param passwordToCheck
     * @return authenticated and sends signal to LoginUIv2 to close the JFrame,
     *                       call theLoginCntl.requestNavigationCntl, initialize
     *                       a new NavigationCntl object = theNavigationCntl, and
     *                       take the program from LoginCntl to NavigationCntl
     */
    public boolean requestAuthenticate(String usernameToCheck, char[] passwordToCheck)
    {
        //theUserList.printUsers(); //for check
        boolean authenticated = theUserList.authenticate(usernameToCheck, passwordToCheck);

        return authenticated;
    }
}
