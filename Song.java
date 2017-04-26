package prj5;

/**
 * This class, Song, contains the functionality to create a
 * a song for the music visualization.
 *
 *
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * 
 * @version 4.19.2017
 */
public class Song {
    // Fields -------------------------------------------------------------

    private String artistName;
    private String songTitle;
    private String genre;
    private int date;
    private int readHeardPercent;
    private int readLikedPercent;
    private int artHeardPercent;
    private int artLikedPercent;
    private int sportsHeardPercent;
    private int sportsLikedPercent;
    private int musicHeardPercent;
    private int musicLikedPercent;
    private int mathHeardPercent;
    private int mathLikedPercent;
    private int compsciHeardPercent;
    private int compsciLikedPercent;
    private int engeHeardPercent;
    private int engeLikedPercent;
    private int otherHeardPercent;
    private int otherLikedPercent;
    private int southHeardPercent;
    private int southLikedPercent;
    private int northHeardPercent;
    private int northLikedPercent;
    private int restHeardPercent;
    private int restLikedPercent;
    private int outsideHeardPercent;
    private int outsideLikedPercent;


    // Constructor ----------------------------------------------------------
    /**
     * Constructor that creates a new song.
     * 
     * @param artistName
     *            name of the artist
     * @param songTitle
     *            title of the song
     * @param genre
     *            genre of the song
     * @param date
     *            year the song was released
     * @throws IllegalArgumentException
     *             when incorrect input given
     */
    public Song(String artistName, String songTitle, String genre, int date) {
        if (artistName.equals("") || songTitle.equals("") || genre.equals("")
            || date < 0) {
            throw new IllegalArgumentException("Incorrect input given");
        }

        this.artistName = artistName;
        this.songTitle = songTitle;
        this.genre = genre;
        this.date = date;
    }


    // Methods ---------------------------------------------------------
    /**
     * This method gets the name of the artist
     * 
     * @return name of artist
     */
    public String getArtistName() {
        return artistName;
    }


    /**
     * This method gets the name of the song
     * 
     * @return name of song
     */
    public String getSongTitle() {
        return songTitle;
    }


    /**
     * This method gets the genre of the song
     * 
     * @return genre of the song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * This method gets the year the song was released
     * 
     * @return year of song
     */
    public int getDate() {
        return date;
    }


    /**
     * Gets the percentage amount of math major users that heard the song
     * 
     * @return percentage amount
     */
    public int getMathHeardPercent() {
        return mathHeardPercent;
    }


    /**
     * Gets the percentage amount of compsci major users that heard the song
     * 
     * @return percentage amount
     */
    public int getCompsciHeardPercent() {
        return compsciHeardPercent;
    }


    /**
     * Gets the percentage amount of engineering major users that heard the song
     * 
     * @return percentage amount
     */
    public int getEngeHeardPercent() {
        return engeHeardPercent;
    }


    /**
     * Gets the percentage amount of other major users that heard the song
     * 
     * @return percentage amount
     */
    public int getOtherHeardPercent() {
        return otherHeardPercent;
    }


    /**
     * Sets the percentage amount of math major users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setMathHeardPercent(int percent) {
        mathHeardPercent = percent;
    }


    /**
     * Sets the percentage amount of compsci major users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setCompsciHeardPercent(int percent) {
        compsciHeardPercent = percent;
    }


    /**
     * Sets the percentage amount of enge major users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setEngeHeardPercent(int percent) {
        engeHeardPercent = percent;
    }


    /**
     * Sets the percentage amount of other major users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setOtherHeardPercent(int percent) {
        otherHeardPercent = percent;
    }


    /**
     * Get the percentage amount of math major liked users that liked the song
     * 
     * @return percentage amount
     */
    public int getMathLikedPercent() {
        return mathLikedPercent;
    }


    /**
     * Get the percentage amount of compsci major users that liked the song
     * 
     * @return percentage amount
     */
    public int getCompsciLikedPercent() {
        return compsciLikedPercent;
    }


    /**
     * Get the percentage amount of enge major users that liked the song
     * 
     * @return percentage amount
     */
    public int getEngeLikedPercent() {
        return engeLikedPercent;
    }


    /**
     * Get the percentage amount of other major users that liked the song
     * 
     * @return percentage amount
     */
    public int getOtherLikedPercent() {
        return otherLikedPercent;
    }


    /**
     * Set the percentage amount of math major users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setMathLikedPercent(int percent) {
        mathLikedPercent = percent;
    }


    /**
     * Set the percentage amount of compsci major users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setCompsciLikedPercent(int percent) {
        compsciLikedPercent = percent;
    }


    /**
     * Set the percentage amount of enge major users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setEngeLikedPercent(int percent) {
        engeLikedPercent = percent;
    }


    /**
     * Set the percentage amount of other major users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setOtherLikedPercent(int percent) {
        otherLikedPercent = percent;
    }


    /**
     * Gets the percentage amount of reading hobby users that heard the song
     * 
     * @return percentage amount
     */
    public int getReadHeardPercent() {
        return readHeardPercent;
    }


