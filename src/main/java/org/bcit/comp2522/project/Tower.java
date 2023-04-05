package org.bcit.comp2522.project;


import processing.core.PImage;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static processing.core.PApplet.dist;

/**
 * This class represents the towers in the game
 * Contains attributes and methods each tower
 * object should have
 * @author gursidhsandhu
 */
public class Tower extends Sprite implements Collidable{

  private int attackRate;
  private int range;

  private PImage towerSprite1;
  private PImage towerWeapon1;

  private PImage[] towerWeaponSprites = new PImage[6];

  public int getBaseSize() {
    return baseSize;
  }

  // this ensures every tower is same size
  private final int baseSize = 40;

  private int timer;

  private boolean inRange = false;
  private Enemy tracking;

  private boolean standby;

  private int spriteIndex = 0;

  private BulletManager bulletManager;


  public boolean isHovering() {
    return hovering;
  }

  public void setHovering(boolean hovering) {
    this.hovering = hovering;
  }

  public boolean isClicked() {
    return clicked;
  }

  public void setClicked(boolean clicked) {
    this.clicked = clicked;
  }

  private boolean hovering = false;
  private boolean clicked = false;
  private float offsetX;
  private float offsetY;

  private float originalXPos;

  public float getOriginalXPos() {
    return originalXPos;
  }

  public void setOriginalXPos(float originalXPos) {
    this.originalXPos = originalXPos;
  }

  public float getOriginalYPos() {
    return originalYPos;
  }

  public void setOriginalYPos(float originalYPos) {
    this.originalYPos = originalYPos;
  }

  private float originalYPos;


  public float getCenterX() {
    return centerX;
  }

  public void setCenterX(float centerX) {
    this.centerX = centerX;
  }

  public float getCenterY() {
    return centerY;
  }

  public void setCenterY(float centerY) {
    this.centerY = centerY;
  }

  public float getRadius() {
    return radius;
  }

  public void setRadius(float radius) {
    this.radius = radius;
  }

  // These two variables represent the center of the tower
  float centerX = getXpos() + (baseSize/2);
  float centerY = getYpos() - (baseSize/2);
  float radius = findRadius();

  // variable that checks the distance between the mouse position and the towers center
  double distance;

  public Tower(float xpos, float ypos,Window window, BulletManager bulletManager){
    super(xpos, ypos, window);
    towerSprite1 = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/Tower1e.png");
    towerWeapon1 = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/Tower 06 - Level 01 - Weapon.png");
    this.bulletManager = bulletManager;
    radius = 100;
    tracking = null;
    standby = true;
    loadWeaponSprite1();
  }

  public void loadWeaponSprite1() {
    int spriteWidth = 64;
    int spriteHeight = 64;
    int spriteLength = towerWeaponSprites.length;
    for(int i = 0; i < spriteLength; i++) {
      int x = i%spriteLength * spriteWidth;
      towerWeaponSprites[i] = towerWeapon1.get(x, 0, spriteWidth, spriteHeight);
    }
  }



  // drawing criteria for towers
  public void draw(){
    distance = sqrt(pow(window.mouseX - centerX,2) + pow(window.mouseY - centerY,2));
    window.pushStyle();
    window.strokeWeight(2);

    // check if the mouse is close enough to the tower to consider it being hovered by
    // create a white outline to let player know they are hovering over the tower
    if(distance <= radius){
      hovering = true;
      window.stroke(0);
      if(!clicked){
        window.stroke(255);
      }
    }else{
      hovering = false;
    }
    if (!standby){
      timer++;
      window.image(towerWeaponSprites[spriteIndex],getXpos() - 7,getYpos() - 89 + 48);
    } else {
      window.image(towerWeaponSprites[0],getXpos() - 7,getYpos() - 89 + 48);
    }
    System.out.println(tracking);
    drawSprite();
    window.image(towerSprite1,getXpos(),getYpos() - 96 + 48,48,96);
    window.image(towerWeaponSprites[spriteIndex],getXpos() - 7,getYpos() - 89 + 48);
    window.noFill();
    window.circle(getXpos() + 24, getYpos() + 24, radius * 2);
    if (tracking != null) {
      window.circle(tracking.getXpos(), tracking.getYpos(), 10);
    }

    // draw the radius around the tower
    //window.stroke(255,0,0);
    //window.strokeWeight(2);
    //window.noFill();;
    //window.ellipse(centerX, centerY, radius, radius*2);



    window.popStyle();
  }

  public void drawSprite(){
    if (standby){
      spriteIndex = 0;
    } else {
      if (timer % 10 == 0) {
        if (spriteIndex >= towerWeaponSprites.length - 1) {
          spriteIndex = 0;
        } else {
          spriteIndex++;
        }
      }
    }
  }


