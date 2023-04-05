package org.bcit.comp2522.project;

import java.util.ArrayList;

public class TileMap {
  private int[][] map;

  private Path path;

  private ArrayList<Tower> towers;

  private BulletManager bulletManager;
  private final int ROW;
  private final int COL;

  private Window window;
  public TileMap(Window window, Path path, ArrayList<Tower> towers, BulletManager bulletManager){
    this.window = window;
    this.path = path;
    this.towers = towers;
    this.bulletManager = bulletManager;
    ROW = 15;
    COL = 25;
    map = new int[15][25];
    for (int i = 0; i < 15; i++){
      for (int j = 0; j < 25; j++){
        map[i][j] = 0;
      }
    }

  }

  public int[][] getMap() {
    return map;
  }

  public void setPath(){
    Node current = path.getHead();
    while (current != null){
      int x = current.getXpos() - 40;
      int y = current.getYpos();
      int row = y/48;
      int col = x/48;
      map[row][col] = 1;
      current = current.next;
    }
//    System.out.println("Tile check:");
//    for (int i = 0; i < 15; i++){
//      for (int j = 0; j < 25; j++){
//        System.out.print(map[i][j] + " ");
//      }
//      System.out.println();
//    }

  }
  public void checkMap(){

      System.out.println("Tile check:");
      for (int i = 0; i < 15; i++){
        for (int j = 0; j < 25; j++){
          System.out.print(map[i][j] + " ");
        }
        System.out.println();

    }
  }

  public boolean setTower(int selectedTower){
    boolean result = false;
    if (selectedTower != 0) {
      if (window.mousePressed && (window.mouseX > 40 && window.mouseX < 1240) && (window.mouseY > 0 && window.mouseY < 576)) {

        int x = window.mouseX - 40;
        int y = window.mouseY;
        int row = y / 48;
        int col = x / 48;
        if (map[row][col] != 1) {
          map[row][col] = selectedTower;
          towers.add(new Tower(col*48+40, row*48, window, bulletManager));
          System.out.println("Tower placement" + col*48 + ", " + row*48);
          return true;
        } else {
          return false;
        }
      }
    }
    return result;
  }
}
