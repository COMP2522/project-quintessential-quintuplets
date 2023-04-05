package org.bcit.comp2522.project;

import java.util.zip.GZIPInputStream;

public class Grid {
  public static final int GRID_SIZE = 12;
  private Window window;
  public Grid(Window window){
    this.window = window;
  }
  public void draw(){
    window.pushStyle();
    window.stroke(204, 102, 0);
    window.line(40,0,40,720);
    window.line(1240,0,1240,720);
    window.popStyle();
    window.pushStyle();
    window.stroke(27, 168, 240);
    for (int i = 40; i <= 1240; i += 48){
      window.line(i,0,i,720);
      window.text(i, i+10, 700);
      window.fill(27, 168, 240);
    }
    for (int i = 0; i <= 720; i += 48){
      window.line(40,i,1240,i);
      //window.text(i, 10, i);
    }
    window.popStyle();
    window.pushStyle();

    for (int i = 0; i <= 720; i += 48){
      window.text(i, 20, i+10);
      window.fill(27, 168, 240);
    }
    window.fill(27, 168, 240);
    window.popStyle();
  }
}
