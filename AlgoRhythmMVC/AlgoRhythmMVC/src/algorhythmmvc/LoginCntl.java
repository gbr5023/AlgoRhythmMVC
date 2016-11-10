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
