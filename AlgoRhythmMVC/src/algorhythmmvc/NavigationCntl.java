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
public class NavigationCntl 
{
    private MainMenuUI theMainMenuUI; // declare theMainMenuUI object of class MainMenuUI
    private MediaListCntl theMediaListCntl; // declare theMediaListCntl object of class MediaListCntl
    private MediaMenuUI theMediaMenuUI;
    
    /**
     * NavigationCntl(): Notifies that the program is now at the NavigationCntl
     *                   Instantiates a new MainMenuUI object = theMainMenuUI.
     */
    public NavigationCntl()
    {
        System.out.println("Made it to NavigationCntl");
        requestMainMenu();
    }
    
    public void requestMainMenu()
    {
        theMainMenuUI = new MainMenuUI(this);
    }
    
    /**
     * requestMediaListCntl(): Instantiates a new MediaListCntl object = theMediaListCntl.
     */
    public void requestMediaListCntl()
    {
        this.theMediaListCntl = new MediaListCntl();
    }
}
