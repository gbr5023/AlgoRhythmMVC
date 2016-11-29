/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 

package stopwatch;

/**
 *
 * @author gbr5023
 
public class Main 
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

}

 

package algorhythmmvc;

/**
 *
 * @author gbr5023
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 

package stopwatch;

/**
 *
 * @author gbr5023
 
public class Stopwatch 
{
    private long startTime;
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
}
