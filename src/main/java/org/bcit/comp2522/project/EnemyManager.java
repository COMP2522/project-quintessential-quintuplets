package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * Class that manages all the enemies in the game.
 * It contains an ArrayList of enemies and methods to set up and initialize them.
 */
public class EnemyManager {
  private final ArrayList<Enemy> enemies;
  private final Window window;


  /**
   * Constructs an EnemyManager object with a Window object.
   *
   * @param window the Window object to associate with the EnemyManager
   */
  public EnemyManager(Window window) {
    this.window = window;
    enemies = new ArrayList<>();
  }
  public void addEnemy(Enemy enemy){
    enemies.add(enemy);
  }

  public void removeEnemy(){
    for (Enemy enemy : enemies) {
      if (enemy.getIsDead()) {
        enemies.remove(enemy);
        break;
      }
    }
  }
  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  public void update(BulletManager bulletManager) {
    for (Enemy enemy : enemies) {
      enemy.draw();
      enemy.move();
      enemy.outOfBounds();
      for (Bullet bullet : bulletManager.bullets) {
        enemy.collide(bullet);
      }
    }
    removeEnemy();
  }
}
