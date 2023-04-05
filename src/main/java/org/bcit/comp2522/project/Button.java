package org.bcit.comp2522.project;

import processing.core.PApplet;
import processing.core.PFont;

/**
 * Display buttons class for Menu options
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class Button {



    private Window parent;

    private int x; //y-coordinate of the button in the Window

    private int y;  //y-coordinate of the button in the Window

    ButtonFunction function; //enum function of a button

    boolean isHovered = false; //if the button is hovered over

    private String text; //text displayed on the button



    private int buttonWidth;
    private int buttonHeight;

    public Button(Window parent, String text, ButtonFunction function, int x, int y){
        this.parent = parent;
        this.text = text;
        this.x = x;
        this.y = y;
        this.function = function;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidth() {
        return buttonWidth;
    }

    public void setWidth(int width) {
        this.buttonWidth = width;
    }

    public int getHeight() {
        return buttonHeight;
    }

    public void setHeight(int height) {
        this.buttonHeight = height;
    }

    public boolean getHovered() {
        return isHovered;
    }

    public Window getParent() {
        return parent;
    }

    public ButtonFunction getFunction() {
        return function;
    }

    public void setHovered(boolean hovered) {
        isHovered = hovered;
        System.out.println("hovered");
    }

    public void menuButtonShape(){
        this.buttonWidth = 400;
        this.buttonHeight = 100;
        parent.rectMode(parent.CENTER);
        parent.fill(0,0,0);
        parent.rect(this.x, this.y, buttonWidth,buttonHeight);
    }

    public void menuButtonText(){
        PFont gameFont;
        String dataPath = parent.sketchPath("fonts");
        gameFont = parent.createFont("" + dataPath + "/Righteous-Regular.ttf", 400);
        parent.textFont(gameFont);
        parent.fill(255);
        parent.textSize(16);
        parent.textAlign(parent.CENTER);
        parent.text(this.text, this.x, this.y);
    }

    public void displayButton(){
        menuButtonShape();
        menuButtonText();
    }
}
