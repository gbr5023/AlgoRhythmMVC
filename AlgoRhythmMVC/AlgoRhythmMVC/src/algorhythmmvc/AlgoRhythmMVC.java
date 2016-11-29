/*
• Add search and sort performance test functionality to AlgoRhythm
• This will include the following
    • A Test Controller to manage the performance test
        – Have 3 representations of the Song data including 
            – ArrayList(native)
            – array
            – and one other Java collection of your choice
        – A Stopwatch
            – measure the performance of search and sort operations on the 
              3 different data representations
    • A Test UI to run the tests and display test results
    • TestUI will allow users to run timed tests for:
        – sorting the 3 different date representations
        – searching the 3 different representations
• Due Monday Dec 5 @11:50pm

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

public class AlgoRhythmMVC 
{

    /*
        main(): Begins program Takes program to theLoginCntl.
    */
    public static void main(String[] args) 
    {
        //LoginCntl theLoginCntl = new LoginCntl();
        ExternalDataCntl theExternalDataCntl = new ExternalDataCntl();
    }

}
