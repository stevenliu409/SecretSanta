package com.SecretSanta.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by stevenliu on 2016-01-14.
 */
public class ParserTextFile implements Parser {

    public String[] openFile(String path) throws IOException {

        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        String[] data = new String[readLines(path)];

        for (int i = 0; i < data.length; i++) {
            data[i] = textReader.readLine();
        }

        textReader.close();

        return data;
    }

    private int readLines(String path) throws  IOException {

        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numLines = 0;

        while (textReader.readLine() != null) {
            numLines++;
        }

        textReader.close();
        return numLines;
    }
}
