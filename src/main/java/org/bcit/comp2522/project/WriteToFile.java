package org.bcit.comp2522.project;

import java.io.*;

/**
 * Write game data to local file.
 *
 * @author Cheryl Lau version 1.0 2023
 */
public class WriteToFile {

    public void Write(){


        String data = "Testing";
        FileWriter output;

        {
            try {
                output = new FileWriter("./saveData.txt");

                output.write(data);

                output.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

