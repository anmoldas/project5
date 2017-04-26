package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Window for the GUI
 * 
 * @author Anmol Das
 * @author Harsha Jonnavithula
 * @author Tarun Nadipalli
 * 
 * @version 4.19.2017
 */
public class GUIWindow {
// Fields
    private Window window;
    private Button repHobby;
    private Button repMajor;
    private Button repRegion;
    private Button quitButton;
    private Button prev;
    private Button sortArtist;
    private Button sortSong;
    private Button sortYear;
    private Button sortGenre;
    private Button next;
    private TextShape legend;
    private SortData data;
    private int page;
    private String legendTitle;
    private boolean isGenre = false;
    private boolean isDate = false;


    /**
     * constructor
     * 
     * @param sort
     *            SortData object
     */
    public GUIWindow(SortData sort) {
        data = sort;
        page = 1;
        legendTitle = "";

        window = new Window();
        window.setTitle("Project 5");
        window.setSize(1150, 750);

        repHobby = new Button("Represent Hobby");
        repHobby.onClick(this, "clickedHobby");
        window.addButton(repHobby, WindowSide.SOUTH);

        repMajor = new Button("Represent Major");
        repMajor.onClick(this, "clickedMajor");
        window.addButton(repMajor, WindowSide.SOUTH);

        repRegion = new Button("Represent Region");
        repRegion.onClick(this, "clickedRegion");
        window.addButton(repRegion, WindowSide.SOUTH);

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);

        prev = new Button("<-- Prev");
        prev.onClick(this, "clickedPrev");
        window.addButton(prev, WindowSide.NORTH);
        prev.disable();

        sortArtist = new Button("Sort by Artist Name");
        sortArtist.onClick(this, "clickedArtistName");
        window.addButton(sortArtist, WindowSide.NORTH);
        sortArtist.disable();

        sortSong = new Button("Sort by Song Title");
        sortSong.onClick(this, "clickedSongTitle");
        window.addButton(sortSong, WindowSide.NORTH);
        sortSong.disable();

        sortYear = new Button("Sort by Release Year");
        sortYear.onClick(this, "clickedReleaseYear");
        window.addButton(sortYear, WindowSide.NORTH);
        sortYear.disable();

        sortGenre = new Button("Sort by Genre");
        sortGenre.onClick(this, "clickedGenre");
        window.addButton(sortGenre, WindowSide.NORTH);
        sortGenre.disable();

