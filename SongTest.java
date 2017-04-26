package prj5;

import org.junit.Test;

/**
 * Tests Song
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * @version 2017.04.19
 *
 */
public class SongTest extends student.TestCase {

    private Song humble;


    /**
     * Sets up the test class
     */
    public void setUp() {
        humble = new Song("Kendrick Lamar", "Humble", "Hip Hop", 2017);

    }


    /**
     * tests getArtistName()
     */

    public void testIncorrectArtistName() {

        Exception thrown = null;
        try {
            new Song("", "Humble", "Hip", 1000);
        }
        catch (Exception exc) {
            thrown = exc;
        }
        assertEquals(true, thrown instanceof IllegalArgumentException);
    }


    /**
     * tests getSongTitle()
     */

    public void testIncorrectSongTitle() {

        Exception thrown = null;
        try {
            new Song("Kendrick", "", "Hip", 1);
        }
        catch (Exception exc) {
            thrown = exc;
        }
        assertEquals(true, thrown instanceof IllegalArgumentException);
    }


    /**
     * tests getGenre()
     */

    public void testIncorrectGenre() {

        Exception thrown = null;
        try {
            new Song("Kendrick", "Humble", "", 1);
        }
        catch (Exception exc) {
            thrown = exc;
        }
        assertEquals(true, thrown instanceof IllegalArgumentException);
    }


    /**
     * tests getDate()
     */

    public void testIncorrectDate() {

        Exception thrown = null;
        try {
            new Song("Kendrick", "Humble", "Hip", -1);
        }
        catch (Exception exc) {
            thrown = exc;
        }
        assertEquals(true, thrown instanceof IllegalArgumentException);
    }


    /**
     * tests getArtistName()
     */

    @Test
    public void testGetArtistName() {
        assertEquals("Kendrick Lamar", humble.getArtistName());
    }


    /**
     * tests getSongTitle()
     */

    @Test
    public void testGetSongTitle() {
        assertEquals("Humble", humble.getSongTitle());
    }


    /**
     * tests getGenre()
     */

    @Test
    public void testGetGenre() {
        assertEquals("Hip Hop", humble.getGenre());
    }


    /**
     * tests getDate()
     */
    @Test
    public void testGetDate() {
        assertEquals(2017, humble.getDate());
    }


    /**
     * tests liked and heard percent functions
     */
    public void testLiked() {
        humble.setMusicHeardPercent(100);
        assertEquals(100, humble.getMusicHeardPercent());
        humble.setMusicLikedPercent(100);
        assertEquals(100, humble.getMusicLikedPercent());

        humble.setSportsHeardPercent(100);
        assertEquals(100, humble.getSportsHeardPercent());
        humble.setSportsLikedPercent(100);
        assertEquals(100, humble.getSportsLikedPercent());

        humble.setReadHeardPercent(100);
        assertEquals(100, humble.getReadHeardPercent());
        humble.setReadLikedPercent(100);
        assertEquals(100, humble.getReadLikedPercent());

        humble.setArtHeardPercent(100);
        assertEquals(100, humble.getArtHeardPercent());
        humble.setArtLikedPercent(100);
        assertEquals(100, humble.getArtLikedPercent());

        humble.setMathHeardPercent(100);
        assertEquals(100, humble.getMathHeardPercent());
        humble.setMathLikedPercent(100);
        assertEquals(100, humble.getMathLikedPercent());

        humble.setCompsciHeardPercent(100);
        assertEquals(100, humble.getCompsciHeardPercent());
        humble.setCompsciLikedPercent(100);
        assertEquals(100, humble.getCompsciLikedPercent());

        humble.setEngeHeardPercent(100);
        assertEquals(100, humble.getEngeHeardPercent());
        humble.setEngeLikedPercent(100);
        assertEquals(100, humble.getEngeLikedPercent());

        humble.setOtherHeardPercent(100);
        assertEquals(100, humble.getOtherHeardPercent());
        humble.setOtherLikedPercent(100);
        assertEquals(100, humble.getOtherLikedPercent());

        humble.setSouthHeardPercent(100);
        assertEquals(100, humble.getSouthHeardPercent());
        humble.setSouthLikedPercent(100);
        assertEquals(100, humble.getSouthLikedPercent());

        humble.setNorthHeardPercent(100);
        assertEquals(100, humble.getNorthHeardPercent());
        humble.setNorthLikedPercent(100);
        assertEquals(100, humble.getNorthLikedPercent());

        humble.setRestHeardPercent(100);
        assertEquals(100, humble.getRestHeardPercent());
        humble.setRestLikedPercent(100);
        assertEquals(100, humble.getRestLikedPercent());

        humble.setOutsideHeardPercent(100);
        assertEquals(100, humble.getOutsideHeardPercent());
        humble.setOutsideLikedPercent(100);
        assertEquals(100, humble.getOutsideLikedPercent());
    }

}


