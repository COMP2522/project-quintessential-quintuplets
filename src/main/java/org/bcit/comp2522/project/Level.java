package org.bcit.comp2522.project;

public class Level {
  private final Path path;
  private final Window window;
  private StateManager sm;
  LevelManager levelManager;
  private TileMap tileMap;
  protected int numEnemies = 10;
  public Level(Window window){
    this.window = window;
    path = new Path(window);

  }

  public void setNumEnemies(int numEnemies){
    this.numEnemies = numEnemies;
  }
  public Path getPath() {
    return path;
  }

  public Window window() {
    return window;
  }

  public TileMap getTileMap() {
    return tileMap;
  }

  public void reset(){
    path.reset();
  }
  public void init(){
  }
  public void draw(){


  }
}