        next = new Button("Next -->");
        next.onClick(this, "clickedNext");
        window.addButton(next, WindowSide.NORTH);
        next.disable();

    }


    /**
     * initializes the window
     */

    public void initializeWindow() {
        window.removeAllShapes();

        Shape leftLine = new Shape(900, 375, 2, 200, Color.BLACK); // left line
                                                                   // around
                                                                   // legend
        Shape rightLine = new Shape(1075, 375, 2, 200, Color.BLACK); // right
                                                                     // line
                                                                     // around
                                                                     // legend
        Shape topLine = new Shape(900, 375, 175, 2, Color.BLACK); // top line
                                                                  // around
                                                                  // legend
        Shape bottomLine = new Shape(900, 575, 175, 2, Color.BLACK); // bottom
                                                                     // line
                                                                     // around
                                                                     // legend
        window.addShape(leftLine);
        window.addShape(rightLine);
        window.addShape(topLine);
        window.addShape(bottomLine);

        TextShape songTitle = new TextShape(950, 475, "Song Title");
        songTitle.setBackgroundColor(Color.WHITE);
        window.addShape(songTitle);

        Shape line = new Shape(990, 500, 5, 40, Color.BLACK);
        window.addShape(line);

        TextShape heard = new TextShape(945, 510, "Heard");
        heard.setBackgroundColor(Color.WHITE);
        window.addShape(heard);

        TextShape likes = new TextShape(995, 510, "Likes");
        likes.setBackgroundColor(Color.WHITE);
        window.addShape(likes);
        prev.enable();
        next.enable();

    }


    /**
     * draws the glyphs
     * 
     * @param songs
     *            linked list of songs
     * @param users
     *            linked list of users
     * @param pageNumber
     *            page number on window
     */

    public void drawGlyphs(
        LinkedList<Song> songs,
        LinkedList<User> users,
        int pageNumber) {
        initializeWindow();
        int index = (pageNumber * 9) - 9;

// ------------------------------------------------------

        if (legendTitle == "Hobby Legend") {

            if (index < songs.size() - 1) {
                TextShape firstTitle = new TextShape(100, 75, songs.get(index)
                    .getSongTitle());
                firstTitle.setBackgroundColor(Color.WHITE);
                window.addShape(firstTitle);
                if (isGenre) {
                    TextShape firstSub = new TextShape(100, 90, "genre: "
                        + songs.get(index).getGenre());
                    firstSub.setBackgroundColor(Color.WHITE);
                    window.addShape(firstSub);
                }
                else if (isDate) {
                    TextShape firstSub = new TextShape(100, 90, "released: "
                        + songs.get(index).getDate());
                    firstSub.setBackgroundColor(Color.WHITE);
                    window.addShape(firstSub);
                }
                else {
                    TextShape firstSub = new TextShape(100, 90, "by " + songs
                        .get(index).getArtistName());
                    firstSub.setBackgroundColor(Color.WHITE);
                    window.addShape(firstSub);
                }

                Shape lineGlyph = new Shape(150, 110, 5, 40, Color.BLACK);
                window.addShape(lineGlyph);
                window.moveToFront(lineGlyph);

                Shape readBarLeft = new Shape(150 - songs.get(index)
                    .getReadHeardPercent(), 110, songs.get(index)
                        .getReadHeardPercent(), 10, Color.MAGENTA);
                window.addShape(readBarLeft);
                Shape artBarLeft = new Shape(150 - songs.get(index)
                    .getArtHeardPercent(), 120, songs.get(index)
                        .getArtHeardPercent(), 10, Color.BLUE);
                window.addShape(artBarLeft);
                Shape sportsBarLeft = new Shape(150 - songs.get(index)
                    .getSportsHeardPercent(), 130, songs.get(index)
                        .getSportsHeardPercent(), 10, Color.RED);
                window.addShape(sportsBarLeft);
                Shape musicBarLeft = new Shape(150 - songs.get(index)
                    .getMusicHeardPercent(), 140, songs.get(index)
                        .getMusicHeardPercent(), 10, Color.GREEN);
                window.addShape(musicBarLeft);

                // Right side of line
                Shape readBarRight = new Shape(155, 110, songs.get(index)
                    .getReadLikedPercent(), 10, Color.MAGENTA);
                window.addShape(readBarRight);
                Shape artBarRight = new Shape(155, 120, songs.get(index)
                    .getArtLikedPercent(), 10, Color.BLUE);
                window.addShape(artBarRight);
                Shape sportsBarRight = new Shape(155, 130, songs.get(index)
                    .getSportsLikedPercent(), 10, Color.RED);
                window.addShape(sportsBarRight);
                Shape musicBarRight = new Shape(155, 140, songs.get(index)
                    .getMusicLikedPercent(), 10, Color.GREEN);
                window.addShape(musicBarRight);
            }
            if (index + 1 < songs.size() - 1) {

                // position 2 row 1
                // ------------------------------------------------------
                TextShape secondTitle = new TextShape(400, 75, songs.get(index
                    + 1).getSongTitle());
                secondTitle.setBackgroundColor(Color.WHITE);
                window.addShape(secondTitle);

                if (isGenre) {
                    TextShape secondSub = new TextShape(400, 90, "genre: "
                        + songs.get(index + 1).getGenre());
                    secondSub.setBackgroundColor(Color.WHITE);
                    window.addShape(secondSub);
                }
                else if (isDate) {
                    TextShape secondSub = new TextShape(400, 90, "released: "
                        + songs.get(index + 1).getDate());
                    secondSub.setBackgroundColor(Color.WHITE);
                    window.addShape(secondSub);
                }
                else {
                    TextShape secondSub = new TextShape(400, 90, "by " + songs
                        .get(index + 1).getArtistName());
                    secondSub.setBackgroundColor(Color.WHITE);
                    window.addShape(secondSub);
                }

                Shape line2Glyph = new Shape(450, 110, 5, 40, Color.BLACK);
                window.addShape(line2Glyph);
                window.moveToFront(line2Glyph);
                Shape readBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getReadHeardPercent(), 110, songs.get(index + 1)
                        .getReadHeardPercent(), 10, Color.MAGENTA);
                window.addShape(readBarLeft2);
                Shape artBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getArtHeardPercent(), 120, songs.get(index + 1)
                        .getArtHeardPercent(), 10, Color.BLUE);
                window.addShape(artBarLeft2);
                Shape sportsBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getSportsHeardPercent(), 130, songs.get(index + 1)
                        .getSportsHeardPercent(), 10, Color.RED);
                window.addShape(sportsBarLeft2);
                Shape musicBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getMusicHeardPercent(), 140, songs.get(index + 1)
                        .getMusicHeardPercent(), 10, Color.GREEN);
                window.addShape(musicBarLeft2);

                // Right side of line
                Shape readBarRight2 = new Shape(455, 110, songs.get(index + 1)
                    .getReadLikedPercent(), 10, Color.MAGENTA);
                window.addShape(readBarRight2);
                Shape artBarRight2 = new Shape(455, 120, songs.get(index + 1)
                    .getArtLikedPercent(), 10, Color.BLUE);
                window.addShape(artBarRight2);
                Shape sportsBarRight2 = new Shape(455, 130, songs.get(index + 1)
                    .getSportsLikedPercent(), 10, Color.RED);
                window.addShape(sportsBarRight2);
                Shape musicBarRight2 = new Shape(455, 140, songs.get(index + 1)
                    .getMusicLikedPercent(), 10, Color.GREEN);
                window.addShape(musicBarRight2);
            }

            if (index + 2 < songs.size() - 1) {
                // position 3 row 1
                // ------------------------------------------------------
                TextShape thirdTitle = new TextShape(700, 75, songs.get(index
                    + 2).getSongTitle());
                thirdTitle.setBackgroundColor(Color.WHITE);
                window.addShape(thirdTitle);

                if (isGenre) {
                    TextShape thirdSub = new TextShape(700, 90, "genre: "
                        + songs.get(index + 2).getGenre());
                    thirdSub.setBackgroundColor(Color.WHITE);
                    window.addShape(thirdSub);
                }
                else if (isDate) {
                    TextShape thirdSub = new TextShape(700, 90, "released: "
                        + songs.get(index + 2).getDate());
                    thirdSub.setBackgroundColor(Color.WHITE);
                    window.addShape(thirdSub);
                }
                else {
                    TextShape thirdSub = new TextShape(700, 90, "by " + songs
                        .get(index + 2).getArtistName());
                    thirdSub.setBackgroundColor(Color.WHITE);
                    window.addShape(thirdSub);
                }

                Shape line3Glyph = new Shape(750, 110, 5, 40, Color.BLACK);
                window.addShape(line3Glyph);
                window.moveToFront(line3Glyph);
                // position 3 row 1
                // Left side of line
                Shape readBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getReadHeardPercent(), 110, songs.get(index + 2)
                        .getReadHeardPercent(), 10, Color.MAGENTA);
                window.addShape(readBarLeft3);
                Shape artBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getArtHeardPercent(), 120, songs.get(index + 2)
                        .getArtHeardPercent(), 10, Color.BLUE);
                window.addShape(artBarLeft3);
                Shape sportsBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getSportsHeardPercent(), 130, songs.get(index + 2)
                        .getSportsHeardPercent(), 10, Color.RED);
                window.addShape(sportsBarLeft3);
                Shape musicBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getMusicHeardPercent(), 140, songs.get(index + 2)
                        .getMusicHeardPercent(), 10, Color.GREEN);
                window.addShape(musicBarLeft3);

                // Right side of line
                Shape readBarRight3 = new Shape(755, 110, songs.get(index + 2)
                    .getReadLikedPercent(), 10, Color.MAGENTA);
                window.addShape(readBarRight3);
                Shape artBarRight3 = new Shape(755, 120, songs.get(index + 2)
                    .getArtLikedPercent(), 10, Color.BLUE);
                window.addShape(artBarRight3);
                Shape sportsBarRight3 = new Shape(755, 130, songs.get(index + 2)
                    .getSportsLikedPercent(), 10, Color.RED);
                window.addShape(sportsBarRight3);
                Shape musicBarRight3 = new Shape(755, 140, songs.get(index + 2)
                    .getMusicLikedPercent(), 10, Color.GREEN);
                window.addShape(musicBarRight3);

            }
            if (index + 3 < songs.size() - 1) {
                // position 4 row 2
                // ---------------------------------------------------------
                TextShape fourthTitle = new TextShape(100, 275, songs.get(index
                    + 3).getSongTitle());
                fourthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(fourthTitle);

                if (isGenre) {
                    TextShape fourthSub = new TextShape(100, 290, "genre: "
                        + songs.get(index + 3).getGenre());
                    fourthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(fourthSub);
                }
                else if (isDate) {
                    TextShape fourthSub = new TextShape(100, 290, "released: "
                        + songs.get(index + 3).getDate());
                    fourthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(fourthSub);
                }
                else {
                    TextShape fourthSub = new TextShape(100, 290, "by " + songs
                        .get(index + 3).getArtistName());
                    fourthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(fourthSub);
                }

                Shape line4Glyph = new Shape(150, 310, 5, 40, Color.BLACK);
                window.addShape(line4Glyph);
                window.moveToFront(line4Glyph);
                // position 4 row 2
                // Left side of line
                Shape readBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getReadHeardPercent(), 310, songs.get(index + 3)
                        .getReadHeardPercent(), 10, Color.MAGENTA);
                window.addShape(readBarLeft4);
                Shape artBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getArtHeardPercent(), 320, songs.get(index + 3)
                        .getArtHeardPercent(), 10, Color.BLUE);
                window.addShape(artBarLeft4);
                Shape sportsBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getSportsHeardPercent(), 330, songs.get(index + 3)
                        .getSportsHeardPercent(), 10, Color.RED);
                window.addShape(sportsBarLeft4);
                Shape musicBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getMusicHeardPercent(), 340, songs.get(index + 3)
                        .getMusicHeardPercent(), 10, Color.GREEN);
                window.addShape(musicBarLeft4);

                // Right side of line
                Shape readBarRight4 = new Shape(155, 310, songs.get(index + 3)
                    .getReadLikedPercent(), 10, Color.MAGENTA);
                window.addShape(readBarRight4);
                Shape artBarRight4 = new Shape(155, 320, songs.get(index + 3)
                    .getArtLikedPercent(), 10, Color.BLUE);
                window.addShape(artBarRight4);
                Shape sportsBarRight4 = new Shape(155, 330, songs.get(index + 3)
                    .getSportsLikedPercent(), 10, Color.RED);
                window.addShape(sportsBarRight4);
                Shape musicBarRight4 = new Shape(155, 340, songs.get(index + 3)
                    .getMusicLikedPercent(), 10, Color.GREEN);
                window.addShape(musicBarRight4);

            }
            if (index + 4 < songs.size() - 1) {

                // position 5 row
                // 2----------------------------------------------------------
                TextShape fifthTitle = new TextShape(400, 275, songs.get(index
                    + 4).getSongTitle());
                fifthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(fifthTitle);

                if (isGenre) {
                    TextShape fifthSub = new TextShape(400, 290, "genre: "
                        + songs.get(index + 4).getGenre());
                    fifthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(fifthSub);
                }
                else if (isDate) {
                    TextShape fifthSub = new TextShape(400, 290, "released: "
                        + songs.get(index + 4).getDate());
                    fifthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(fifthSub);
                }
                else {
                    TextShape fifthSub = new TextShape(400, 290, "by " + songs
                        .get(index + 4).getArtistName());
                    fifthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(fifthSub);
                }

                Shape line5Glyph = new Shape(450, 310, 5, 40, Color.BLACK);
                window.addShape(line5Glyph);
                window.moveToFront(line5Glyph);
                // position 5 row 2
                // Left side of line
                Shape readBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getReadHeardPercent(), 310, songs.get(index + 4)
                        .getReadHeardPercent(), 10, Color.MAGENTA);
                window.addShape(readBarLeft5);
                Shape artBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getArtHeardPercent(), 320, songs.get(index + 4)
                        .getArtHeardPercent(), 10, Color.BLUE);
                window.addShape(artBarLeft5);
                Shape sportsBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getSportsHeardPercent(), 330, songs.get(index + 4)
                        .getSportsHeardPercent(), 10, Color.RED);
                window.addShape(sportsBarLeft5);
                Shape musicBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getMusicHeardPercent(), 340, songs.get(index + 4)
                        .getMusicHeardPercent(), 10, Color.GREEN);
                window.addShape(musicBarLeft5);

                // Right side of line
                Shape readBarRight5 = new Shape(455, 310, songs.get(index + 4)
                    .getReadLikedPercent(), 10, Color.MAGENTA);
                window.addShape(readBarRight5);
                Shape artBarRight5 = new Shape(455, 320, songs.get(index + 4)
                    .getArtLikedPercent(), 10, Color.BLUE);
                window.addShape(artBarRight5);
                Shape sportsBarRight5 = new Shape(455, 330, songs.get(index + 4)
                    .getSportsLikedPercent(), 10, Color.RED);
                window.addShape(sportsBarRight5);
                Shape musicBarRight5 = new Shape(455, 340, songs.get(index + 4)
                    .getMusicLikedPercent(), 10, Color.GREEN);
                window.addShape(musicBarRight5);

            }
            if (index + 5 < songs.size() - 1) {

                // position 6 row 2
                // ----------------------------------------------------------
                TextShape sixthTitle = new TextShape(700, 275, songs.get(index
                    + 5).getSongTitle());
                sixthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(sixthTitle);

                if (isGenre) {
                    TextShape sixthSub = new TextShape(700, 290, "genre: "
                        + songs.get(index + 5).getGenre());
                    sixthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(sixthSub);
                }
                else if (isDate) {
                    TextShape sixthSub = new TextShape(700, 290, "released: "
                        + songs.get(index + 5).getDate());
                    sixthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(sixthSub);
                }
                else {
                    TextShape sixthSub = new TextShape(700, 290, "by " + songs
                        .get(index + 5).getArtistName());
                    sixthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(sixthSub);
                }

                Shape line6Glyph = new Shape(750, 310, 5, 40, Color.BLACK);
                window.addShape(line6Glyph);
                window.moveToFront(line6Glyph);
                // position 6 row 2
                // Left side of line
                Shape readBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getReadHeardPercent(), 310, songs.get(index + 5)
                        .getReadHeardPercent(), 10, Color.MAGENTA);
                window.addShape(readBarLeft6);
                Shape artBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getArtHeardPercent(), 320, songs.get(index + 5)
                        .getArtHeardPercent(), 10, Color.BLUE);
                window.addShape(artBarLeft6);
                Shape sportsBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getSportsHeardPercent(), 330, songs.get(index + 5)
                        .getSportsHeardPercent(), 10, Color.RED);
                window.addShape(sportsBarLeft6);
                Shape musicBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getMusicHeardPercent(), 340, songs.get(index + 5)
                        .getArtHeardPercent(), 10, Color.GREEN);
                window.addShape(musicBarLeft6);

                // Right side of line
                Shape readBarRight6 = new Shape(755, 310, songs.get(index + 5)
                    .getReadLikedPercent(), 10, Color.MAGENTA);
                window.addShape(readBarRight6);
                Shape artBarRight6 = new Shape(755, 320, songs.get(index + 5)
                    .getArtLikedPercent(), 10, Color.BLUE);
                window.addShape(artBarRight6);
                Shape sportsBarRight6 = new Shape(755, 330, songs.get(index + 5)
                    .getSportsLikedPercent(), 10, Color.RED);
                window.addShape(sportsBarRight6);
                Shape musicBarRight6 = new Shape(755, 340, songs.get(index + 5)
                    .getMusicLikedPercent(), 10, Color.GREEN);
                window.addShape(musicBarRight6);

            }
            if (index + 6 < songs.size() - 1) {

                // position 7 row 3
                // ----------------------------------------------------------
                TextShape seventhTitle = new TextShape(100, 475, songs.get(index
                    + 6).getSongTitle());
                seventhTitle.setBackgroundColor(Color.WHITE);
                window.addShape(seventhTitle);

                if (isGenre) {
                    TextShape seventhSub = new TextShape(100, 490, "genre: "
                        + songs.get(index + 6).getGenre());
                    seventhSub.setBackgroundColor(Color.WHITE);
                    window.addShape(seventhSub);
                }
                else if (isDate) {
                    TextShape seventhSub = new TextShape(100, 490, "released: "
                        + songs.get(index + 6).getDate());
                    seventhSub.setBackgroundColor(Color.WHITE);
                    window.addShape(seventhSub);
                }
                else {
                    TextShape seventhSub = new TextShape(100, 490, "by " + songs
                        .get(index + 6).getArtistName());
                    seventhSub.setBackgroundColor(Color.WHITE);
                    window.addShape(seventhSub);
                }
                Shape line7Glyph = new Shape(150, 510, 5, 40, Color.BLACK);
                window.addShape(line7Glyph);
                window.moveToFront(line7Glyph);
                // position 7 row 3
                // Left side of line
                Shape readBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getReadHeardPercent(), 510, songs.get(index + 6)
                        .getReadHeardPercent(), 10, Color.MAGENTA);
                window.addShape(readBarLeft7);
                Shape artBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getArtHeardPercent(), 520, songs.get(index + 6)
                        .getArtHeardPercent(), 10, Color.BLUE);
                window.addShape(artBarLeft7);
                Shape sportsBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getSportsHeardPercent(), 530, songs.get(index + 6)
                        .getSportsHeardPercent(), 10, Color.RED);
                window.addShape(sportsBarLeft7);
                Shape musicBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getMusicHeardPercent(), 540, songs.get(index + 6)
                        .getMusicHeardPercent(), 10, Color.GREEN);
                window.addShape(musicBarLeft7);

                // Right side of line
                Shape readBarRight7 = new Shape(155, 510, songs.get(index + 6)
                    .getReadLikedPercent(), 10, Color.MAGENTA);
                window.addShape(readBarRight7);
                Shape artBarRight7 = new Shape(155, 520, songs.get(index + 6)
                    .getArtLikedPercent(), 10, Color.BLUE);
                window.addShape(artBarRight7);
                Shape sportsBarRight7 = new Shape(155, 530, songs.get(index + 6)
                    .getSportsLikedPercent(), 10, Color.RED);
                window.addShape(sportsBarRight7);
                Shape musicBarRight7 = new Shape(155, 540, songs.get(index + 6)
                    .getMusicLikedPercent(), 10, Color.GREEN);
                window.addShape(musicBarRight7);

            }
            if (index + 7 < songs.size() - 1) {
                // position 8 row 3
                // ----------------------------------------------------------
                TextShape eighthTitle = new TextShape(400, 475, songs.get(index
                    + 7).getSongTitle());
                eighthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(eighthTitle);

                if (isGenre) {
                    TextShape eighthSub = new TextShape(400, 490, "genre: "
                        + songs.get(index + 7).getGenre());
                    eighthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(eighthSub);
                }
                else if (isDate) {
                    TextShape eighthSub = new TextShape(400, 490, "released: "
                        + songs.get(index + 7).getDate());
                    eighthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(eighthSub);
                }
                else {
                    TextShape eighthSub = new TextShape(400, 490, "by " + songs
                        .get(index + 7).getArtistName());
                    eighthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(eighthSub);
                }

                Shape line8Glyph = new Shape(450, 510, 5, 40, Color.BLACK);
                window.addShape(line8Glyph);
                window.moveToFront(line8Glyph);
                // position 8 row 3
                // Left side of line
                Shape readBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getReadHeardPercent(), 510, songs.get(index + 7)
                        .getReadHeardPercent(), 10, Color.MAGENTA);
                window.addShape(readBarLeft8);
                Shape artBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getArtHeardPercent(), 520, songs.get(index + 7)
                        .getArtHeardPercent(), 10, Color.BLUE);
                window.addShape(artBarLeft8);
                Shape sportsBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getSportsHeardPercent(), 530, songs.get(index + 7)
                        .getSportsHeardPercent(), 10, Color.RED);
                window.addShape(sportsBarLeft8);
                Shape musicBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getMusicHeardPercent(), 540, songs.get(index + 7)
                        .getMusicHeardPercent(), 10, Color.GREEN);
                window.addShape(musicBarLeft8);

                // Right side of line
                Shape readBarRight8 = new Shape(455, 510, songs.get(index + 7)
                    .getReadLikedPercent(), 10, Color.MAGENTA);
                window.addShape(readBarRight8);
                Shape artBarRight8 = new Shape(455, 520, songs.get(index + 7)
                    .getArtLikedPercent(), 10, Color.BLUE);
                window.addShape(artBarRight8);
                Shape sportsBarRight8 = new Shape(455, 530, songs.get(index + 7)
                    .getSportsLikedPercent(), 10, Color.RED);
                window.addShape(sportsBarRight8);
                Shape musicBarRight8 = new Shape(455, 540, songs.get(index + 7)
                    .getMusicLikedPercent(), 10, Color.GREEN);
                window.addShape(musicBarRight8);
            }
            if (index + 8 < songs.size() - 1) {
                // position 9 row 3
                // ----------------------------------------------------------
                TextShape ninthTitle = new TextShape(700, 475, songs.get(index
                    + 8).getSongTitle());
                ninthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(ninthTitle);

                if (isGenre) {
                    TextShape ninthSub = new TextShape(700, 490, "genre: "
                        + songs.get(index + 8).getGenre());
                    ninthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(ninthSub);
                }
                else if (isDate) {
                    TextShape ninthSub = new TextShape(700, 490, "released: "
                        + songs.get(index + 8).getDate());
                    ninthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(ninthSub);
                }
                else {
                    TextShape ninthSub = new TextShape(700, 490, "by " + songs
                        .get(index + 8).getArtistName());
                    ninthSub.setBackgroundColor(Color.WHITE);
                    window.addShape(ninthSub);
                }

                Shape line9Glyph = new Shape(750, 510, 5, 40, Color.BLACK);
                window.addShape(line9Glyph);
                window.moveToFront(line9Glyph);
                // position 9 row 3
                // Left side of line
                Shape readBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getReadHeardPercent(), 510, songs.get(index + 8)
                        .getReadHeardPercent(), 10, Color.MAGENTA);
                window.addShape(readBarLeft9);
                Shape artBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getArtHeardPercent(), 520, songs.get(index + 8)
                        .getArtHeardPercent(), 10, Color.BLUE);
                window.addShape(artBarLeft9);
                Shape sportsBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getSportsHeardPercent(), 530, songs.get(index + 8)
                        .getSportsHeardPercent(), 10, Color.RED);
                window.addShape(sportsBarLeft9);
                Shape musicBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getMusicHeardPercent(), 540, songs.get(index + 8)
                        .getMusicHeardPercent(), 10, Color.GREEN);
                window.addShape(musicBarLeft9);

                // Right side of line
                Shape readBarRight9 = new Shape(755, 510, songs.get(index + 8)
                    .getReadLikedPercent(), 10, Color.MAGENTA);
                window.addShape(readBarRight9);
                Shape artBarRight9 = new Shape(755, 520, songs.get(index + 8)
                    .getArtLikedPercent(), 10, Color.BLUE);
                window.addShape(artBarRight9);
                Shape sportsBarRight9 = new Shape(755, 530, songs.get(index + 8)
                    .getSportsLikedPercent(), 10, Color.RED);
                window.addShape(sportsBarRight9);
                Shape musicBarRight9 = new Shape(755, 540, songs.get(index + 8)
                    .getMusicLikedPercent(), 10, Color.GREEN);
                window.addShape(musicBarRight9);
            }
        }
        if (legendTitle == "Major Legend") {
            if (index < songs.size() - 1) {
                TextShape firstTitle = new TextShape(100, 75, songs.get(index)
                    .getSongTitle());
                firstTitle.setBackgroundColor(Color.WHITE);
                window.addShape(firstTitle);

                TextShape firstArtist = new TextShape(100, 90, "by " + songs
                    .get(index).getArtistName());
                firstArtist.setBackgroundColor(Color.WHITE);
                window.addShape(firstArtist);

                Shape lineGlyph = new Shape(150, 110, 5, 40, Color.BLACK);
                window.addShape(lineGlyph);
                window.moveToFront(lineGlyph);

                Shape compsciBarLeft = new Shape(150 - songs.get(index)
                    .getCompsciHeardPercent(), 110, songs.get(index)
                        .getCompsciHeardPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarLeft);
                Shape engeBarLeft = new Shape(150 - songs.get(index)
                    .getEngeHeardPercent(), 120, songs.get(index)
                        .getEngeHeardPercent(), 10, Color.BLUE);
                window.addShape(engeBarLeft);
                Shape mathBarLeft = new Shape(150 - songs.get(index)
                    .getMathHeardPercent(), 130, songs.get(index)
                        .getMathHeardPercent(), 10, Color.RED);
                window.addShape(mathBarLeft);
                Shape otherBarLeft = new Shape(150 - songs.get(index)
                    .getOtherHeardPercent(), 140, songs.get(index)
                        .getOtherHeardPercent(), 10, Color.GREEN);
                window.addShape(otherBarLeft);

                // Right side of line
                Shape compsciBarRight = new Shape(155, 110, songs.get(index)
                    .getCompsciLikedPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarRight);
                Shape engeBarRight = new Shape(155, 120, songs.get(index)
                    .getEngeLikedPercent(), 10, Color.BLUE);
                window.addShape(engeBarRight);
                Shape mathBarRight = new Shape(155, 130, songs.get(index)
                    .getMathLikedPercent(), 10, Color.RED);
                window.addShape(mathBarRight);
                Shape otherBarRight = new Shape(155, 140, songs.get(index)
                    .getOtherLikedPercent(), 10, Color.GREEN);
                window.addShape(otherBarRight);
            }
            if (index + 1 < songs.size() - 1) {

                // position 2 row 1
                // ------------------------------------------------------
                TextShape secondTitle = new TextShape(400, 75, songs.get(index
                    + 1).getSongTitle());
                secondTitle.setBackgroundColor(Color.WHITE);
                window.addShape(secondTitle);

                TextShape secondArtist = new TextShape(400, 90, "by " + songs
                    .get(index + 1).getArtistName());
                secondArtist.setBackgroundColor(Color.WHITE);
                window.addShape(secondArtist);

                Shape line2Glyph = new Shape(450, 110, 5, 40, Color.BLACK);
                window.addShape(line2Glyph);
                window.moveToFront(line2Glyph);
                Shape compsciBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getCompsciHeardPercent(), 110, songs.get(index + 1)
                        .getCompsciHeardPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarLeft2);
                Shape engeBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getEngeHeardPercent(), 120, songs.get(index + 1)
                        .getEngeHeardPercent(), 10, Color.BLUE);
                window.addShape(engeBarLeft2);
                Shape mathBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getMathHeardPercent(), 130, songs.get(index + 1)
                        .getMathHeardPercent(), 10, Color.RED);
                window.addShape(mathBarLeft2);
                Shape otherBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getOtherHeardPercent(), 140, songs.get(index + 1)
                        .getOtherHeardPercent(), 10, Color.GREEN);
                window.addShape(otherBarLeft2);

                // Right side of line
                Shape compsciBarRight2 = new Shape(455, 110, songs.get(index
                    + 1).getCompsciLikedPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarRight2);
                Shape engeBarRight2 = new Shape(455, 120, songs.get(index + 1)
                    .getEngeLikedPercent(), 10, Color.BLUE);
                window.addShape(engeBarRight2);
                Shape mathBarRight2 = new Shape(455, 130, songs.get(index + 1)
                    .getMathLikedPercent(), 10, Color.RED);
                window.addShape(mathBarRight2);
                Shape otherBarRight2 = new Shape(455, 140, songs.get(index + 1)
                    .getOtherLikedPercent(), 10, Color.GREEN);
                window.addShape(otherBarRight2);
            }

            if (index + 2 < songs.size() - 1) {
                // position 3 row 1
                // ------------------------------------------------------
                TextShape thirdTitle = new TextShape(700, 75, songs.get(index
                    + 2).getSongTitle());
                thirdTitle.setBackgroundColor(Color.WHITE);
                window.addShape(thirdTitle);

                TextShape thirdArtist = new TextShape(700, 90, "by " + songs
                    .get(index + 2).getArtistName());
                thirdArtist.setBackgroundColor(Color.WHITE);
                window.addShape(thirdArtist);

                Shape line3Glyph = new Shape(750, 110, 5, 40, Color.BLACK);
                window.addShape(line3Glyph);
                window.moveToFront(line3Glyph);
                // position 3 row 1
                // Left side of line
                Shape compsciBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getCompsciHeardPercent(), 110, songs.get(index + 2)
                        .getCompsciHeardPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarLeft3);
                Shape engeBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getEngeHeardPercent(), 120, songs.get(index + 2)
                        .getEngeHeardPercent(), 10, Color.BLUE);
                window.addShape(engeBarLeft3);
                Shape mathBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getMathHeardPercent(), 130, songs.get(index + 2)
                        .getMathHeardPercent(), 10, Color.RED);
                window.addShape(mathBarLeft3);
                Shape otherBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getOtherHeardPercent(), 140, songs.get(index + 2)
                        .getOtherHeardPercent(), 10, Color.GREEN);
                window.addShape(otherBarLeft3);

                // Right side of line
                Shape compsciBarRight3 = new Shape(755, 110, songs.get(index
                    + 2).getCompsciLikedPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarRight3);
                Shape engeBarRight3 = new Shape(755, 120, songs.get(index + 2)
                    .getEngeLikedPercent(), 10, Color.BLUE);
                window.addShape(engeBarRight3);
                Shape mathBarRight3 = new Shape(755, 130, songs.get(index + 2)
                    .getMathLikedPercent(), 10, Color.RED);
                window.addShape(mathBarRight3);
                Shape otherBarRight3 = new Shape(755, 140, songs.get(index + 2)
                    .getOtherLikedPercent(), 10, Color.GREEN);
                window.addShape(otherBarRight3);

            }
            if (index + 3 < songs.size() - 1) {
                // position 4 row 2
                // ---------------------------------------------------------
                TextShape fourthTitle = new TextShape(100, 275, songs.get(index
                    + 3).getSongTitle());
                fourthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(fourthTitle);

                TextShape fourthArtist = new TextShape(100, 290, "by " + songs
                    .get(index + 3).getArtistName());
                fourthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(fourthArtist);

                Shape line4Glyph = new Shape(150, 310, 5, 40, Color.BLACK);
                window.addShape(line4Glyph);
                window.moveToFront(line4Glyph);
                // position 4 row 2
                // Left side of line
                Shape compsciBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getCompsciHeardPercent(), 310, songs.get(index + 3)
                        .getCompsciHeardPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarLeft4);
                Shape engeBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getEngeHeardPercent(), 320, songs.get(index + 3)
                        .getEngeHeardPercent(), 10, Color.BLUE);
                window.addShape(engeBarLeft4);
                Shape mathBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getMathHeardPercent(), 330, songs.get(index + 3)
                        .getMathHeardPercent(), 10, Color.RED);
                window.addShape(mathBarLeft4);
                Shape otherBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getOtherHeardPercent(), 340, songs.get(index + 3)
                        .getOtherHeardPercent(), 10, Color.GREEN);
                window.addShape(otherBarLeft4);

                // Right side of line
                Shape compsciBarRight4 = new Shape(155, 310, songs.get(index
                    + 3).getCompsciLikedPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarRight4);
                Shape engeBarRight4 = new Shape(155, 320, songs.get(index + 3)
                    .getEngeLikedPercent(), 10, Color.BLUE);
                window.addShape(engeBarRight4);
                Shape mathBarRight4 = new Shape(155, 330, songs.get(index + 3)
                    .getMathLikedPercent(), 10, Color.RED);
                window.addShape(mathBarRight4);
                Shape otherBarRight4 = new Shape(155, 340, songs.get(index + 3)
                    .getOtherLikedPercent(), 10, Color.GREEN);
                window.addShape(otherBarRight4);

            }
            if (index + 4 < songs.size() - 1) {

                // position 5 row
                // 2----------------------------------------------------------
                TextShape fifthTitle = new TextShape(400, 275, songs.get(index
                    + 4).getSongTitle());
                fifthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(fifthTitle);

                TextShape fifthArtist = new TextShape(400, 290, "by " + songs
                    .get(index + 4).getArtistName());
                fifthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(fifthArtist);

                Shape line5Glyph = new Shape(450, 310, 5, 40, Color.BLACK);
                window.addShape(line5Glyph);
                window.moveToFront(line5Glyph);
                // position 5 row 2
                // Left side of line
                Shape compsciBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getCompsciHeardPercent(), 310, songs.get(index + 4)
                        .getCompsciHeardPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarLeft5);
                Shape engeBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getEngeHeardPercent(), 320, songs.get(index + 4)
                        .getEngeHeardPercent(), 10, Color.BLUE);
                window.addShape(engeBarLeft5);
                Shape mathBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getMathHeardPercent(), 330, songs.get(index + 4)
                        .getMathHeardPercent(), 10, Color.RED);
                window.addShape(mathBarLeft5);
                Shape otherBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getOtherHeardPercent(), 340, songs.get(index + 4)
                        .getOtherHeardPercent(), 10, Color.GREEN);
                window.addShape(otherBarLeft5);

                // Right side of line
                Shape compsciBarRight5 = new Shape(455, 310, songs.get(index
                    + 4).getCompsciLikedPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarRight5);
                Shape engeBarRight5 = new Shape(455, 320, songs.get(index + 4)
                    .getEngeLikedPercent(), 10, Color.BLUE);
                window.addShape(engeBarRight5);
                Shape mathBarRight5 = new Shape(455, 330, songs.get(index + 4)
                    .getMathLikedPercent(), 10, Color.RED);
                window.addShape(mathBarRight5);
                Shape otherBarRight5 = new Shape(455, 340, songs.get(index + 4)
                    .getOtherLikedPercent(), 10, Color.GREEN);
                window.addShape(otherBarRight5);

            }
            if (index + 5 < songs.size() - 1) {

                // position 6 row 2
                // ----------------------------------------------------------
                TextShape sixthTitle = new TextShape(700, 275, songs.get(index
                    + 5).getSongTitle());
                sixthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(sixthTitle);

                TextShape sixthArtist = new TextShape(700, 290, "by " + songs
                    .get(index + 5).getArtistName());
                sixthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(sixthArtist);

                Shape line6Glyph = new Shape(750, 310, 5, 40, Color.BLACK);
                window.addShape(line6Glyph);
                window.moveToFront(line6Glyph);
                // position 6 row 2
                // Left side of line
                Shape compsciBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getCompsciHeardPercent(), 310, songs.get(index + 5)
                        .getCompsciHeardPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarLeft6);
                Shape engeBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getEngeHeardPercent(), 320, songs.get(index + 5)
                        .getEngeHeardPercent(), 10, Color.BLUE);
                window.addShape(engeBarLeft6);
                Shape mathBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getMathHeardPercent(), 330, songs.get(index + 5)
                        .getMathHeardPercent(), 10, Color.RED);
                window.addShape(mathBarLeft6);
                Shape otherBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getOtherHeardPercent(), 340, songs.get(index + 5)
                        .getEngeHeardPercent(), 10, Color.GREEN);
                window.addShape(otherBarLeft6);

                // Right side of line
                Shape compsciBarRight6 = new Shape(755, 310, songs.get(index
                    + 5).getCompsciLikedPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarRight6);
                Shape engeBarRight6 = new Shape(755, 320, songs.get(index + 5)
                    .getEngeLikedPercent(), 10, Color.BLUE);
                window.addShape(engeBarRight6);
                Shape mathBarRight6 = new Shape(755, 330, songs.get(index + 5)
                    .getMathLikedPercent(), 10, Color.RED);
                window.addShape(mathBarRight6);
                Shape otherBarRight6 = new Shape(755, 340, songs.get(index + 5)
                    .getOtherLikedPercent(), 10, Color.GREEN);
                window.addShape(otherBarRight6);

            }
            if (index + 6 < songs.size() - 1) {

                // position 7 row 3
                // ----------------------------------------------------------
                TextShape seventhTitle = new TextShape(100, 475, songs.get(index
                    + 6).getSongTitle());
                seventhTitle.setBackgroundColor(Color.WHITE);
                window.addShape(seventhTitle);

                TextShape seventhArtist = new TextShape(100, 490, "by " + songs
                    .get(index + 6).getArtistName());
                seventhArtist.setBackgroundColor(Color.WHITE);
                window.addShape(seventhArtist);

                Shape line7Glyph = new Shape(150, 510, 5, 40, Color.BLACK);
                window.addShape(line7Glyph);
                window.moveToFront(line7Glyph);
                // position 7 row 3
                // Left side of line
                Shape compsciBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getCompsciHeardPercent(), 510, songs.get(index + 6)
                        .getCompsciHeardPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarLeft7);
                Shape engeBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getEngeHeardPercent(), 520, songs.get(index + 6)
                        .getEngeHeardPercent(), 10, Color.BLUE);
                window.addShape(engeBarLeft7);
                Shape mathBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getMathHeardPercent(), 530, songs.get(index + 6)
                        .getMathHeardPercent(), 10, Color.RED);
                window.addShape(mathBarLeft7);
                Shape otherBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getOtherHeardPercent(), 540, songs.get(index + 6)
                        .getOtherHeardPercent(), 10, Color.GREEN);
                window.addShape(otherBarLeft7);

                // Right side of line
                Shape compsciBarRight7 = new Shape(155, 510, songs.get(index
                    + 6).getCompsciLikedPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarRight7);
                Shape engeBarRight7 = new Shape(155, 520, songs.get(index + 6)
                    .getEngeLikedPercent(), 10, Color.BLUE);
                window.addShape(engeBarRight7);
                Shape mathBarRight7 = new Shape(155, 530, songs.get(index + 6)
                    .getMathLikedPercent(), 10, Color.RED);
                window.addShape(mathBarRight7);
                Shape otherBarRight7 = new Shape(155, 540, songs.get(index + 6)
                    .getOtherLikedPercent(), 10, Color.GREEN);
                window.addShape(otherBarRight7);

            }
            if (index + 7 < songs.size() - 1) {
                // position 8 row 3
                // ----------------------------------------------------------
                TextShape eigthTitle = new TextShape(400, 475, songs.get(index
                    + 7).getSongTitle());
                eigthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(eigthTitle);

                TextShape eigthArtist = new TextShape(400, 490, "by " + songs
                    .get(index + 7).getArtistName());
                eigthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(eigthArtist);

                Shape line8Glyph = new Shape(450, 510, 5, 40, Color.BLACK);
                window.addShape(line8Glyph);
                window.moveToFront(line8Glyph);
                // position 8 row 3
                // Left side of line
                Shape compsciBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getCompsciHeardPercent(), 510, songs.get(index + 7)
                        .getCompsciHeardPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarLeft8);
                Shape engeBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getEngeHeardPercent(), 520, songs.get(index + 7)
                        .getEngeHeardPercent(), 10, Color.BLUE);
                window.addShape(engeBarLeft8);
                Shape mathBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getMathHeardPercent(), 530, songs.get(index + 7)
                        .getMathHeardPercent(), 10, Color.RED);
                window.addShape(mathBarLeft8);
                Shape otherBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getOtherHeardPercent(), 540, songs.get(index + 7)
                        .getOtherHeardPercent(), 10, Color.GREEN);
                window.addShape(otherBarLeft8);

                // Right side of line
                Shape compsciBarRight8 = new Shape(455, 510, songs.get(index
                    + 7).getCompsciLikedPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarRight8);
                Shape engeBarRight8 = new Shape(455, 520, songs.get(index + 7)
                    .getEngeLikedPercent(), 10, Color.BLUE);
                window.addShape(engeBarRight8);
                Shape mathBarRight8 = new Shape(455, 530, songs.get(index + 7)
                    .getMathLikedPercent(), 10, Color.RED);
                window.addShape(mathBarRight8);
                Shape otherBarRight8 = new Shape(455, 540, songs.get(index + 7)
                    .getOtherLikedPercent(), 10, Color.GREEN);
                window.addShape(otherBarRight8);
            }
            if (index + 8 < songs.size() - 1) {
                // position 9 row 3
                // ----------------------------------------------------------
                TextShape ninthTitle = new TextShape(700, 475, songs.get(index
                    + 8).getSongTitle());
                ninthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(ninthTitle);

                TextShape ninthArtist = new TextShape(700, 490, "by " + songs
                    .get(index + 8).getArtistName());
                ninthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(ninthArtist);

                Shape line9Glyph = new Shape(750, 510, 5, 40, Color.BLACK);
                window.addShape(line9Glyph);
                window.moveToFront(line9Glyph);
                // position 9 row 3
                // Left side of line
                Shape compsciBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getCompsciHeardPercent(), 510, songs.get(index + 8)
                        .getCompsciHeardPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarLeft9);
                Shape engeBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getEngeHeardPercent(), 520, songs.get(index + 8)
                        .getEngeHeardPercent(), 10, Color.BLUE);
                window.addShape(engeBarLeft9);
                Shape mathBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getMathHeardPercent(), 530, songs.get(index + 8)
                        .getMathHeardPercent(), 10, Color.RED);
                window.addShape(mathBarLeft9);
                Shape otherBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getOtherHeardPercent(), 540, songs.get(index + 8)
                        .getOtherHeardPercent(), 10, Color.GREEN);
                window.addShape(otherBarLeft9);

                // Right side of line
                Shape compsciBarRight9 = new Shape(755, 510, songs.get(index
                    + 8).getCompsciLikedPercent(), 10, Color.MAGENTA);
                window.addShape(compsciBarRight9);
                Shape engeBarRight9 = new Shape(755, 520, songs.get(index + 8)
                    .getEngeLikedPercent(), 10, Color.BLUE);
                window.addShape(engeBarRight9);
                Shape mathBarRight9 = new Shape(755, 530, songs.get(index + 8)
                    .getMathLikedPercent(), 10, Color.RED);
                window.addShape(mathBarRight9);
                Shape otherBarRight9 = new Shape(755, 540, songs.get(index + 8)
                    .getOtherLikedPercent(), 10, Color.GREEN);
                window.addShape(otherBarRight9);
            }
        }
        if (legendTitle.equals("Region Legend")) {
            // System.out.println(songs.get(index)
            // .getRestHeardPercent());
            // System.out.println(songs.get(index)
            // .getRestLikedPercent());
            if (index < songs.size() - 1) {
                TextShape firstTitle = new TextShape(100, 75, songs.get(index)
                    .getSongTitle());
                firstTitle.setBackgroundColor(Color.WHITE);
                window.addShape(firstTitle);

                TextShape firstArtist = new TextShape(100, 90, "by " + songs
                    .get(index).getArtistName());
                firstArtist.setBackgroundColor(Color.WHITE);
                window.addShape(firstArtist);

                Shape lineGlyph = new Shape(150, 110, 5, 40, Color.BLACK);
                window.addShape(lineGlyph);
                window.moveToFront(lineGlyph);

                Shape northBarLeft = new Shape(150 - songs.get(index)
                    .getNorthHeardPercent(), 110, songs.get(index)
                        .getNorthHeardPercent(), 10, Color.MAGENTA);
                window.addShape(northBarLeft);
                Shape southBarLeft = new Shape(150 - songs.get(index)
                    .getSouthHeardPercent(), 120, songs.get(index)
                        .getSouthHeardPercent(), 10, Color.BLUE);
                window.addShape(southBarLeft);
                Shape restBarLeft = new Shape(150 - songs.get(index)
                    .getRestHeardPercent(), 130, songs.get(index)
                        .getRestHeardPercent(), 10, Color.RED);
                window.addShape(restBarLeft);
                Shape outsideBarLeft = new Shape(150 - songs.get(index)
                    .getOutsideHeardPercent(), 140, songs.get(index)
                        .getOutsideHeardPercent(), 10, Color.GREEN);
                window.addShape(outsideBarLeft);

                // Right side of line
                Shape northBarRight = new Shape(155, 110, songs.get(index)
                    .getNorthLikedPercent(), 10, Color.MAGENTA);
                window.addShape(northBarRight);
                Shape southBarRight = new Shape(155, 120, songs.get(index)
                    .getSouthLikedPercent(), 10, Color.BLUE);
                window.addShape(southBarRight);
                Shape restBarRight = new Shape(155, 130, songs.get(index)
                    .getRestLikedPercent(), 10, Color.RED);
                window.addShape(restBarRight);
                Shape outsideBarRight = new Shape(155, 140, songs.get(index)
                    .getOutsideLikedPercent(), 10, Color.GREEN);
                window.addShape(outsideBarRight);
            }
            if (index + 1 < songs.size() - 1) {

                // position 2 row 1
                // ------------------------------------------------------
                TextShape secondTitle = new TextShape(400, 75, songs.get(index
                    + 1).getSongTitle());
                secondTitle.setBackgroundColor(Color.WHITE);
                window.addShape(secondTitle);

                TextShape secondArtist = new TextShape(400, 90, "by " + songs
                    .get(index + 1).getArtistName());
                secondArtist.setBackgroundColor(Color.WHITE);
                window.addShape(secondArtist);

                Shape line2Glyph = new Shape(450, 110, 5, 40, Color.BLACK);
                window.addShape(line2Glyph);
                window.moveToFront(line2Glyph);
                Shape northBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getNorthHeardPercent(), 110, songs.get(index + 1)
                        .getNorthHeardPercent(), 10, Color.MAGENTA);
                window.addShape(northBarLeft2);
                Shape southBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getSouthHeardPercent(), 120, songs.get(index + 1)
                        .getSouthHeardPercent(), 10, Color.BLUE);
                window.addShape(southBarLeft2);
                Shape restBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getRestHeardPercent(), 130, songs.get(index + 1)
                        .getRestHeardPercent(), 10, Color.RED);
                window.addShape(restBarLeft2);
                Shape outsideBarLeft2 = new Shape(450 - songs.get(index + 1)
                    .getOutsideHeardPercent(), 140, songs.get(index + 1)
                        .getOutsideHeardPercent(), 10, Color.GREEN);
                window.addShape(outsideBarLeft2);

                // Right side of line
                Shape northBarRight2 = new Shape(455, 110, songs.get(index + 1)
                    .getNorthLikedPercent(), 10, Color.MAGENTA);
                window.addShape(northBarRight2);
                Shape southBarRight2 = new Shape(455, 120, songs.get(index + 1)
                    .getSouthLikedPercent(), 10, Color.BLUE);
                window.addShape(southBarRight2);
                Shape restBarRight2 = new Shape(455, 130, songs.get(index + 1)
                    .getRestLikedPercent(), 10, Color.RED);
                window.addShape(restBarRight2);
                Shape outsideBarRight2 = new Shape(455, 140, songs.get(index
                    + 1).getOutsideLikedPercent(), 10, Color.GREEN);
                window.addShape(outsideBarRight2);
            }

            if (index + 2 < songs.size() - 1) {
                // position 3 row 1
                // ------------------------------------------------------
                TextShape thirdTitle = new TextShape(700, 75, songs.get(index
                    + 2).getSongTitle());
                thirdTitle.setBackgroundColor(Color.WHITE);
                window.addShape(thirdTitle);

                TextShape thirdArtist = new TextShape(700, 90, "by " + songs
                    .get(index + 2).getArtistName());
                thirdArtist.setBackgroundColor(Color.WHITE);
                window.addShape(thirdArtist);

                Shape line3Glyph = new Shape(750, 110, 5, 40, Color.BLACK);
                window.addShape(line3Glyph);
                window.moveToFront(line3Glyph);
                // position 3 row 1
                // Left side of line
                Shape northBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getNorthHeardPercent(), 110, songs.get(index + 2)
                        .getNorthHeardPercent(), 10, Color.MAGENTA);
                window.addShape(northBarLeft3);
                Shape southBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getSouthHeardPercent(), 120, songs.get(index + 2)
                        .getSouthHeardPercent(), 10, Color.BLUE);
                window.addShape(southBarLeft3);
                Shape restBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getRestHeardPercent(), 130, songs.get(index + 2)
                        .getRestHeardPercent(), 10, Color.RED);
                window.addShape(restBarLeft3);
                Shape outsideBarLeft3 = new Shape(750 - songs.get(index + 2)
                    .getOutsideHeardPercent(), 140, songs.get(index + 2)
                        .getOutsideHeardPercent(), 10, Color.GREEN);
                window.addShape(outsideBarLeft3);

                // Right side of line
                Shape northBarRight3 = new Shape(755, 110, songs.get(index + 2)
                    .getNorthLikedPercent(), 10, Color.MAGENTA);
                window.addShape(northBarRight3);
                Shape southBarRight3 = new Shape(755, 120, songs.get(index + 2)
                    .getSouthLikedPercent(), 10, Color.BLUE);
                window.addShape(southBarRight3);
                Shape restBarRight3 = new Shape(755, 130, songs.get(index + 2)
                    .getRestLikedPercent(), 10, Color.RED);
                window.addShape(restBarRight3);
                Shape outsideBarRight3 = new Shape(755, 140, songs.get(index
                    + 2).getOutsideLikedPercent(), 10, Color.GREEN);
                window.addShape(outsideBarRight3);

            }
            if (index + 3 < songs.size() - 1) {
                // position 4 row 2
                // ---------------------------------------------------------
                TextShape fourthTitle = new TextShape(100, 275, songs.get(index
                    + 3).getSongTitle());
                fourthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(fourthTitle);

                TextShape fourthArtist = new TextShape(100, 290, "by " + songs
                    .get(index + 3).getArtistName());
                fourthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(fourthArtist);

                Shape line4Glyph = new Shape(150, 310, 5, 40, Color.BLACK);
                window.addShape(line4Glyph);
                window.moveToFront(line4Glyph);
                // position 4 row 2
                // Left side of line
                Shape northBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getNorthHeardPercent(), 310, songs.get(index + 3)
                        .getNorthHeardPercent(), 10, Color.MAGENTA);
                window.addShape(northBarLeft4);
                Shape southBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getSouthHeardPercent(), 320, songs.get(index + 3)
                        .getSouthHeardPercent(), 10, Color.BLUE);
                window.addShape(southBarLeft4);
                Shape restBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getRestHeardPercent(), 330, songs.get(index + 3)
                        .getRestHeardPercent(), 10, Color.RED);
                window.addShape(restBarLeft4);
                Shape outsideBarLeft4 = new Shape(150 - songs.get(index + 3)
                    .getOutsideHeardPercent(), 340, songs.get(index + 3)
                        .getOutsideHeardPercent(), 10, Color.GREEN);
                window.addShape(outsideBarLeft4);

                // Right side of line
                Shape northBarRight4 = new Shape(155, 310, songs.get(index + 3)
                    .getNorthLikedPercent(), 10, Color.MAGENTA);
                window.addShape(northBarRight4);
                Shape southBarRight4 = new Shape(155, 320, songs.get(index + 3)
                    .getSouthLikedPercent(), 10, Color.BLUE);
                window.addShape(southBarRight4);
                Shape restBarRight4 = new Shape(155, 330, songs.get(index + 3)
                    .getRestLikedPercent(), 10, Color.RED);
                window.addShape(restBarRight4);
                Shape outsideBarRight4 = new Shape(155, 340, songs.get(index
                    + 3).getOutsideLikedPercent(), 10, Color.GREEN);
                window.addShape(outsideBarRight4);

            }
            if (index + 4 < songs.size() - 1) {

                // position 5 row
                // 2----------------------------------------------------------
                TextShape fifthTitle = new TextShape(400, 275, songs.get(index
                    + 4).getSongTitle());
                fifthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(fifthTitle);

                TextShape fifthArtist = new TextShape(400, 290, "by " + songs
                    .get(index + 4).getArtistName());
                fifthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(fifthArtist);

                Shape line5Glyph = new Shape(450, 310, 5, 40, Color.BLACK);
                window.addShape(line5Glyph);
                window.moveToFront(line5Glyph);
                // position 5 row 2
                // Left side of line
                Shape northBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getNorthHeardPercent(), 310, songs.get(index + 4)
                        .getNorthHeardPercent(), 10, Color.MAGENTA);
                window.addShape(northBarLeft5);
                Shape southBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getSouthHeardPercent(), 320, songs.get(index + 4)
                        .getSouthHeardPercent(), 10, Color.BLUE);
                window.addShape(southBarLeft5);
                Shape restBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getRestHeardPercent(), 330, songs.get(index + 4)
                        .getRestHeardPercent(), 10, Color.RED);
                window.addShape(restBarLeft5);
                Shape outsideBarLeft5 = new Shape(450 - songs.get(index + 4)
                    .getOutsideHeardPercent(), 340, songs.get(index + 4)
                        .getOutsideHeardPercent(), 10, Color.GREEN);
                window.addShape(outsideBarLeft5);

                // Right side of line
                Shape northBarRight5 = new Shape(455, 310, songs.get(index + 4)
                    .getNorthLikedPercent(), 10, Color.MAGENTA);
                window.addShape(northBarRight5);
                Shape southBarRight5 = new Shape(455, 320, songs.get(index + 4)
                    .getSouthLikedPercent(), 10, Color.BLUE);
                window.addShape(southBarRight5);
                Shape restBarRight5 = new Shape(455, 330, songs.get(index + 4)
                    .getRestLikedPercent(), 10, Color.RED);
                window.addShape(restBarRight5);
                Shape outsideBarRight5 = new Shape(455, 340, songs.get(index
                    + 4).getOutsideLikedPercent(), 10, Color.GREEN);
                window.addShape(outsideBarRight5);

            }
            if (index + 5 < songs.size() - 1) {

                // position 6 row 2
                // ----------------------------------------------------------
                TextShape sixthTitle = new TextShape(700, 275, songs.get(index
                    + 5).getSongTitle());
                sixthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(sixthTitle);

                TextShape sixthArtist = new TextShape(700, 290, "by " + songs
                    .get(index + 5).getArtistName());
                sixthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(sixthArtist);

                Shape line6Glyph = new Shape(750, 310, 5, 40, Color.BLACK);
                window.addShape(line6Glyph);
                window.moveToFront(line6Glyph);
                // position 6 row 2
                // Left side of line
                Shape northBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getNorthHeardPercent(), 310, songs.get(index + 5)
                        .getNorthHeardPercent(), 10, Color.MAGENTA);
                window.addShape(northBarLeft6);
                Shape southBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getSouthHeardPercent(), 320, songs.get(index + 5)
                        .getSouthHeardPercent(), 10, Color.BLUE);
                window.addShape(southBarLeft6);
                Shape restBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getRestHeardPercent(), 330, songs.get(index + 5)
                        .getRestHeardPercent(), 10, Color.RED);
                window.addShape(restBarLeft6);
                Shape outsideBarLeft6 = new Shape(750 - songs.get(index + 5)
                    .getOutsideHeardPercent(), 340, songs.get(index + 5)
                        .getSouthHeardPercent(), 10, Color.GREEN);
                window.addShape(outsideBarLeft6);

                // Right side of line
                Shape northBarRight6 = new Shape(755, 310, songs.get(index + 5)
                    .getNorthLikedPercent(), 10, Color.MAGENTA);
                window.addShape(northBarRight6);
                Shape southBarRight6 = new Shape(755, 320, songs.get(index + 5)
                    .getSouthLikedPercent(), 10, Color.BLUE);
                window.addShape(southBarRight6);
                Shape restBarRight6 = new Shape(755, 330, songs.get(index + 5)
                    .getRestLikedPercent(), 10, Color.RED);
                window.addShape(restBarRight6);
                Shape outsideBarRight6 = new Shape(755, 340, songs.get(index
                    + 5).getOutsideLikedPercent(), 10, Color.GREEN);
                window.addShape(outsideBarRight6);

            }
            if (index + 6 < songs.size() - 1) {

                // position 7 row 3
                // ----------------------------------------------------------
                TextShape seventhTitle = new TextShape(100, 475, songs.get(index
                    + 6).getSongTitle());
                seventhTitle.setBackgroundColor(Color.WHITE);
                window.addShape(seventhTitle);

                TextShape seventhArtist = new TextShape(100, 490, "by " + songs
                    .get(index + 6).getArtistName());
                seventhArtist.setBackgroundColor(Color.WHITE);
                window.addShape(seventhArtist);

                Shape line7Glyph = new Shape(150, 510, 5, 40, Color.BLACK);
                window.addShape(line7Glyph);
                window.moveToFront(line7Glyph);
                // position 7 row 3
                // Left side of line
                Shape northBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getNorthHeardPercent(), 510, songs.get(index + 6)
                        .getNorthHeardPercent(), 10, Color.MAGENTA);
                window.addShape(northBarLeft7);
                Shape southBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getSouthHeardPercent(), 520, songs.get(index + 6)
                        .getSouthHeardPercent(), 10, Color.BLUE);
                window.addShape(southBarLeft7);
                Shape restBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getRestHeardPercent(), 530, songs.get(index + 6)
                        .getRestHeardPercent(), 10, Color.RED);
                window.addShape(restBarLeft7);
                Shape outsideBarLeft7 = new Shape(150 - songs.get(index + 6)
                    .getOutsideHeardPercent(), 540, songs.get(index + 6)
                        .getOutsideHeardPercent(), 10, Color.GREEN);
                window.addShape(outsideBarLeft7);

                // Right side of line
                Shape northBarRight7 = new Shape(155, 510, songs.get(index + 6)
                    .getNorthLikedPercent(), 10, Color.MAGENTA);
                window.addShape(northBarRight7);
                Shape southBarRight7 = new Shape(155, 520, songs.get(index + 6)
                    .getSouthLikedPercent(), 10, Color.BLUE);
                window.addShape(southBarRight7);
                Shape restBarRight7 = new Shape(155, 530, songs.get(index + 6)
                    .getRestLikedPercent(), 10, Color.RED);
                window.addShape(restBarRight7);
                Shape outsideBarRight7 = new Shape(155, 540, songs.get(index
                    + 6).getOutsideLikedPercent(), 10, Color.GREEN);
                window.addShape(outsideBarRight7);

            }
            if (index + 7 < songs.size() - 1) {
                // position 8 row 3
                // ----------------------------------------------------------
                TextShape eigthTitle = new TextShape(400, 475, songs.get(index
                    + 7).getSongTitle());
                eigthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(eigthTitle);

                TextShape eigthArtist = new TextShape(400, 490, "by " + songs
                    .get(index + 7).getArtistName());
                eigthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(eigthArtist);

                Shape line8Glyph = new Shape(450, 510, 5, 40, Color.BLACK);
                window.addShape(line8Glyph);
                window.moveToFront(line8Glyph);
                // position 8 row 3
                // Left side of line
                Shape northBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getNorthHeardPercent(), 510, songs.get(index + 7)
                        .getNorthHeardPercent(), 10, Color.MAGENTA);
                window.addShape(northBarLeft8);
                Shape southBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getSouthHeardPercent(), 520, songs.get(index + 7)
                        .getSouthHeardPercent(), 10, Color.BLUE);
                window.addShape(southBarLeft8);
                Shape restBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getRestHeardPercent(), 530, songs.get(index + 7)
                        .getRestHeardPercent(), 10, Color.RED);
                window.addShape(restBarLeft8);
                Shape outsideBarLeft8 = new Shape(450 - songs.get(index + 7)
                    .getOutsideHeardPercent(), 540, songs.get(index + 7)
                        .getOutsideHeardPercent(), 10, Color.GREEN);
                window.addShape(outsideBarLeft8);

                // Right side of line
                Shape northBarRight8 = new Shape(455, 510, songs.get(index + 7)
                    .getNorthLikedPercent(), 10, Color.MAGENTA);
                window.addShape(northBarRight8);
                Shape southBarRight8 = new Shape(455, 520, songs.get(index + 7)
                    .getSouthLikedPercent(), 10, Color.BLUE);
                window.addShape(southBarRight8);
                Shape restBarRight8 = new Shape(455, 530, songs.get(index + 7)
                    .getRestLikedPercent(), 10, Color.RED);
                window.addShape(restBarRight8);
                Shape outsideBarRight8 = new Shape(455, 540, songs.get(index
                    + 7).getOutsideLikedPercent(), 10, Color.GREEN);
                window.addShape(outsideBarRight8);
            }
            if (index + 8 < songs.size() - 1) {
                // position 9 row 3
                // ----------------------------------------------------------
                TextShape ninthTitle = new TextShape(700, 475, songs.get(index
                    + 8).getSongTitle());
                ninthTitle.setBackgroundColor(Color.WHITE);
                window.addShape(ninthTitle);

                TextShape ninthArtist = new TextShape(700, 490, "by " + songs
                    .get(index + 8).getArtistName());
                ninthArtist.setBackgroundColor(Color.WHITE);
                window.addShape(ninthArtist);

                Shape line9Glyph = new Shape(750, 510, 5, 40, Color.BLACK);
                window.addShape(line9Glyph);
                window.moveToFront(line9Glyph);
                // position 9 row 3
                // Left side of line
                Shape northBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getNorthHeardPercent(), 510, songs.get(index + 8)
                        .getNorthHeardPercent(), 10, Color.MAGENTA);
                window.addShape(northBarLeft9);
                Shape southBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getSouthHeardPercent(), 520, songs.get(index + 8)
                        .getSouthHeardPercent(), 10, Color.BLUE);
                window.addShape(southBarLeft9);
                Shape restBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getRestHeardPercent(), 530, songs.get(index + 8)
                        .getRestHeardPercent(), 10, Color.RED);
                window.addShape(restBarLeft9);
                Shape outsideBarLeft9 = new Shape(750 - songs.get(index + 8)
                    .getOutsideHeardPercent(), 540, songs.get(index + 8)
                        .getOutsideHeardPercent(), 10, Color.GREEN);
                window.addShape(outsideBarLeft9);

                // Right side of line
                Shape northBarRight9 = new Shape(755, 510, songs.get(index + 8)
                    .getNorthLikedPercent(), 10, Color.MAGENTA);
                window.addShape(northBarRight9);
                Shape southBarRight9 = new Shape(755, 520, songs.get(index + 8)
                    .getSouthLikedPercent(), 10, Color.BLUE);
                window.addShape(southBarRight9);
                Shape restBarRight9 = new Shape(755, 530, songs.get(index + 8)
                    .getRestLikedPercent(), 10, Color.RED);
                window.addShape(restBarRight9);
                Shape outsideBarRight9 = new Shape(755, 540, songs.get(index
                    + 8).getOutsideLikedPercent(), 10, Color.GREEN);
                window.addShape(outsideBarRight9);
            }
        }

        if (legendTitle.equals("Hobby Legend")) {

            changeHobbyLegend();
            // changeHobbyBars(songs, users, pageNumber);

        }
        else if (legendTitle.equals("Major Legend")) {
            changeMajorLegend();
        }
        else {
            changeRegionLegend();
        }
    }


    /**
     * Gets the window
     * 
     * @return window for project
     */
    public Window getWindow() {
        return window;
    }


    /**
     * Exits program when quit is clicked
     * 
     * @param button
     *            quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Button to go to the previous page
     * 
     * @param button
     *            previous button
     */
    public void clickedPrev(Button button) {
        LinkedList<Song> songList = data.getSongList();
        LinkedList<User> userList = data.getUserList();

        if (page > 1) {
            button.enable();
            page--;
            window.removeAllShapes();
            drawGlyphs(songList, userList, page);
        }
        else {
            button.disable();
        }

    }


    /**
     * Button to go to the next page
     * 
     * @param button
     *            next button
     */
    public void clickedNext(Button button) {
        LinkedList<Song> songList = data.getSongList();
        LinkedList<User> userList = data.getUserList();
        int max = songList.size() / 9;

        if (page < max + 1) {
            button.enable();
            page++;
            window.removeAllShapes();
            // System.out.println("next");
            drawGlyphs(songList, userList, page);

        }
        else {
            button.disable();
        }

    }


    /**
     * Button when you click artist name
     * 
     * @param button
     *            artist button
     */
    public void clickedArtistName(Button button) {

        LinkedList<Song> songList = data.getSongList();
        LinkedList<User> userList = data.getUserList();
        songList = data.sortByArtist(songList);

        isGenre = false;
        isDate = false;
        drawGlyphs(songList, userList, page);

    }


    /**
     * Button when you click song title
     * 
     * @param button
     *            title button
     */
    public void clickedSongTitle(Button button) {
        LinkedList<Song> songList = data.getSongList();
        LinkedList<User> userList = data.getUserList();
        songList = data.sortByTitle(songList);

        isGenre = false;
        isDate = false;
        drawGlyphs(songList, userList, page);

    }


    /**
     * Button when you click release year
     * 
     * @param button
     *            year button
     */
    public void clickedReleaseYear(Button button) {
        LinkedList<Song> songList = data.getSongList();
        LinkedList<User> userList = data.getUserList();
        songList = data.sortByDate(songList);

        isGenre = false;
        isDate = true;
        drawGlyphs(songList, userList, page);

    }


    /**
     * Button when you click genre
     * 
     * @param button
     *            genre button
     */
    public void clickedGenre(Button button) {
        LinkedList<Song> songList = data.getSongList();
        LinkedList<User> userList = data.getUserList();
        songList = data.sortByGenre(songList);

        isGenre = true;
        isDate = false;
        drawGlyphs(songList, userList, page);

    }


    /**
     * Button when you click hobby
     * 
     * @param button
     *            hobby button
     */
    public void clickedHobby(Button button) {

        LinkedList<Song> songList = data.getSongList();
        LinkedList<User> userList = data.getUserList();
        data.setPercentHobby(songList, userList);
        legendTitle = "Hobby Legend";
        prev.enable();
        next.enable();
        sortSong.enable();
        sortArtist.enable();
        sortYear.enable();
        sortGenre.enable();
        initializeWindow();
        drawGlyphs(songList, userList, page);

    }


    /**
     * changes the legend to a hobby legend
     */

    public void changeHobbyLegend() {
        legendTitle = "Hobby Legend";
        legend = new TextShape(935, 400, legendTitle);
        legend.setBackgroundColor(Color.WHITE);
        window.addShape(legend);

        TextShape read = new TextShape(935, 415, "Read", Color.MAGENTA);
        read.setBackgroundColor(Color.WHITE);
        window.addShape(read);

        TextShape art = new TextShape(935, 430, "Art", Color.BLUE);
        art.setBackgroundColor(Color.WHITE);
        window.addShape(art);

        TextShape sports = new TextShape(935, 445, "Sports", Color.RED);
        sports.setBackgroundColor(Color.WHITE);
        window.addShape(sports);

        TextShape music = new TextShape(935, 460, "Music", Color.GREEN);
        music.setBackgroundColor(Color.WHITE);
        window.addShape(music);
    }


    /**
     * @param button
     *            major button
     *            button when you click major
     */
    public void clickedMajor(Button button) {
        LinkedList<Song> songList = data.getSongList();
        LinkedList<User> userList = data.getUserList();
        data.setPercentMajor(songList, userList);
        prev.enable();
        next.enable();
        sortSong.enable();
        sortArtist.enable();
        sortYear.enable();
        sortGenre.enable();
        legendTitle = "Major Legend";
        initializeWindow();
        drawGlyphs(songList, userList, page);

    }


    /**
     * changes legend to major legend
     */

    public void changeMajorLegend() {
        legendTitle = "Major Legend";

        legend = new TextShape(935, 400, legendTitle);
        legend.setBackgroundColor(Color.WHITE);
        window.addShape(legend);

        TextShape compSci = new TextShape(935, 415, "Comp Sci", Color.MAGENTA);
        compSci.setBackgroundColor(Color.WHITE);
        window.addShape(compSci);

        TextShape otherEng = new TextShape(935, 430, "Other Eng", Color.BLUE);
        otherEng.setBackgroundColor(Color.WHITE);
        window.addShape(otherEng);

        TextShape mathCmda = new TextShape(935, 445, "Math/CMDA", Color.RED);
        mathCmda.setBackgroundColor(Color.WHITE);
        window.addShape(mathCmda);

        TextShape other = new TextShape(935, 460, "Other", Color.GREEN);
        other.setBackgroundColor(Color.WHITE);
        window.addShape(other);

    }


    /**
     * Button when you click region
     * 
     * @param button
     *            region button
     */
    public void clickedRegion(Button button) {
        LinkedList<Song> songList = data.getSongList();
        LinkedList<User> userList = data.getUserList();
        data.setPercentRegion(songList, userList);
        prev.enable();
        next.enable();
        sortSong.enable();
        sortArtist.enable();
        sortYear.enable();
        sortGenre.enable();
        legendTitle = "Region Legend";
        initializeWindow();
        drawGlyphs(songList, userList, page);

    }


    /**
     * changes legend to region legend
     */

    public void changeRegionLegend() {
        legendTitle = "Region Legend";
        legend = new TextShape(935, 400, legendTitle);
        legend.setBackgroundColor(Color.WHITE);
        window.addShape(legend);

        TextShape northeast = new TextShape(935, 415, "Northeast",
            Color.MAGENTA);
        northeast.setBackgroundColor(Color.WHITE);
        window.addShape(northeast);

        TextShape southeast = new TextShape(935, 430, "Southeast", Color.BLUE);
        southeast.setBackgroundColor(Color.WHITE);
        window.addShape(southeast);

        TextShape restOfUs = new TextShape(935, 445, "Rest of US", Color.RED);
        restOfUs.setBackgroundColor(Color.WHITE);
        window.addShape(restOfUs);

        TextShape outside = new TextShape(935, 460, "Outside of US",
            Color.GREEN);
        outside.setBackgroundColor(Color.WHITE);
        window.addShape(outside);
    }
}
