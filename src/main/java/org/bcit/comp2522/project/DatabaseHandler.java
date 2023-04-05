package org.bcit.comp2522.project;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseHandler {

    private MongoDatabase database;

    private String username = "testuser";
    private String password = "cake1234";

    public DatabaseHandler(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://" + username + ":" + password + "@2522.ru0dahn.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase("towerDefence");




    }

    public void put(String key, String val, String collectionName){

        Document document = new Document();
        document.append(key, val);
        new Thread(()->database.getCollection(collectionName).insertOne(document)).start();

    }

    public void insertHighScore(String user, int score){
        try {
            database.createCollection("highScores");
        } catch (Exception e) {
            System.out.println("Collection already in database");
        }
        Document document = new Document();
        document.append("user", user)
        .append("score",score);
        new Thread(()->database.getCollection("highScores").insertOne(document)).start();

    }

    public ArrayList<Highscore> retrieveHighScores() {
        FindIterable<Document> cursor = this.database.getCollection("highScores")
                .find()
                .sort(new Document("score", -1).append("user", 1))
                .limit(8);

        ArrayList<Highscore> highscores = new ArrayList<Highscore>();
        for (Document document : cursor) {
            Highscore highscore = new Highscore();
            highscore.setUser(document.getString("user"));
            highscore.setHighscore(document.getInteger("score"));
            highscores.add(highscore);
        }
        return highscores;
    }
//    public static void main(String[] args) {
//
//        DatabaseHandler dbh = new DatabaseHandler("testuser", "cake1234");
//
////        dbh.insertHighScore("cheryl", 1700, "highScores");
////        dbh.insertHighScore("cheryl", 2100, "highScores");
//
//
//
//        //
//        // Document find = dbh.database.getCollection("highScores").find(eq("user", "cheryl")).first();
//
//        //
//        //
//        // System.out.println(find);
//
//
//
////        for (Highscore hs : dbh.retrieveHighScores()){
////            System.out.println(hs.getHighscore());
////        }
//
//
//
//    }


}