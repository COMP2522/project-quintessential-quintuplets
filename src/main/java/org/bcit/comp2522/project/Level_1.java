package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_1 extends Level {
  Window window;
  EnemyManager enemyManager;
  PImage tilemapImg;
  SelectTowerUI selectTowerUI;
  private ArrayList<Tower> towers;
  private BulletManager bulletManager;
  private TileMap tileMap;

  public Level_1(Window window) {
    super(window);
    this.window = window;
    init();
  }

  public void init() {
    tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
    enemyManager = new EnemyManager(window);
    towers = new ArrayList<>();
    bulletManager = new BulletManager(window);
    tileMap = new TileMap(window, getPath(), towers, bulletManager);
    levelManager.setTimeRegularEnemy(0);
    levelManager.setTimeFastEnemy(0);
    levelManager.setTimeBossEnemy(0);
    getPath().clearCorner();
    getPath().addCorner(40, 384);
    getPath().addCorner(376, 384);
    getPath().addCorner(376, 192);
    getPath().addCorner(760, 192);
    getPath().addCorner(760, 384);
    getPath().addCorner(1192, 384);
    getPath().connectCorners();
    tileMap.setPath();
    selectTowerUI = new SelectTowerUI(window, tileMap);
  }

  public void draw() {
    if (Player.getHealth() <= 0) {
      window.setStage(3);

    } else {
      if (super.numEnemies <= 0) {
        window.setStage(4);
      }
      window.background(0);
      window.image(tilemapImg, 40, 0);
      getPath().draw();
      selectTowerUI.draw();
      selectTowerUI.selectTower();
      selectTowerUI.slotClicked();

      // Update the timer
      levelManager.setTimeRegularEnemy(levelManager.getTimeRegularEnemy() + 1);
      levelManager.setTimeFastEnemy(levelManager.getTimeFastEnemy() + 1);
      levelManager.setTimeBossEnemy(levelManager.getTimeBossEnemy() + 1);

      // Check if it's time to spawn a new regular enemy
      if (levelManager.getTimeRegularEnemy() >= 300) { // 300 frames = 5 seconds
        levelManager.setTimeRegularEnemy(0);
        enemyManager.addEnemy(new Beetle(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 2, 2, 2, 2, this));
      }

      // Check if it's time to spawn a new fast enemy
      if (levelManager.getTimeFastEnemy() >= 600) { // 600 frames = 10 seconds
        levelManager.setTimeFastEnemy(0);
        enemyManager.addEnemy(new Locust(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 1, 4, 4, 1, this));
      }

      // Check if it's time to spawn a new boss enemy
      if (levelManager.getTimeBossEnemy() >= 900) { // 900 frames = 15 seconds
        levelManager.setTimeBossEnemy(0);
        enemyManager.addEnemy(new Bee(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 4, 1, 1, 3, this));
      }

    // Update and draw the enemies

    for (Tower tower : towers) {
      tower.draw();
      //tower.inRange(enemyManager);
      tower.shootingEnemy(enemyManager);
      if (tower.isInRange()) {
        window.stroke(255, 0, 0);
      } else {
        window.stroke(0, 0, 0);
      }
    }
    bulletManager.update();
    enemyManager.update(bulletManager);
    window.grid.draw();
    }
  }
}
