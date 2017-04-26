package prj5;

import java.util.ArrayList;
import student.TestCase;

/**
 * Tests User class
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * @version 04-19-2017
 *
 */

public class UserTest extends TestCase {
    private User u1;


    /**
     * Constructor
     */

    public void setUp() {

        u1 = new User(HobbyEnum.READ, MajorEnum.COMPSCI, RegionEnum.NORTH_EAST);

    }


    /**
     * Tests getHobby
     */
    public void testGetHobby() {
        assertEquals(u1.getHobby(), HobbyEnum.READ);
    }


    /**
     * tests getMajor
     */
    public void testGetMajor() {
        assertEquals(u1.getMajor(), MajorEnum.COMPSCI);
    }


    /**
     * tests getRegion
     */
    public void testGetRegion() {
        assertEquals(u1.getRegion(), RegionEnum.NORTH_EAST);
    }
    /**
     * tests getHeard()
     */
    public void testGetHeard()
    {
        ArrayList<String> heard = new ArrayList<String>();
        heard.add("Yes");
        u1.setHeard(heard);
        assertEquals(u1.getHeard(), heard);
    }
    /**
     * tests getLiked()
     */
    public void testGetLiked()
    {
        ArrayList<String> liked = new ArrayList<String>();
        liked.add("Yes");
        u1.setLiked(liked);
        assertEquals(u1.getLiked(), liked);
    }

}
