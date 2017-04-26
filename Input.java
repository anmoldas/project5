package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import bag.Node;

/**
 * Runs the main method
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 *
 */

public class Input {
    private static String songFile;
    private static String userFile;
    private static LinkedList<Song> songList;
    private static LinkedList<User> userList;


    /**
     * main method
     * 
     * @throws FileNotFoundException
     *             if file is not found
     * @param args
     *            String array of file names
     *
     */

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length == 0) {
            songFile = "SongList.csv";
            userFile = "MusicSurveyData2017S.csv";

            songList = readSongFile(songFile);
            userList = readUserFile(userFile);

            new GUIWindow(new SortData(songList, userList));
        }
        else {
            songFile = args[1];
            userFile = args[0];

            songList = readSongFile(songFile);
            userList = readUserFile(userFile);

            new GUIWindow(new SortData(songList, userList));
        }

    }


    /**
     * This reads song file
     * 
     * @param filename
     *            song file
     * @return LinkedList<Song>
     * @throws FileNotFoundException
     *             if there is no file
     */
    public static LinkedList<Song> readSongFile(String filename)
        throws FileNotFoundException {

        LinkedList<Song> songList = new LinkedList<Song>();
        Scanner sc = new Scanner(new File(filename));
        sc.nextLine();
        while (sc.hasNext()) {
            String str = sc.nextLine();

            String[] parts = str.split(",");

            String title = parts[0];

            String artist = parts[1];

            String year = parts[2];
            String genre = parts[3];

            Song s = new Song(artist, title, genre, Integer.valueOf(year));
            songList.add(s);

        }
        sc.close();

        return songList;

    }


    /**
     * This reads user file
     * 
     * @param filename
     *            user file
     * @return LinkedList<User>
     * @throws FileNotFoundException
     *             if there is no file
     */

    public static LinkedList<User> readUserFile(String filename)
        throws FileNotFoundException {
        LinkedList<User> userList = new LinkedList<User>();
        Scanner sc = new Scanner(new File(filename));
        sc.nextLine();
        int index = 0;

        int idealLength = (readSongFile(songFile).size() * 2) + 5;

        while (sc.hasNextLine()) {
            String str = sc.nextLine();

            String[] parts = str.split(",");

            HobbyEnum hobby = null;
            RegionEnum region = null;
            MajorEnum major = null;

            if (parts.length >= 5) {

                // major
                if (parts[2].equals("Math or CMDA")) {
                    major = MajorEnum.CMDA_MATH;
                }
                else if (parts[2].equals("Computer Science")) {
                    major = MajorEnum.COMPSCI;
                }
                else if (parts[2].equals("Other Engineering")) {
                    major = MajorEnum.OTHER_ENGE;
                }
                else if (parts[2].equals("Other")) {
                    major = MajorEnum.OTHER;
                }

                // region
                if (parts[3].equals("Southeast")) {
                    region = RegionEnum.SOUTH_EAST;
                }
                else if (parts[3].equals("Northeast")) {
                    region = RegionEnum.NORTH_EAST;
                }
                else if (parts[3].equals(
                    "United States (other than Southeast or Northwest)")) {
                    region = RegionEnum.REST_OF_US;
                }
                else if (parts[3].equals("Outside of United States")) {
                    region = RegionEnum.OUTSIDE_US;
                }

                // hobby
                if (parts[4].equals("sports")) {
                    hobby = HobbyEnum.SPORTS;
                }
                else if (parts[4].equals("music")) {
                    hobby = HobbyEnum.MUSIC;
                }
                else if (parts[4].equals("reading")) {
                    hobby = HobbyEnum.READ;
                }
                else if (parts[4].equals("art")) {
                    hobby = HobbyEnum.ART;
                }
                User u = new User(hobby, major, region);
                userList.add(u);
                if (parts.length != idealLength) {
                    for (int i = 5; i < parts.length; i++) {
                        if (i % 2 == 0) {
                            userList.get(index).getLiked().add(parts[i]);
                        }
                        else {
                            userList.get(index).getHeard().add(parts[i]);
                        }
                    }
                    for (int i = parts.length; i < idealLength; i++) {
                        if (i % 2 == 0) {
                            userList.get(index).getLiked().add(" ");
                        }
                        else {
                            userList.get(index).getHeard().add(" ");
                        }
                    }
                }
                else {
                    for (int i = 5; i < idealLength; i++) {
                        if (i % 2 == 0) {
                            userList.get(index).getLiked().add(parts[i]);
                        }
                        else {
                            userList.get(index).getHeard().add(parts[i]);
                        }
                    }
                }
                index++;

            }

        }
        sc.close();

        return userList;
    }

}
