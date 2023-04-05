package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
  * BulletManager.java
  * Manages the bullets in the game.
  *
  * @author Aric Or
  * @version 1.0
  */
public class BulletManager {

  final ArrayList<Bullet> bullets;
  private final Window window;

  /**
    * Constructs a BulletManager object with a Window object.
    *
    * @param window the Window object to associate with the BulletManager
   */
  public BulletManager(Window window) {
    this.window = window;
    bullets = new ArrayList<>();
  }

  public void addBullet(Bullet bullet) {
    bullets.add(bullet);
  }

  public void removeBullet() {
    for (Bullet bullet : bullets) {
      if (bullet.getXpos() >= window.width || bullet.getYpos() >= window.height) {
        bullets.remove(bullet);
        break;
      } else if (bullet.getXpos() <= 0 || bullet.getYpos() <= 0) {
        bullets.remove(bullet);
        break;
      }
      for (Enemy enemy : window.enemies) {
        if (bullet.getXpos() == enemy.getXpos() && bullet.getYpos() == enemy.getYpos()) {
          bullets.remove(bullet);
          break;
        }
      }
    }
  }

  public void update() {
    for (Bullet bullet : bullets) {
      bullet.move();
      bullet.draw();
    }
  }
}