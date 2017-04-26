package prj5;

import java.util.Comparator;

/**
 * Compares songs by genre
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * @version 04-19-2017
 *
 */

public class GenreComparator implements Comparator<Song> {
    /**
     * Compare method
     * 
     * @param s1
     *            Song
     * @param s2
     *            Song
     * @return comparison number
     */
    public int compare(Song s1, Song s2) {
        return s1.getGenre().compareTo(s2.getGenre());
    }

}
