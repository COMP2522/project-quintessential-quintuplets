package org.example;

import java.awt.*;
import processing.core.PVector;

/**
 * Class that specifies what attributes enemies should contain.
 *
 * @author Victor Vasconcellos
 * @version 1.0
 */
public class Enemy extends Sprite {
  public Enemy(Color color, int size, PVector position, int health, int speed, Window window) {
    super(color, size, position, health, speed, window);
  }

  public void collide() {

  }
}
