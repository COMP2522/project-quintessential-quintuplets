package org.bcit.comp2522.project;


public abstract class Sprite implements Drawable {

  protected float xpos;
  protected float ypos;
  protected final Window window;

  public Sprite(float xpos, float ypos, Window window) {
    this.xpos = xpos;
    this.ypos = ypos;
    this.window = window;
  }

  public float getXpos() {
    return xpos;
  }

  public float getYpos() {
    return ypos;
  }

  public void setXpos(float x) {
    xpos = x;
  }

  public void setYpos(float y) {
    ypos = y;
  }

  /**
   * Draws the elements in the window.
   */
  public void draw() {
    float size = 50;
    window.pushStyle();
    window.ellipse(xpos, ypos, size, size);
    window.popStyle();
  }
}