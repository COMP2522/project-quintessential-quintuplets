package org.bcit.comp2522.project;

public class Player {
    private static Player player;
    private static int currentLevel;
    private static int currentScore;
    private static int coins;
   private static int health;

    private Player() {
        currentLevel = 0;
        currentScore = 1000;
        coins = 100;
        health = 10;
    }

    public static int getCurrentLevel() {
        return currentLevel;
    }

    public static void setCurrentLevel(int currentLevel) {
        Player.currentLevel = currentLevel;
    }

    public static int getCurrentScore() {
        return currentScore;
    }

    public static void setCurrentScore(int currentScore) {
        Player.currentScore = currentScore;
    }

    public static int getCoins() {
        return coins;
    }

    public static void setCoins(int coins) {
        Player.coins = coins;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }





    public static Player getInstance() {
        if (player == null) {
            player = new Player();

        }
        return player;

    }

    public static void resetStats() {
        Player.setCoins(0);
        Player.setCoins(10);

    }


}
