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

/**
 *
 * @author gbr5023
*/
 
public class Stopwatch 
{

    /**
     * @param args the command line arguments
     
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Stopwatch sw = new Stopwatch();
        SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel();
        sw.stop();
        System.out.println(sw.getElapsedTime());
        LoginCntl theLoginCntl = new LoginCntl();
    }    
    */
}

/*private long startTime;
    private long stopTime;
    private long elapsedTime;
    
    public Stopwatch()
    {
        reset();
    }
    
    public void reset()
    {
        this.startTime = 0;
        this.stopTime = 0;
        this.elapsedTime = 0;
    }
    
    public void stop()
    {
        this.stopTime = System.currentTimeMillis();
        this.elapsedTime = (this.stopTime - this.startTime);
    }
    /**
     * @return the startTime
     
    public long getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the stopTime
     
    public long getStopTime() {
        return stopTime;
    }

    /**
     * @param stopTime the stopTime to set
     
    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    /*
     * @return the elapsedTime
     
    /*public long getElapsedTime() {
        return elapsedTime;
    //}

    /*
     * @param elapsedTime the elapsedTime to set
     
    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
*/

