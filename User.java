package prj5;

import java.util.ArrayList;

/**
 * Gives the information about the user
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * @version 04-19-2017
 */
public class User {

    private HobbyEnum hobby;
    private MajorEnum major;
    private RegionEnum region;
    private ArrayList<String> heard;
    private ArrayList<String> liked;


    /**
     * Constructor
     * 
     * @param hobby
     *            user's favorite hobby
     * @param major
     *            user's major
     * @param region
     *            user's region
     **/
    public User(HobbyEnum hobby, MajorEnum major, RegionEnum region) {
        this.hobby = hobby;
        this.major = major;
        this.region = region;
        heard = new ArrayList<String>();
        liked = new ArrayList<String>();

    }


    /**
     * Gets the hobby
     * 
     * @return user's hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * Gets the major
     * 
     * @return user's major
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * Gets the region
     * 
     * @return user's region
     */
    public RegionEnum getRegion() {
        return region;
    }


    /**
     * returns the arraylist of heard answers
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getHeard() {
        return heard;
    }


    /**
     * returns the arraylist of liked answers
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getLiked() {
        return liked;
    }


    /**
     * sets a given arraylist to the arraylist of heard answers
     * 
     * @param temp
     *            arraylist of heard answers
     */
    public void setHeard(ArrayList<String> temp) {
        heard = temp;
    }


    /**
     * sets a given arraylist to the arraylist of liked answers
     * 
     * @param temp
     *            arraylist of liked answers
     */
    public void setLiked(ArrayList<String> temp) {
        liked = temp;
    }

}
