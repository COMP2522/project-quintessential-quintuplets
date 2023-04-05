package org.bcit.comp2522.project;

public interface Collidable {
    boolean collide(Object other);

    float getXpos();

    float getYpos();
}
