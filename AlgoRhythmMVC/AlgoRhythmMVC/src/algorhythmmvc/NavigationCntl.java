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
public class NavigationCntl 
{
    private MainMenuUI theMainMenuUI; // declare theMainMenuUI object of class MainMenuUI
    private MediaListCntl theMediaListCntl; // declare theMediaListCntl object of class MediaListCntl
    private CRUDMenuUI theCRUDMenuUI;
    
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
