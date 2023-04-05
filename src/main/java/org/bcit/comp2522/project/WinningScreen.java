package org.bcit.comp2522.project;

import processing.core.PApplet;
import processing.core.PFont;

import java.util.Scanner;

import static processing.event.MouseEvent.ENTER;

public class WinningScreen {

    private Window parent;

    private PFont gameFont;

    private Scanner scanner;

    private String userInput = "";

    public WinningScreen(Window parent){
        this.parent = parent;
    }

    public void display(){

        String dataPath = parent.sketchPath("fonts");
        gameFont = parent.createFont("" + dataPath + "/Righteous-Regular.ttf", 400);
        parent.textFont(gameFont);
        parent.background(0);
        parent.textSize(50);
        parent.textAlign(parent.CENTER, parent.CENTER);
        parent.fill(255);
        parent.text("YAY YOU WON!   :) " +
                "\nYour score was: " + Player.getCurrentScore(), Window.windowWidth/2, Window.windowHeight/3);
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