    /**
     * Gets the percentage amount of art hobby users that heard the song
     * 
     * @return percentage amount
     */
    public int getArtHeardPercent() {
        return artHeardPercent;
    }


    /**
     * Gets the percentage amount of music hobby users that heard the song
     * 
     * @return percentage amount
     */
    public int getMusicHeardPercent() {
        return musicHeardPercent;
    }


    /**
     * Gets the percentage amount of sports hobby users that heard the song
     * 
     * @return percentage amount
     */
    public int getSportsHeardPercent() {
        return sportsHeardPercent;
    }


    /**
     * Sets the percentage amount of reading hobby users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setReadHeardPercent(int percent) {
        readHeardPercent = percent;
    }


    /**
     * Sets the percentage amount of art hobby users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setArtHeardPercent(int percent) {
        artHeardPercent = percent;
    }


    /**
     * Sets the percentage amount of music hobby users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setMusicHeardPercent(int percent) {
        musicHeardPercent = percent;
    }


    /**
     * Sets the percentage amount of sport hobby users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setSportsHeardPercent(int percent) {
        sportsHeardPercent = percent;
    }


    /**
     * Get the percentage amount of reading hobby users that liked the song
     * 
     * @return percentage amount
     */
    public int getReadLikedPercent() {
        return readLikedPercent;
    }


    /**
     * Get the percentage amount of art hobby users that liked the song
     * 
     * @return percentage amount
     */
    public int getArtLikedPercent() {
        return artLikedPercent;
    }


    /**
     * Get the percentage amount of music hobby users that liked the song
     * 
     * @return percentage amount
     */
    public int getMusicLikedPercent() {
        return musicLikedPercent;
    }


    /**
     * Get the percentage amount of sport hobby users that liked the song
     * 
     * @return percentage amount
     */
    public int getSportsLikedPercent() {
        return sportsLikedPercent;
    }


    /**
     * Set the percentage amount of reading hobby users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setReadLikedPercent(int percent) {
        readLikedPercent = percent;
    }


    /**
     * Set the percentage amount of art hobby users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setArtLikedPercent(int percent) {
        artLikedPercent = percent;
    }


    /**
     * Set the percentage amount of music hobby users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setMusicLikedPercent(int percent) {
        musicLikedPercent = percent;
    }


    /**
     * Set the percentage amount of sports hobby users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setSportsLikedPercent(int percent) {
        sportsLikedPercent = percent;
    }


    /**
     * Gets the percentage amount of south east region users that heard the song
     * 
     * @return percentage amount
     */
    public int getSouthHeardPercent() {
        return southHeardPercent;
    }


    /**
     * Gets the percentage amount of north east users that heard the song
     * 
     * @return percentage amount
     */
    public int getNorthHeardPercent() {
        return northHeardPercent;
    }


    /**
     * Gets the percentage amount of rest of us region users that heard the song
     * 
     * @return percentage amount
     */
    public int getRestHeardPercent() {
        return restHeardPercent;
    }


    /**
     * Gets the percentage amount of outside of us region users that heard the
     * song
     * 
     * @return percentage amount
     */
    public int getOutsideHeardPercent() {
        return outsideHeardPercent;
    }


    /**
     * Sets the percentage amount of south east users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setSouthHeardPercent(int percent) {
        southHeardPercent = percent;
    }


    /**
     * Sets the percentage amount of north east users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setNorthHeardPercent(int percent) {
        northHeardPercent = percent;
    }


    /**
     * Sets the percentage amount of rest of us region users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setRestHeardPercent(int percent) {
        restHeardPercent = percent;
    }


    /**
     * Sets the percentage amount of outside of us users that heard the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setOutsideHeardPercent(int percent) {
        outsideHeardPercent = percent;
    }


    /**
     * Get the percentage amount of south east users that liked the song
     * 
     * @return percentage amount
     */
    public int getSouthLikedPercent() {
        return southLikedPercent;
    }


    /**
     * Get the percentage amount of north east users that liked the song
     * 
     * @return percentage amount
     */
    public int getNorthLikedPercent() {
        return northLikedPercent;
    }


    /**
     * Get the percentage amount of rest of us users that liked the song
     * 
     * @return percentage amount
     */
    public int getRestLikedPercent() {
        return restLikedPercent;
    }


    /**
     * Get the percentage amount of outside of us users that liked the song
     * 
     * @return percentage amount
     */
    public int getOutsideLikedPercent() {
        return outsideLikedPercent;
    }


    /**
     * Set the percentage amount of south east users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setSouthLikedPercent(int percent) {
        southLikedPercent = percent;
    }


    /**
     * Set the percentage amount of north east users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setNorthLikedPercent(int percent) {
        northLikedPercent = percent;
    }


    /**
     * Set the percentage amount of rest of us users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setRestLikedPercent(int percent) {
        restLikedPercent = percent;
    }


    /**
     * Set the percentage amount of outside of us users that liked the song
     * 
     * @param percent
     *            to set the data to
     */
    public void setOutsideLikedPercent(int percent) {
        outsideLikedPercent = percent;
    }

}
