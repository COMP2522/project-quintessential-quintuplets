package org.bcit.comp2522.project;

public class LevelManager {
  private static int currentLevel;
  private Level[] levels;
  private Level currentLevelObject;
  private final int numberOfLevels;
  UI ui;

  public LevelManager(Window window, int numberOfLevels) {
    currentLevel = 0;
    this.numberOfLevels = numberOfLevels;
    levels = new Level[numberOfLevels];
    currentLevelObject = levels[0];
    ui = new UI(window);
  }

  public void draw() {
    //System.out.println("drawing level:" + currentLevel);
    levels[currentLevel].draw();
    ui.displayEnemiesDefeated();
    ui.displayLevelNumber();
    ui.displayHP();
    ui.displayCoins();
  }

  public void nextLevel() {
    if (currentLevel == numberOfLevels - 1) {
      currentLevel = 0;

      //currentLevelObject = levels[currentLevel];
    } else {
      currentLevel++;
      Player.resetStats();

      //currentLevelObject = levels[currentLevel];
    }
    levels[currentLevel].init();
  }

  public void addLevel(Level level) {
    int n = 0;
    while (levels[n] != null) {
      if (n == numberOfLevels - 1) {
        return;
      }
      n++;
    }
    levels[n] = level;
  }

  public Level getCurrentLevelObject() {
    return currentLevelObject;
  }

  public static int getCurrentLevel() {
    return currentLevel;
  }

  /**
   * This is just a temporary method to kill off enemies to trigger losing
   * function faster for testing purposes.  DELETE LATER
   */
  public void killEnemies(){
    levels[currentLevel].setNumEnemies(0);
  }

  public void killPlayer(){
    Player.setHealth(0);
  }


}
