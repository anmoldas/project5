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
public class SortData {
    private LinkedList<Song> songList;
    private LinkedList<User> userList;


    /**
     * Constructor
     * 
     * @param songs
     *            linked list of songs
     * @param users
     *            linked list of users
     **/

    public SortData(LinkedList<Song> songs, LinkedList<User> users) {
        songList = songs;
        userList = users;

    }


    /**
     * Sets the percentage for the heard and like
     * 
     * @param song
     *            linked list of song
     * @param user
     *            linked list of user
     */
    public static void setPercentHobby(
        LinkedList<Song> song,
        LinkedList<User> user) {
        int[] readHeardPercent = calcHeardPercentHobby(user, HobbyEnum.READ,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);

            s.setReadHeardPercent(readHeardPercent[i]);
        }
        int[] readLikedPercent = calcLikedPercentHobby(user, HobbyEnum.READ,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setReadLikedPercent(readLikedPercent[i]);
        }
        int[] artHeardPercent = calcHeardPercentHobby(user, HobbyEnum.ART,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setArtHeardPercent(artHeardPercent[i]);
        }
        int[] artLikedPercent = calcLikedPercentHobby(user, HobbyEnum.ART,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setArtLikedPercent(artLikedPercent[i]);
        }
        int[] sportsHeardPercent = calcHeardPercentHobby(user, HobbyEnum.SPORTS,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setSportsHeardPercent(sportsHeardPercent[i]);
        }
        int[] sportsLikedPercent = calcLikedPercentHobby(user, HobbyEnum.SPORTS,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setSportsLikedPercent(sportsLikedPercent[i]);
        }
        int[] musicHeardPercent = calcHeardPercentHobby(user, HobbyEnum.MUSIC,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setMusicHeardPercent(musicHeardPercent[i]);
        }
        int[] musicLikedPercent = calcLikedPercentHobby(user, HobbyEnum.MUSIC,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setMusicLikedPercent(musicLikedPercent[i]);
        }

    }


    /**
     * Sets the percentage for the heard and like
     * 
     * @param song
     *            linked list of song
     * @param user
     *            linked list of user
     */
    public static void setPercentMajor(
        LinkedList<Song> song,
        LinkedList<User> user) {
        int[] mathHeardPercent = calcHeardPercentMajor(user,
            MajorEnum.CMDA_MATH, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);

            s.setMathHeardPercent(mathHeardPercent[i]);
        }
        int[] mathLikedPercent = calcLikedPercentMajor(user,
            MajorEnum.CMDA_MATH, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setMathLikedPercent(mathLikedPercent[i]);
        }
        int[] compsciHeardPercent = calcHeardPercentMajor(user,
            MajorEnum.COMPSCI, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setCompsciHeardPercent(compsciHeardPercent[i]);
        }
        int[] compsciLikedPercent = calcLikedPercentMajor(user,
            MajorEnum.COMPSCI, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setCompsciLikedPercent(compsciLikedPercent[i]);
        }
        int[] engeHeardPercent = calcHeardPercentMajor(user,
            MajorEnum.OTHER_ENGE, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setEngeHeardPercent(engeHeardPercent[i]);
        }
        int[] engeLikedPercent = calcLikedPercentMajor(user,
            MajorEnum.OTHER_ENGE, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setEngeLikedPercent(engeLikedPercent[i]);
        }
        int[] otherHeardPercent = calcHeardPercentMajor(user, MajorEnum.OTHER,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setOtherHeardPercent(otherHeardPercent[i]);
        }
        int[] otherLikedPercent = calcLikedPercentMajor(user, MajorEnum.OTHER,
            song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setOtherLikedPercent(otherLikedPercent[i]);
        }

    }


    /**
     * Sets the percentage for the heard and like
     * 
     * @param song
     *            linked list of song
     * @param user
     *            linked list of user
     */
    public static void setPercentRegion(
        LinkedList<Song> song,
        LinkedList<User> user) {
        int[] southHeardPercent = calcHeardPercentRegion(user,
            RegionEnum.SOUTH_EAST, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);

            s.setSouthHeardPercent(southHeardPercent[i]);
        }
        int[] southLikedPercent = calcLikedPercentRegion(user,
            RegionEnum.NORTH_EAST, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setSouthLikedPercent(southLikedPercent[i]);
        }
        int[] northHeardPercent = calcHeardPercentRegion(user,
            RegionEnum.NORTH_EAST, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setNorthHeardPercent(northHeardPercent[i]);
        }
        int[] northLikedPercent = calcLikedPercentRegion(user,
            RegionEnum.NORTH_EAST, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setNorthLikedPercent(northLikedPercent[i]);
        }
        int[] restHeardPercent = calcHeardPercentRegion(user,
            RegionEnum.REST_OF_US, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            // System.out.println(restHeardPercent[i]);

            s.setRestHeardPercent(restHeardPercent[i]);
        }
        int[] restLikedPercent = calcLikedPercentRegion(user,
            RegionEnum.REST_OF_US, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            // System.out.println(restLikedPercent[i]);
            s.setRestLikedPercent(restLikedPercent[i]);
        }
        int[] outsideHeardPercent = calcHeardPercentRegion(user,
            RegionEnum.OUTSIDE_US, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setOutsideHeardPercent(outsideHeardPercent[i]);
        }
        int[] outsideLikedPercent = calcLikedPercentRegion(user,
            RegionEnum.OUTSIDE_US, song);
        for (int i = 0; i < song.size(); i++) {
            Song s = song.get(i);
            s.setOutsideLikedPercent(outsideLikedPercent[i]);
        }

    }


    /**
     * Calculate the percentage heard
     * 
     * @param users
     *            for each user
     * @param renum
     *            the favorite region of each user
     * @param songs
     *            for each song
     * @return array of percents
     */
    public static int[] calcHeardPercentRegion(
        LinkedList<User> users,
        RegionEnum renum,
        LinkedList<Song> songs) {
        ArrayList<String> heard = new ArrayList<String>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRegion() == renum) {
                for (int j = 0; j < users.get(i).getHeard().size(); j++) {

                    heard.add(users.get(i).getHeard().get(j));
                }
            }
        }

        int[] heardIt = new int[songs.size()];
        int[] didntHear = new int[songs.size()];

        int index = 0;
        for (int k = 0; k < heard.size(); k++) {
            if (index % songs.size() == 0) {
                index = 0;
            }
            if (heard.get(k).equals("Yes")) {
                heardIt[index]++;
            }
            if (heard.get(k).equals("No")) {
                didntHear[index]++;
            }
            index++;
        }
        int[] percent = new int[songs.size()];
        for (int a = 0; a < percent.length; a++) {
            int sum = heardIt[a] + didntHear[a];
            if (sum != 0) {
                percent[a] = (heardIt[a] * 100) / sum;
                // System.out.println(percent[a]);
                // System.out.println(renum);

            }
        }
        return percent;
    }


    /**
     * Calculate the percentage liked
     * 
     * @param users
     *            for each user
     * @param renum
     *            the favorite region of each user
     * @param songs
     *            for each song
     * @return array of percents
     */
    public static int[] calcLikedPercentRegion(
        LinkedList<User> users,
        RegionEnum renum,
        LinkedList<Song> songs) {
        ArrayList<String> liked = new ArrayList<String>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRegion() == renum) {
                for (int j = 0; j < users.get(i).getLiked().size(); j++) {
                    liked.add(users.get(i).getLiked().get(j));
                }
            }
        }

        int[] likedIt = new int[songs.size()];
        int[] didntLike = new int[songs.size()];

        int index = 0;
        for (int k = 0; k < liked.size(); k++) {
            if (index % songs.size() == 0) {
                index = 0;
            }
            if (liked.get(k).equals("Yes")) {
                likedIt[index]++;
            }
            if (liked.get(k).equals("No")) {
                didntLike[index]++;
            }
            index++;
        }
        int[] percent = new int[songs.size()];
        for (int a = 0; a < percent.length; a++) {
            int sum = likedIt[a] + didntLike[a];
            if (sum != 0) {
                percent[a] = (likedIt[a] * 100) / sum;

            }
        }
        return percent;
    }


    /**
     * Calculate the percentage heard
     * 
     * @param users
     *            for each user
     * @param menum
     *            the favorite major of each user
     * @param songs
     *            for each song
     * @return array of percents
     */
    public static int[] calcHeardPercentMajor(
        LinkedList<User> users,
        MajorEnum menum,
        LinkedList<Song> songs) {
        ArrayList<String> heard = new ArrayList<String>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getMajor() == menum) {
                for (int j = 0; j < users.get(i).getHeard().size(); j++) {
                    heard.add(users.get(i).getHeard().get(j));
                }
            }
        }

        int[] heardIt = new int[songs.size()];
        int[] didntHear = new int[songs.size()];

        int index = 0;
        for (int k = 0; k < heard.size(); k++) {
            if (index % songs.size() == 0) {
                index = 0;
            }
            if (heard.get(k).equals("Yes")) {
                heardIt[index]++;
            }
            if (heard.get(k).equals("No")) {
                didntHear[index]++;
            }
            index++;
        }
        int[] percent = new int[songs.size()];
        for (int a = 0; a < percent.length; a++) {
            int sum = heardIt[a] + didntHear[a];
            if (sum != 0) {
                percent[a] = (heardIt[a] * 100) / sum;

            }
        }
        return percent;
    }


    /**
     * Calculate the percentage liked
     * 
     * @param users
     *            for each user
     * @param menum
     *            the favorite major of each user
     * @param songs
     *            for each song
     * @return array of percents
     */
    public static int[] calcLikedPercentMajor(
        LinkedList<User> users,
        MajorEnum menum,
        LinkedList<Song> songs) {
        ArrayList<String> liked = new ArrayList<String>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getMajor() == menum) {
                for (int j = 0; j < users.get(i).getLiked().size(); j++) {
                    liked.add(users.get(i).getLiked().get(j));
                }
            }
        }

        int[] likedIt = new int[songs.size()];
        int[] didntLike = new int[songs.size()];

        int index = 0;
        for (int k = 0; k < liked.size(); k++) {
            if (index % songs.size() == 0) {
                index = 0;
            }
            if (liked.get(k).equals("Yes")) {
                likedIt[index]++;
            }
            if (liked.get(k).equals("No")) {
                didntLike[index]++;
            }
            index++;
        }
        int[] percent = new int[songs.size()];
        for (int a = 0; a < percent.length; a++) {
            int sum = likedIt[a] + didntLike[a];
            if (sum != 0) {
                percent[a] = (likedIt[a] * 100) / sum;

            }
        }
        return percent;
    }


    /**
     * Calculate the percentage heard
     * 
     * @param users
     *            for each user
     * @param henum
     *            the favorite hobby of each user
     * @param songs
     *            for each song
     * @return array of percents
     */
    public static int[] calcHeardPercentHobby(
        LinkedList<User> users,
        HobbyEnum henum,
        LinkedList<Song> songs) {
        ArrayList<String> heard = new ArrayList<String>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getHobby() == henum) {
                for (int j = 0; j < users.get(i).getHeard().size(); j++) {
                    heard.add(users.get(i).getHeard().get(j));
                }
            }
        }

        int[] heardIt = new int[songs.size()];
        int[] didntHear = new int[songs.size()];

        int index = 0;
        for (int k = 0; k < heard.size(); k++) {
            if (index % songs.size() == 0) {
                index = 0;
            }
            if (heard.get(k).equals("Yes")) {
                heardIt[index]++;
            }
            if (heard.get(k).equals("No")) {
                didntHear[index]++;
            }
            index++;
        }
        int[] percent = new int[songs.size()];
        for (int a = 0; a < percent.length; a++) {
            int sum = heardIt[a] + didntHear[a];
            if (sum != 0) {
                percent[a] = (heardIt[a] * 100) / sum;

            }
        }
        return percent;
    }


    /**
     * Calculate the percentage liked
     * 
     * @param users
     *            for each user
     * @param henum
     *            the favorite hobby of each user
     * @param songs
     *            for each song
     * @return array of percents
     */
    public static int[] calcLikedPercentHobby(
        LinkedList<User> users,
        HobbyEnum henum,
        LinkedList<Song> songs) {
        ArrayList<String> liked = new ArrayList<String>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getHobby() == henum) {
                for (int j = 0; j < users.get(i).getLiked().size(); j++) {
                    liked.add(users.get(i).getLiked().get(j));
                }
            }
        }

        int[] likedIt = new int[songs.size()];
        int[] didntLike = new int[songs.size()];

        int index = 0;
        for (int k = 0; k < liked.size(); k++) {
            if (index % songs.size() == 0) {
                index = 0;
            }
            if (liked.get(k).equals("Yes")) {
                likedIt[index]++;
            }
            if (liked.get(k).equals("No")) {
                didntLike[index]++;
            }
            index++;
        }
        int[] percent = new int[songs.size()];
        for (int a = 0; a < percent.length; a++) {
            int sum = likedIt[a] + didntLike[a];
            if (sum != 0) {
                percent[a] = (likedIt[a] * 100) / sum;

            }
        }
        return percent;
    }


    /**
     * Sorts by genre
     * 
     * @param song
     *            linked list of songs
     * @return LinkedList<Song> of sorted songs
     */
    public static LinkedList<Song> sortByGenre(LinkedList<Song> song) {

        GenreComparator gc = new GenreComparator();

        int length = song.size();

        for (int j = 1; j < length; j++) {
            Song entry = song.get(j);

            int i = j - 1;
            while (i > -1 && ((gc.compare(song.get(i), entry) > 0))) {
                song.set(i + 1, song.get(i));

                i--;
            }

            song.set(i + 1, entry);
        }
        return song;

    }


    /**
     * Sorts by artist name
     * 
     * @param song
     *            linked list of songs
     * @return LinkedList<Song> of sorted songs
     */
    public static LinkedList<Song> sortByArtist(LinkedList<Song> song) {

        ArtistComparator ac = new ArtistComparator();

        int length = song.size();

        for (int j = 1; j < length; j++) {
            Song entry = song.get(j);

            int i = j - 1;
            while (i > -1 && ((ac.compare(song.get(i), entry) > 0))) {
                song.set(i + 1, song.get(i));

                i--;
            }

            song.set(i + 1, entry);
        }
        return song;

    }


    /**
     * Sorts by song date
     * 
     * @param song
     *            linked list of songs
     * @return LinkedList<Song> of sorted songs
     */
    public static LinkedList<Song> sortByDate(LinkedList<Song> song) {

        DateComparator dc = new DateComparator();

        int length = song.size();

        for (int j = 1; j < length; j++) {
            Song entry = song.get(j);

            int i = j - 1;
            while (i > -1 && ((dc.compare(song.get(i), entry) > 0))) {
                song.set(i + 1, song.get(i));

                i--;
            }

            song.set(i + 1, entry);
        }
        return song;

    }


    /**
     * Sorts by title
     * 
     * @param song
     *            linked list of songs
     * @return LinkedList<Song> of sorted songs
     */
    public static LinkedList<Song> sortByTitle(LinkedList<Song> song) {
        TitleComparator tc = new TitleComparator();

        int length = song.size();

        for (int j = 1; j < length; j++) {
            Song entry = song.get(j);

            int i = j - 1;
            while (i > -1 && ((tc.compare(song.get(i), entry) > 0))) {
                song.set(i + 1, song.get(i));

                i--;
            }

            song.set(i + 1, entry);
        }
        return song;

    }


    /**
     * returns the song list
     * 
     * @return songList
     *         linked list of song
     */

    public LinkedList<Song> getSongList() {
        return songList;
    }


    /**
     * returns the user list
     * 
     * @return userList
     *         linked list of users
     */

    public LinkedList<User> getUserList() {
        return userList;
    }


    /**
     * sets the song list to the specified parameter
     * 
     * @param songs
     *            linked list of song
     */

    public void setSongList(LinkedList<Song> songs) {
        songList = songs;
    }


    /**
     * sets the user list to the specified parameter
     * 
     * @param users
     *            linked list of user
     */

    public void setUserList(LinkedList<User> users) {
        userList = users;
    }

}
