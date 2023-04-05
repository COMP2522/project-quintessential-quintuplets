package org.bcit.comp2522.project;

import  java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Window class that sets up and runs the game window, and contains instances of enemies,
 * bullets, and path objects.
 */
public class Window extends PApplet {

  public static final int windowWidth = 1280;
  public static final int windowHeight = 720;

  ArrayList<Enemy> enemies;
  Bullet testBullet;
  ArrayList<Bullet> bullets;
  Path path;
  LevelManager levelManager;
  Level level_1;
  Level level_2;
  Level level_3;
  ArrayList<Tower> towers;
  EnemyManager enemyManager;

  private String userInput;

  private static PImage background;


  private Menu menu;

  private HighscoreScreen highscoreScreen;
  private WinningScreen ws;

  private LosingScreen ls;

  private int stage;

  private ButtonHandler bh;

  // Variables for the timer
  int timeRegularEnemy = 0;
  int timeFastEnemy = 0;
  int timeBossEnemy = 0;

  Grid grid;

  public Window(){
    userInput = "";
  }

  /**
   * Sets up the game window and initializes objects.
   */
  public void setup() {
    Player.getInstance();
    stage = 1;
    menu = new Menu(this);
    highscoreScreen = new HighscoreScreen(this);
    ws = new WinningScreen(this);
    ls = new LosingScreen(this);
    this.init();

  }

  public void setStage(int stage) {
    this.stage = stage;
  }

  public void setUserInput(String input){
    this.userInput = input;
  }

  public String getUserInput(){
    return userInput;
  }

  /**
   * Initializes objects.
   */
  public void init() {
    background = this.loadImage("src/main/java/org/bcit/comp2522/project/asset/BackDrop.png");
    levelManager = new LevelManager(this, 3);
    level_1 = new Level_1(this);
    level_2 = new Level_2(this);
    level_3 = new Level_3(this);
    grid = new Grid(this);

    levelManager.addLevel(level_1);
    levelManager.addLevel(level_2);
    levelManager.addLevel(level_3);
    enemyManager = new EnemyManager(this);
    // array of bullets
    bullets = new ArrayList<>();

    timeRegularEnemy = 0;
    timeFastEnemy = 0;
    timeBossEnemy = 0;

    enemies = new ArrayList<>();
    towers = new ArrayList<>();
  }

  /**
   * Draws objects on the game window.
   */
  /**
   * Draws objects on the game window.
   */
  public void draw() {
    switch (stage) {
      case 1:
        menu.display();
        break;
      case 2:
        levelManager.draw();
        break;
      case 3:
        ls = new LosingScreen(this);
        ls.display();
        break;
      case 4:
        ws = new WinningScreen(this);
        ws.display();
        break;

      case 5:
        highscoreScreen.refreshHighscores();
        highscoreScreen.display();
        break;

    }
  }

  public void mousePressed() {
    if (stage == 1) {
      menu.mousePressed(mouseX, mouseY);
    }
  }


  /**
   * Sets up the size of the game window.
   */
  public void settings() {
    size(windowWidth, windowHeight);
  }

  public void keyPressed() {
    if (stage != 3 && stage != 4) {
      if (key == 'm' || key == 'M') {
        stage = 1;
        this.init();

      }

      if (key == 'z' || key == 'Z') {
        levelManager.nextLevel();
      }

      if (key == 'w' || key == 'W') {
        levelManager.killEnemies();
      }

      if (key == 'l' || key == 'L') {
        levelManager.killPlayer();
      }


    } else {
      if (userInput == null){
        userInput = "";
      }

      if (Character.isLetter(key)) {
        userInput += key;
        System.out.println(userInput);
      } else {
        if (key == BACKSPACE && userInput.length() > 0){
          userInput = userInput.substring(0, userInput.length() - 1);
          System.out.println(userInput);
        } else {
          if (key == ENTER) {
            ws.logHighscore();
          }
        }
      }
    }
  }
  /**
   * Main method that runs the game.
   *
   * @param passedArgs command line arguments
   */
  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"towerDefence"};
    Window tdGame = new Window();
    PApplet.runSketch(appletArgs, tdGame);

  }

}
