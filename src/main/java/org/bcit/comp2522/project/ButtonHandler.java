package org.bcit.comp2522.project;

import processing.core.PApplet;

/**
 * Handles the interactions with menu items.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 *
 */
public class ButtonHandler {
    Window parent;

    Button button;



    public ButtonHandler(Button button){

        this.button = button;
        this.parent = button.getParent();
    }

    public boolean checkHover(int mouseX, int mouseY){
        int x = button.getX();
        int y = button.getY();
        int width = button.getWidth();
        int height = button.getHeight();
        int xRadius = width / 2;
        int yRadius = height / 2;


        return mouseX >= x - xRadius && mouseX <= x + xRadius &&
                mouseY >= y - yRadius && mouseY <= y + yRadius;


    }



    public void clickHandler(int mouseX, int mouseY){


        if (button.getFunction() == ButtonFunction.START && checkHover(mouseX, mouseY)){
            parent.setStage(2);
        }
        if (button.getFunction() == ButtonFunction.HIGHSCORE && checkHover(mouseX, mouseY)){
            parent.setStage(5);
        }

    }


}
