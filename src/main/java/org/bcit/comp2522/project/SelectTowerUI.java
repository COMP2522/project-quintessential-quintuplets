package org.bcit.comp2522.project;

import processing.core.PImage;

public class SelectTowerUI {
  private Window window;
  private PImage inventoryIMG;

  private PImage tower1;

  private TileMap tileMap;
  TowerManager towerManager;

  private int selectedTower;
  public SelectTowerUI(Window window, TileMap tileMap, TowerManager towerManager){
    this.window = window;
    this.tileMap = tileMap;
    inventoryIMG = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/towerslot.png");
    tower1 = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/tower1icon.png").get(0,0,96,96);
    selectedTower = 0;
    this.towerManager = towerManager;
  }

  public void selectTower(){
    //checking if the mouse was pressed at the position of tower slot
    if(window.mousePressed && (window.mouseX > 408 && window.mouseX < 472 && window.mouseY > 608 && window.mouseY < 672)){
      selectedTower = 1;
    }
  }

  public void slotClicked(){
    if (selectedTower != 0 && tileMap.setTower(selectedTower)){
      selectedTower = 0;
    }
  }

  public void draw(){
    window.image(inventoryIMG, 376, 576);
    //window.square(440, 640, 64);
    window.image(tower1, 395, 595,96,96);
  }
}
