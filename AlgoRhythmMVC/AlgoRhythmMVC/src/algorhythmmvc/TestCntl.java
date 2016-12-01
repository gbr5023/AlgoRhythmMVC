/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorhythmmvc;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author gbr5023
 */
public class TestCntl 
{
    private ArrayList<Media> theMediaAL = null;
    private Media[] theMediaAR = null;
    // Your third data representation
    
    private TestUI theTestUI = null;
    private NavigationCntl theNavigationCntl = null;
    
    private Stopwatch sw = null;
    
    public TestCntl()
    {
        theMediaAL = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getTheMediaList();
        theMediaAR = theMediaAL.toArray(theMediaAR);
        sw = new Stopwatch();
    }
    
    
    
    // for arrayst use arrays.sort, arrays.binarysearch
    // for others use collections.srt, collections.binary search
    /*
    public long sortAL()
    {
        Collections.shuffle(theMediaAL);
        
        sw.reset();
        sw.start();
        sw.stop();
        
        return sw.getElapsedTime();
    }
*/
}
