/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorhythmmvc;

/**
 *
 * @author Gisward
 */
public class Song extends Media
{
    private String songName;
    private String artistName;
    private double songLength;
    private int songRating;
    
    public Song()
    {
        songName = "";
        artistName = "";
        songLength = 0.0;
        songRating = 0;
    }
    
    public Song(String newSong, String newArtist, double newLength, int newRating)
    {
        this.songName = newSong;
        this.artistName = newArtist;
        this.songLength = newLength;
        this.songRating = newRating;
    }
    
    @Override
    public String getMediaName()
    {
        return this.songName;
    }
    
    @Override
    public void setMediaName(String newSong)
    {
        this.songName = newSong;
    }
    
    @Override
    public String getMediaArtist()
    {
        return this.artistName;
    }
    
    @Override
    public void setMediaArtist(String newArtist)
    {
        this.artistName = newArtist;
    }
    
    @Override
    public double getMediaLength()
    {
        return this.songLength;
    }
    
    @Override
    public void setMediaLength(double newLength)
    {
        this.songLength = newLength;
    }
    
    @Override
    public int getMediaRating()
    {
        return this.songRating;
    }
    
    @Override
    public void setMediaRating(int newRating)
    {
        this.songRating = newRating;
    }
}
