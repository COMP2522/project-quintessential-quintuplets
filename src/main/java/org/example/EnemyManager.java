package org.example;

import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Class that creates all manages all the enemies.
 */
public class EnemyManager extends Enemy {
  private ArrayList<Enemy> enemies;

  int numEnemies;

  public EnemyManager(Color color, int size, PVector position, int health, int speed) {
    super(color, size, position, health, speed);
  }

  public void setup() {
    this.init();
  }

  public void init() {
    enemies = new ArrayList<Enemy>();
    for (int i = 0; i < numEnemies; i++) {
      enemies.add(new Enemy(
                  new Color(208, 9, 9),
                  Math.random(),
                  new PVector(Math.random(0, this.width), Math.random(0, this.height)),
                  Math.random(0, 2),
                  Math.random(2, 10),
                  this
          ));
    }

  }
}
