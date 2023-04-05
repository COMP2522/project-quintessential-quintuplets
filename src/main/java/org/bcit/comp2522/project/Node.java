package org.bcit.comp2522.project;

public class Node {
  private int xpos;
  private int ypos;
  Node next;

  public Node(int xpos, int ypos) {
    this.xpos = xpos;
    this.ypos = ypos;
    next = null;
  }

  public int getXpos() {
    return xpos;
  }
  public int getYpos() {
    return ypos;
  }
}
