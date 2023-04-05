package org.bcit.comp2522.project;

/**
 * Bullet.java
 * Represents the bullets in the game.
 *
 * @author Aric Or
 * @version 1.0
 */
public class Bullet extends Sprite {

  public int getSpeed() {
    return speed;
  }

  private int speed;

  private int size;

  private float angle;

  public int getDamage() {
    return damage;
  }

  private int damage = 1;

  public Bullet(float xpos, float ypos, Window window, float angle) {
    super(xpos, ypos, window);
    this.speed = 10;
    this.size = 10;
    this.angle = angle;
  }

  public int getSize() {
    return size;
  }

  public void move() {
    setXpos(getXpos() + (float) (speed * Math.cos(angle)));
    setYpos(getYpos() + (float) (speed * Math.sin(angle)));
  }

  public void draw() {
    window.fill(0, 255, 0);
    window.circle(getXpos(), getYpos(), 10);
  }

  public void remove() {
    window.bullets.remove(this);
  }

}