package org.bcit.comp2522.project;

/**
 The LevelManager class is responsible for managing the levels of the game.
 It keeps track of the current level, the number of levels, and an array of Level objects.
 It also manages the timing of different enemy types, and updates the UI to display important information.
 */
public class LevelManager {
  private static int currentLevel;
  private Level[] levels;
  private Level currentLevelObject;
  private final int numberOfLevels;
  private UI ui;
  private Window window;

  private StateManager sm;

  /**
   Constructs a new LevelManager object.
   @param window the Window object to use for the game UI.
   @param numberOfLevels the total number of levels in the game.
   */
  public LevelManager(Window window, int numberOfLevels) {
    currentLevel = 0;
    this.numberOfLevels = numberOfLevels;
    levels = new Level[numberOfLevels];
    currentLevelObject = levels[0];
    ui = new UI(window);

    ui.setup();
    this.window = window;
    sm = new StateManager(window, this);
  }

  public static void setCurrentLevel(int currentLevel){
    LevelManager.currentLevel = currentLevel;
  }

  public Level getCurrentLevelObject(){
    return currentLevelObject;
  }

  /**
   * Draws the current level.
   */
  public void draw() {
    //System.out.println("drawing level:" + currentLevel);
    levels[currentLevel].draw();
    //ui.setup();
    ui.displayEnemiesDefeated();
    ui.displayLevelNumber();
    ui.displayHP();
    ui.displayCoins();

    }


  public void startThread() {

    if (window.getStage() == 2) {
      Thread thread = new Thread(() -> {
        sm.push(new GameState(Player.getInstance(), window, this));
        while (true) {
          synchronized (sm) {
            sm.mainPull();
          }
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
      thread.start();
    }
  }

    /**
     Advances the game to the next level.
     If the current level is the final level, the game will loop back to the beginning.
     */
  public void nextLevel() {
        if (currentLevel == numberOfLevels - 1) {
      currentLevel = 0;
    } else {
      currentLevel++;
      Player.resetStats();
    }
    levels[currentLevel].init();
  }

  /**
   Adds a new level to the game.
   @param level the Level object to add.
   */
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

  /**
  Returns the current level.
  @return the current level.
  */
  public static int getCurrentLevel() {
    return currentLevel;
  }

  /**
   * This is just a temporary method to kill off enemies to trigger losing
   * function faster for testing purposes.  DELETE LATER
   */
  public void killEnemies() {
    levels[currentLevel].setNumEnemies(0);
  }

  /**
   * This is just a temporary method to kill off player to trigger losing
   * function faster for testing purposes.  DELETE LATER
   */
  public void killPlayer() {
    Player.setHealth(0);
  }
}
