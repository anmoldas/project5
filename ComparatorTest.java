package prj5;

/**
 * Tests comparator method
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * @version 04-19-2017
 *
 */

public class ComparatorTest extends student.TestCase {

    private ArtistComparator ac;
    private TitleComparator tc;
    private GenreComparator gc;
    private DateComparator yc;
    private Song s1;
    private Song s2;
    private Song s3;
    private Song s4;
    private Song s5;
    private Song s6;


    /**
     * Constructor
     */
    public void setUp() {
        ac = new ArtistComparator();
        gc = new GenreComparator();
        tc = new TitleComparator();
        yc = new DateComparator();
        s1 = new Song("Humble", "Kendrick Lamar", "Rap", 2017);
        s2 = new Song("Humble", "Kendrick Lamar", "Rap", 2017);
        s3 = new Song("Sacrifices", "Big Sean", "Rap", 2017);
        s4 = new Song("Sacrifices", "Drake", "Rap", 2017);
        s5 = new Song("Work", "Rihanna", "Hip Hop", 2016);
        s6 = new Song("Country Roads", "John Denver", "Country", 1971);
    }


    /**
     * Tests the artist comparator
     */
    public void testArtistComparator()

    {
        assertEquals(ac.compare(s1, s2), 0);
        assertTrue(ac.compare(s1, s3) < 0);
        assertFalse(ac.compare(s3, s4) < 0);

    }


    /**
     * Tests the genre comparator
     * 
     */
    public void testGenreComparator() {
        assertTrue(gc.compare(s5, s6) > 0);
        assertTrue(gc.compare(s6, s5) < 0);
        assertEquals(gc.compare(s1, s2), 0);
    }


    /**
     * Tests the date comparator
     */
    public void testDateComparator() {
        assertTrue(yc.compare(s1, s6) > 0);
        assertTrue(yc.compare(s6, s1) < 0);
        assertEquals(yc.compare(s1, s2), 0);
    }


    /**
     * Tests the title comparator
     */
    public void testTitleComparator() {
        assertTrue(tc.compare(s1, s5) < 0);
        assertTrue(tc.compare(s5, s1) > 0);
        assertEquals(tc.compare(s1, s2), 0);
    }

}
