package prj5;

import java.util.Comparator;

/**
 * Compares songs by date comparator
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * @version 04-19-2017
 */

public class DateComparator implements Comparator<Song> {
    /**
     * Compares song by year
     * 
     * @param s1
     *            Song
     * @param s2
     *            Song
     * @return a comparison number
     */
    public int compare(Song s1, Song s2) {
        return s1.getDate() - s2.getDate();
    }

}
