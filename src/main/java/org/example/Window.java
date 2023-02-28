package org.example;

import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;


public class Window extends PApplet {


  public void settings() {
    size(640,360);
  }

  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"towerDefence"};
    Window tdGame = new Window();
    PApplet.runSketch(appletArgs, tdGame);
  }
}
