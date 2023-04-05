package org.bcit.comp2522.project;

import processing.core.PFont;

/**
 * Displays Losing screen
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class LosingScreen {
    private final Window parent;
    private final int size = 400;

    public LosingScreen(Window parent){
        this.parent = parent;
    }

    public void display(){
        PFont gameFont;
        String dataPath = parent.sketchPath("fonts");
        gameFont = parent.createFont("" + dataPath + "/Righteous-Regular.ttf", size);
        parent.textFont(gameFont);
        parent.background(0);
        parent.textSize(50);
        parent.textAlign(parent.CENTER, parent.CENTER);
        parent.text("OH NO\nYOU LOST  :( " +
                "\nYour score was :" + Player.getCurrentScore(), Window.windowWidth/2, Window.windowHeight/3);

        parent.text("ENTER YOUR NAME:", Window.windowWidth/3, Window.windowHeight * 8 /12);
        parent.fill(111,185,15);
        parent.text(parent.getUserInput().toUpperCase(), Window.windowWidth * 2 / 3, Window.windowHeight * 8/12);

        parent.fill(255);
        parent.text("HIT ENTER TO SAVE", Window.windowWidth * 2 / 3, Window.windowHeight * 10/12);
    }

    public void logHighscore(){
        DatabaseHandler dbh = new DatabaseHandler();
        dbh.insertHighScore(parent.getUserInput().toUpperCase(), Player.getCurrentScore());
        parent.setUserInput("");
        parent.setStage(1);

    }


}
