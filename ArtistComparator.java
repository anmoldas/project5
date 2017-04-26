package prj5;

import java.util.Comparator;

/**
 * Compares songs by artist name
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * @version 04-19-2017
 *
 */

public class ArtistComparator implements Comparator<Song> {

    /**
     * Compare method
     * 
     * @param s1
     *            Song
     * @param s2
     *            Song
     * @return a number
     */
    public int compare(Song s1, Song s2) {
        return s1.getArtistName().compareTo(s2.getArtistName());
    }

}