  // This variable will be used in the method below
  float maxDistance = 0;

  // method that finds the radius around the tower
  // check the distance of every point in the tower from its center coordinates
  // the farthest away point will be the maxDistance from the center
  public float findRadius(){

    // first check all the 4 corners of the square one by one
    for(int i=0; i < 4; i++){
      float x = getXpos() + (i%2) * baseSize;
      float y = getYpos() + (i/2) * baseSize;
      float distance = dist(centerX, centerY, x, y);

      if(distance > maxDistance){
        maxDistance = distance;
      }
    }

    // now check all the corners of the rectangle
    for(int i = 0; i < 4; i++){
      float x = getXpos() + (i%2)*baseSize/2;
      float y = getYpos() - baseSize/4 + (i/2)*baseSize/2;
      float distance = dist(centerX, centerY,x, y);

      if(distance > maxDistance){
        maxDistance = distance;
      }

    }

    // finally check all 3 points of the triangle
    // for the triangle it is easier to just have a condition that matches to each point
    for(int i=0; i < 3; i++){

      float x;
      float y;

      switch(i){

        // first point
        case 0:
          x = getXpos() + baseSize/4;
          y = (float) (getYpos() - baseSize*1.5);
          break;

          // second point
        case 1:
          x = getXpos() + baseSize/2;
          y = (float) (getYpos() - (baseSize*1.5) - (baseSize/2));
          break;

          // third point
        default:
          x = getXpos() + baseSize - (baseSize/4);
          y = (float) (getYpos() - baseSize*1.5);
      }

      float distance = dist(centerX, centerY,x, y);

      if(distance > maxDistance){
        maxDistance = distance;
      }

    }

    float radius = maxDistance;
    // this is now the radius around the tower
    return radius;

  }

  // method that checks if the distance is less than or equal to radius
  // if it is then we assume the mouse is hovering over tower
  public void mousePressed(){
    if(hovering){
      clicked = true;
    } else{
      clicked = false;
    }
    //System.out.println("sets offsets");
    offsetX = window.mouseX - centerX;
    offsetY = window.mouseY - centerY;

  }

  // this method indicates the tower is being dragged by the mouse
  public void mouseDragged(){
    if(clicked){
      //System.out.println("new position");
      centerX = window.mouseX - offsetX;
      setXpos(centerX - (baseSize/2));
      centerY = window.mouseY - offsetY;
      setYpos(centerY + (baseSize/2));
    }
  }

  public void mouseReleased(){
    //System.out.println("not clicked");
    clicked = false;

  }


// method to check if enemy has entered the radius around a tower
  // not complete yet
  @Override
  public boolean collide(Object other) {
    if(other instanceof Enemy) {
      Enemy enemy = (Enemy) other;
      double distanceTwo = sqrt(pow(enemy.getXpos() - this.centerX,2) + pow(enemy.getYpos() - this.centerY,2));
      double distance1 = dist(enemy.getXpos(), enemy.getYpos(), getXpos() + 24, getYpos() + 24);
      if(distance1 <= radius){
        shoot();
        return true;
      }
    }
    return false;
  }
  public void shootingEnemy(EnemyManager enemyManager){
    for (Enemy enemy : enemyManager.getEnemies()) {
      inRange(enemy);
      if (inRange){
        track(enemy);
        shoot();
        break;
      }
    }
  }
  public void shoot(){
    if (timer % 60 == 0) {
      standby = true;
      timer = 0;
      if (tracking != null) {
        float angle = window.atan2(tracking.getYpos() - getYpos(), tracking.getXpos() - getXpos());
        bulletManager.addBullet(new Bullet(getXpos() + 24, getYpos() + 24, window, angle));
        standby = false;
        tracking = null;
      }
    }
  }
  public void inRange(Enemy enemy){
//    for (Enemy enemy : enemyManager.getEnemies()) {
//      double distance = dist(enemy.getXpos(), enemy.getYpos(), getXpos()+ 24, getYpos()+ 24);
//      if (distance <= radius) {
//        inRange = true;
//        break;
//      } else {
//        inRange = false;
//      }
//    }
    double distance = dist(enemy.getXpos()+ 24, enemy.getYpos()+ 24, getXpos(), getYpos());
    if (distance <= radius) {
      inRange = true;
    } else {
      inRange = false;
      tracking = null;
    }
  }

  public void track(Enemy enemy){
    float distance = dist(enemy.getXpos()+ 24, enemy.getYpos()+ 24, getXpos(), getYpos());
    if (distance <= radius) {
      if (tracking != null){
        if (enemy.getXpos() > tracking.getXpos()){
          tracking = enemy;
        }
      } else {
        tracking = enemy;
      }
    }
  }

  public boolean isInRange() {
    return inRange;
  }
}
