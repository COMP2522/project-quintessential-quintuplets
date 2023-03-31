package org.bcit.comp2522.project;

import java.util.ArrayList;

public class Highscore {


    private int highscore;
    private String user;


    public Highscore() {

    }

    public Highscore(String user) {

        this.highscore = Player.getCurrentScore();
        this.user = user;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public void publishHighscore() {
        DatabaseHandler dbh = new DatabaseHandler("testuser", "cake1234");
        dbh.insertHighScore(user, highscore);
    }

    public void retrieveHighscores() {
        DatabaseHandler dbh = new DatabaseHandler("testuser", "cake1234");
        dbh.retrieveHighScores();
    }

    }





