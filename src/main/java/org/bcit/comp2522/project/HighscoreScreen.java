package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

/**
 * Displays top 10 highscores
 */
public class HighscoreScreen {

    private Window window;

    private PImage backgroundImage;

    ArrayList<Highscore> highscores = new ArrayList<Highscore>();

    private int scrollCount = 0;


    public HighscoreScreen(Window window) {
        this.window = window;
        this.backgroundImage = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/BackDrop.png");


    }

    public void display() {

        window.image(backgroundImage, 0,0, Window.windowWidth, Window.windowHeight);
        window.textAlign(window.CENTER);
        window.fill(255);
        window.textSize(50);

        window.text("Leader Board", Window.windowWidth / 2 , Window.windowHeight * 2 / 12);
        window.textSize(40);
        retrieveHighscores();

    }

    public void refreshHighscores(){
        Highscore hs = new Highscore();
        highscores = new ArrayList<Highscore>();
        highscores = hs.retrieveHighscores();

    }

    public void retrieveHighscores() {

        String user;
        int score;
        String entry;


        for (int i = 0; i < highscores.size(); i++){



            user = highscores.get(i).getUser().toUpperCase();
            score = highscores.get(i).getHighscore();
//            entry = "" + user.toUpperCase() + "\t\t\t\t" + score;


            window.text(user, Window.windowWidth * 2 / 6, (Window.windowHeight * (i + 3) / 12));
            window.text(score, Window.windowWidth * 4 /6, Window.windowHeight * (i + 3) / 12);

        }

    }

}
