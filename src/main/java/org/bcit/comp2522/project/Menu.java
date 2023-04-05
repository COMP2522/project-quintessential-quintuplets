package org.bcit.comp2522.project;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;


/**
 * Displays Menu screen
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class Menu {

    private Window parent;
    private PImage backgroundImage;

    ButtonHandler startBH;

    ButtonHandler loadBH;

    ButtonHandler highscoreBH;


    public Menu(Window parent) {
        this.parent = parent;
        String dataPath = parent.sketchPath("images");
        this.backgroundImage = parent.loadImage(dataPath + "/laptop.jpg");

    }

    public void display() {

        parent.image(backgroundImage, 0, 0, Window.windowWidth, Window.windowHeight);

        int horizontalPos = Window.windowWidth/ 2;

        Button startButton = new Button(parent, "START GAME", ButtonFunction.START, horizontalPos, Window.windowHeight * 3 / 12);
        Button loadButton = new Button(parent, "LOAD GAME", ButtonFunction.LOAD, horizontalPos, Window.windowHeight * 5 / 12);
        Button hsButton = new Button(parent, "HIGH SCORES", ButtonFunction.HIGHSCORE, horizontalPos, Window.windowHeight * 7 / 12);
        startBH = new ButtonHandler(startButton);
        loadBH = new ButtonHandler(loadButton);
        highscoreBH = new ButtonHandler(hsButton);

        startButton.displayButton();
        loadButton.displayButton();
        hsButton.displayButton();

    }

    public void mousePressed(int mouseX, int mouseY) {
        startBH.clickHandler(mouseX, mouseY);
        //loadBH.clickHandler();

        highscoreBH.clickHandler(mouseX, mouseY);
    }

}
