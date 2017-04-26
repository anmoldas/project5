package prj5;

import java.util.ArrayList;
import student.TestCase;

/**
 * Tests SortData
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * @version 2017.04.19
 *
 */
public class SortDataTest extends TestCase {
    private LinkedList<Song> songList;
    private LinkedList<User> userList;
    private SortData sort;


    /**
     * Sets up the test class
     */
    public void setUp() {
        songList = new LinkedList<Song>();
        userList = new LinkedList<User>();
        Song s1 = new Song("c", "c", "c", 3);
        Song s2 = new Song("b", "b", "b", 3);
        Song s3 = new Song("c", "a", "c", 2);
        Song s4 = new Song("a", "b", "a", 4);
        Song s5 = new Song("b", "a", "b", 1);
        User u1 = new User(HobbyEnum.READ, MajorEnum.CMDA_MATH,
            RegionEnum.OUTSIDE_US);
        User u2 = new User(HobbyEnum.ART, MajorEnum.COMPSCI,
            RegionEnum.OUTSIDE_US);
        User u3 = new User(HobbyEnum.SPORTS, MajorEnum.CMDA_MATH,
            RegionEnum.OUTSIDE_US);
        User u4 = new User(HobbyEnum.READ, MajorEnum.OTHER_ENGE,
            RegionEnum.OUTSIDE_US);
        User u5 = new User(HobbyEnum.READ, MajorEnum.CMDA_MATH,
            RegionEnum.OUTSIDE_US);
        songList.add(s1);
        songList.add(s2);
        songList.add(s3);
        songList.add(s4);
        songList.add(s5);
        ArrayList<String> u1Heard = new ArrayList<String>();
        ArrayList<String> u1Liked = new ArrayList<String>();
        u1Heard.add("Yes");
        u1Liked.add("Yes");
        u1Heard.add("Yes");
        u1Liked.add("Yes");
        u1Heard.add("Yes");
        u1Liked.add("Yes");
        u1Heard.add("Yes");
        u1Liked.add("Yes");
        u1Heard.add("Yes");
        u1Liked.add("Yes");
        ArrayList<String> u2Heard = new ArrayList<String>();
        ArrayList<String> u2Liked = new ArrayList<String>();
        u2Heard.add("Yes");
        u2Liked.add("Yes");
        u2Heard.add("No");
        u2Liked.add("No");
        u2Heard.add("Yes");
        u2Liked.add("No");
        u2Heard.add("No");
        u2Liked.add("No");
        u2Heard.add("Yes");
        u2Liked.add("Yes");
        ArrayList<String> u3Heard = new ArrayList<String>();
        ArrayList<String> u3Liked = new ArrayList<String>();
        u3Heard.add("Yes");
        u3Liked.add("Yes");
        u3Heard.add("No");
        u3Liked.add("No");
        u3Heard.add("Yes");
        u3Liked.add("No");
        u3Heard.add("No");
        u3Liked.add("No");
        u3Heard.add("Yes");
        u3Liked.add("Yes");
        ArrayList<String> u4Heard = new ArrayList<String>();
        ArrayList<String> u4Liked = new ArrayList<String>();
        u4Heard.add("Yes");
        u4Liked.add("Yes");
        u4Heard.add("No");
        u4Liked.add("No");
        u4Heard.add("Yes");
        u4Liked.add("No");
        u4Heard.add("No");
        u4Liked.add("No");
        u4Heard.add("Yes");
        u4Liked.add("Yes");
        ArrayList<String> u5Heard = new ArrayList<String>();
        ArrayList<String> u5Liked = new ArrayList<String>();
        u5Heard.add("Yes");
        u5Liked.add("Yes");
        u5Heard.add("Yes");
        u5Liked.add("Yes");
        u5Heard.add("Yes");
        u5Liked.add("Yes");
        u5Heard.add("Yes");
        u5Liked.add("Yes");
        u5Heard.add("Yes");
        u5Liked.add("Yes");
        u1.setHeard(u1Heard);
        u1.setLiked(u1Liked);
        u2.setHeard(u2Heard);
        u2.setLiked(u2Liked);
        u3.setHeard(u3Heard);
        u3.setLiked(u3Liked);
        u4.setHeard(u4Heard);
        u4.setLiked(u4Liked);
        u5.setHeard(u5Heard);
        u5.setLiked(u5Liked);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);
        sort = new SortData(songList, userList);

    }


    /**
     * tests the set percent methods
     */

    public void testSetPercent() {
        sort.setPercentHobby(songList, userList);
        assertEquals(songList.get(0).getArtHeardPercent(), 100);
        sort.setPercentMajor(songList, userList);
        assertEquals(songList.get(0).getEngeHeardPercent(), 100);
        sort.setPercentRegion(songList, userList);
        assertEquals(songList.get(0).getSouthLikedPercent(), 0);

    }


    /**
     * tests the sort by categories methods
     */

    public void testSort() {
        songList = sort.sortByTitle(songList);
        sort.setSongList(songList);
        assertEquals(songList.get(0).getSongTitle(), "a");
        songList = sort.sortByGenre(songList);
        sort.setSongList(songList);
        assertEquals(songList.get(0).getGenre(), "a");
        assertEquals(songList.get(1).getGenre(), "b");
        assertEquals(songList.get(2).getGenre(), "b");
        assertEquals(songList.get(3).getGenre(), "c");
        assertEquals(songList.get(4).getGenre(), "c");
        songList = sort.sortByDate(songList);
        sort.setSongList(songList);
        assertEquals(songList.get(0).getDate(), 1);
        assertEquals(songList.get(1).getDate(), 2);
        assertEquals(songList.get(2).getDate(), 3);
        assertEquals(songList.get(3).getDate(), 3);
        assertEquals(songList.get(4).getDate(), 4);
        
        songList = sort.sortByArtist(songList);
        sort.setSongList(songList);
        assertEquals(songList.get(0).getArtistName(), "a");
        assertEquals(songList.get(1).getArtistName(), "b");
        assertEquals(songList.get(2).getArtistName(), "b");
        assertEquals(songList.get(3).getArtistName(), "c");
        assertEquals(songList.get(4).getArtistName(), "c");

        songList = sort.sortByArtist(songList);
        sort.setSongList(songList);
        assertEquals(songList.get(0).getArtistName(), "a");
        songList = sort.sortByDate(songList);
        sort.setSongList(songList);
        assertEquals(songList.get(0).getDate(), 1);
        sort.setUserList(sort.getUserList());
        songList = sort.getSongList();
        
        

    }

}
